package org.sid.web;

import javax.validation.Valid;
import org.sid.dao.IServerRepository;
import org.sid.entities.Server;
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
public class ServerController {

	@Autowired
	private IServerRepository serverRepository;

	// Method display
	@GetMapping(path = "/admin/servers")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String kw) {
		Page<Server> pageServers = serverRepository.findBylastNameContains(kw, PageRequest.of(page, size));
		model.addAttribute("servers", pageServers.getContent());
		model.addAttribute("pages", new int[pageServers.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyWord", kw);
		model.addAttribute("size", size);
		return "servers";
	}

	// Method delete
	@GetMapping(path = "/deleteServer")
	public String deleteS(Long id, String keyWord, int page, int size) {
		serverRepository.deleteById(id);
		return "redirect:/admin/servers?page=" + page + "&keyWord=" + keyWord + "&size=" + size;
	}

	// Method new form
	@GetMapping("/admin/formSR")
	public String form2(Model model) {
		model.addAttribute("server", new Server());
		model.addAttribute("mode", "new");
		return "FormSR";
	}

	// Method save
	@PostMapping("/admin/save2")
	public String saveSR(@Valid Server server, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormSR";
		serverRepository.save(server);
		return "redirect:/admin/formSR";
	}

	// Method update
	@GetMapping("/admin/update")
	public String update(Model model, Long id) {
		Server server = serverRepository.findById(id).get();
		model.addAttribute("server", server);
		model.addAttribute("mode", "update");
		return "FormSR";
	}

}
