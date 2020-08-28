
package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.IBillRepository;
import org.sid.entities.Bill;
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
public class BillControler {
	@Autowired
	private IBillRepository billRepostory;

	// Display bill list
	@GetMapping("/user/bill")
	public String listBill(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		Page<Bill> pageBill = billRepostory.findAll(PageRequest.of(page, size));
		model.addAttribute("bill", pageBill);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[pageBill.getTotalPages()]);
		return "bill";
	}

	// Delete a bill
	@GetMapping(path = "/admin/deleteBill")
	public String deleteBill(Long id, String keyWord, int page, int size) {
		billRepostory.deleteById(id);
		return "redirect:/user/bill?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// Create a new bill
	@GetMapping("/admin/formBill")
	public String form5(Model model) {
		model.addAttribute("bill", new Bill());
		model.addAttribute("mode", "new");
		return "FormBill";
	}

	// Save a bill
	@PostMapping("/admin/save5")
	public String saveBill(@Valid Bill bill, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormBill";
		billRepostory.save(bill);
		return "redirect:/admin/formBill";
	}

	// Update a bill
	@GetMapping("/admin/updateBill")
	public String updateBill(Model model, Long id) {
		Bill bill = billRepostory.findById(id).get();
		model.addAttribute("bill", bill);
		model.addAttribute("mode", "update");
		return "FormBill";
	}

}
