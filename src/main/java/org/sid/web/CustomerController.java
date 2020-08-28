package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.ICustomerRepository;
import org.sid.entities.Customer;
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
public class CustomerController {
	@Autowired
	private ICustomerRepository customerRepository;

	// Customer list
	@GetMapping(path = "/admin/customer")
	public String listCS(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
		Page<Customer> pageCustomer = customerRepository.findByfirstNameContains(keyWord, PageRequest.of(page, size));
		model.addAttribute("customer", pageCustomer.getContent());
		model.addAttribute("pages", new int[pageCustomer.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("size", size);
		return "customer";
	}

	// Delete a customer
	@GetMapping(path = "/admin/deleteCustomer")
	public String deleteCS(Long id, String keyWord, int page, int size) {
		customerRepository.deleteById(id);
		return "redirect:/admin/customer?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// Create a new customer
	@GetMapping("/user/formCS")
	public String form3(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("mode", "new");
		return "FormCS";
	}

	// Save a customer
	@PostMapping("/user/save3")
	public String saveCS(Model model, @Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormCS";
		customerRepository.save(customer);
		model.addAttribute("customer", customer);
		return "confirmation";
	}

	// Update a customer
	@GetMapping("/admin/updateCS")
	public String updateCS(Model model, Long id) {
		Customer customer = customerRepository.findById(id).get();
		model.addAttribute("customer", customer);
		model.addAttribute("mode", "update");
		return "FormCS";
	}

}
