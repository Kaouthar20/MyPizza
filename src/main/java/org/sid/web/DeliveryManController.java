package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.IDeliveryManReporsitory;
import org.sid.entities.DeliveryMan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryManController {

	@Autowired
	private IDeliveryManReporsitory deliveryManRepository;

	// Display a deliveryMan pages
	@GetMapping(path = "/admin/deliveryMan")
	public String listDM(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
		Page<DeliveryMan> pageDeliveryMan = deliveryManRepository.findByfirstNameContains(keyWord,
				PageRequest.of(page, size));
		model.addAttribute("deliveryMan", pageDeliveryMan.getContent());
		model.addAttribute("pages", new int[pageDeliveryMan.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("size", size);
		return "deliveryMan";
	}

	// Delete a deliveryMan
	@GetMapping(path = "/admin/deleteDeliveryMan")
	public String deleteDM(Long id, String keyWord, int page, int size) {
		deliveryManRepository.deleteById(id);
		return "redirect:/admin/deliveryMan?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// create a new deliveryMan
	@GetMapping("/admin/formDM")
	public String form1(Model model) {
		model.addAttribute("deliveryMan", new DeliveryMan());
		model.addAttribute("mode", "new");
		return "FormDM";
	}

	// Save a deliveryMan
	@PostMapping("/admin/save1")
	public String saveDM(@Valid DeliveryMan deliveryMan, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormDM";
		deliveryManRepository.save(deliveryMan);
		return "redirect:/admin/formDM";
	}

	// Update a deliveryMan
	@GetMapping("/admin/updateDM")
	public String updateDM(Model model, Long id) {
		DeliveryMan deliveryMan = deliveryManRepository.findById(id).get();
		model.addAttribute("deliveryMan", deliveryMan);
		model.addAttribute("mode", "update");
		return "/admin/formDM";
	}
}
