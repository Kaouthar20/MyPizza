package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.IPizzaRepository;
import org.sid.entities.Pizza;
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
public class PizzaController {
	@Autowired
	private IPizzaRepository pizzaRepository;

	@GetMapping(path = "index")
	public String index() {

		return "index";
	}

	@GetMapping("/user/pizza")
	public String listPizza(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {

		Page<Pizza> pagepizzas = pizzaRepository.search(keyWord, PageRequest.of(page, size));
		model.addAttribute("pizzas", pagepizzas.getContent());
		model.addAttribute("pages", new int[pagepizzas.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("size", size);
		return "pizzas";
	}

	@GetMapping("/admin/deletePizza")
	public String delete(Long id, String keyWord, String page, String size) {
		pizzaRepository.deleteById(id);
		return "redirect:/user/pizza?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	@GetMapping("/admin/formPizza")
	public String form(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "FormPizza";
	}

	@PostMapping("/admin/save")
	public String save(Model model, @Valid Pizza pizza, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormPizza";
		pizzaRepository.save(pizza);
		return "redirect:/user/pizza";
	}

	@GetMapping("/admin/edit")
	public String edit(Model model, Long id) {
		Pizza pizza = pizzaRepository.findById(id).get();
		model.addAttribute("pizza", pizza);
		return "EditPizza";
	}

	@GetMapping("/")
	public String def() {

		return "redirect:/user/pizza";
	}

	@GetMapping("/403")
	public String notAutorized() {

		return "403";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

}
