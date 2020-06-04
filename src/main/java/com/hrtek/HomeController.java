package com.hrtek;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrtek.Tasks.Task;
import com.hrtek.model.MyNote;

@Controller
public class HomeController {

	@Autowired
	private UserHomeService userHomeService;
	
	@GetMapping("/login")
	public String toLoginPage() {
		return "login";
	}
	
	@GetMapping("/")
	public String toUserHome(Model model, Principal principa) {
		model.addAttribute("tasks", userHomeService.getBossTasks(principa.getName()));
		model.addAttribute("myTasks", userHomeService.getMyTasks(principa.getName()));
		model.addAttribute("myNote", userHomeService.getMyNote(principa.getName()));
		model.addAttribute("task", new Task());
		return "user/home";
	}
	
	@PostMapping("/savenote")
	public String saveNote(@ModelAttribute("myNote") MyNote myNote) {
		userHomeService.saveMyNote(myNote);
		return "redirect:/";
	}
	
	@GetMapping("/boss")
	public String toBossHome() {
		return "boss/home";
	}
}
