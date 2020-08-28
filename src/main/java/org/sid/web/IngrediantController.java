package org.sid.web;

import javax.validation.Valid;
import org.sid.dao.IIngrediantRepository;
import org.sid.entities.Ingrediant;
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
public class IngrediantController {
	@Autowired
	private IIngrediantRepository ingrediantRepository;

// Ingrediant list
	@GetMapping(path = "/user/ingrediant")
	public String listIng(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
		Page<Ingrediant> pageIngrediant = ingrediantRepository.findBynameIngContains(keyWord,
				PageRequest.of(page, size));
		model.addAttribute("ingrediant", pageIngrediant.getContent());
		model.addAttribute("pages", new int[pageIngrediant.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("size", size);
		return "ingrediant";
	}

	// Delete an Ingrediant
	@GetMapping(path = "/admin/deleteIngrediant")
	public String deleteIng(Long id, String keyWord, int page, int size) {
		ingrediantRepository.deleteById(id);
		return "redirect:/user/ingrediant?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// Create a new Ingrediant
	@GetMapping("/admin/formIng")
	public String form4(Model model) {
		model.addAttribute("ingrediant", new Ingrediant());
		model.addAttribute("mode", "new");
		return "FormIng";
	}

	// Save an Ingrediant
	@PostMapping("/admin/save4")
	public String saveIng(@Valid Ingrediant ingrediant, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormIng";
		ingrediantRepository.save(ingrediant);
		return "redirect:/admin/formIng";
	}

	// Update an Ingrediant
	@GetMapping("/admin/updateIng")
	public String updateIng(Model model, Long id) {
		Ingrediant ingrediant = ingrediantRepository.findById(id).get();
		model.addAttribute("ingrediant", ingrediant);
		model.addAttribute("mode", "update");
		return "FormIng";
	}

}
