package com.hrtek.Tasks;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class UserTaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/{status}/{id}")
	public String newStatus(@PathVariable("status") TaskStatus status, @PathVariable("id") Long id, Principal principal) {
		taskService.newstatus(id, status, principal.getName());
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String removeTask(@PathVariable("id") Long id, Principal principal) {
		taskService.removeMytask(id, principal.getName());
		return "redirect:/";
	}
	
	@PostMapping
	public String addTask(@ModelAttribute("task") Task task) {
		System.out.println(task);
		taskService.addNewTask(task);
		return "redirect:/";
	}
}
