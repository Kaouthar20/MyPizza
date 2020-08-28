package org.sid.web;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.IOrderRepository;
import org.sid.dao.IPizzaRepository;
import org.sid.entities.Orders;
import org.sid.entities.Pizza;
import org.sid.form.FormulaireOrder;
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
public class OrderController {

	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private IPizzaRepository pizzaRepository;

	// Orders list
	@GetMapping(path = "/admin/order")
	public String listOR(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size) {
		Page<Orders> pageOrder = orderRepository.findAll(PageRequest.of(page, size));
		model.addAttribute("order", pageOrder);
		model.addAttribute("pages", new int[pageOrder.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		return "myOrders";
	}

	// Delete an Order
	@GetMapping(path = "/admin/deleteOrder")
	public String deleteOR(Long id, String keyWord, int page, int size) {
		orderRepository.deleteById(id);
		return "redirect:/admin/order?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// Create an Order
	@GetMapping("/user/formOR")
	public String form6(Model model) {
		model.addAttribute("order", new FormulaireOrder());
		model.addAttribute("mode", "new");
		return "FormOR";
	}

	// Save an Order
	@PostMapping("/user/save6")
	public String saveOR(FormulaireOrder order, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormOR";
		Long idPizza = order.getIdPizza();
		Pizza pizza = pizzaRepository.findById(idPizza).get();

		List<Pizza> listPizza = new ArrayList<>();
		listPizza.add(pizza);
		Orders orderToSave = new Orders();
		orderToSave.setPizzas(listPizza);
		//orderToSave.setStatus(order.getStatus());
		orderToSave.setDateOrder(order.getDateOrder());
		orderToSave.setAmount(order.getAmount());
		orderRepository.save(orderToSave);

		return "redirect:/user/formOR";
	}

	// Save an Order
	@GetMapping("/user/createOrder")
	public String createOP(Long idPizza, Model model) {
		model.addAttribute("order", new Orders());
		model.addAttribute("idPizza", idPizza);

		return "FormOR";
	}

	@GetMapping("/admin/updateOR")
	public String updateOR(Model model, Long id) {
		Orders order = orderRepository.findById(id).get();
		model.addAttribute("order", order);
		model.addAttribute("mode", "update");
		return "FormOR";
	}
}
