package com.hrtek.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boss/tasks")
public class BossTaskController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping
	public String toTasks(Model model) {
		taskService.setBossModel(model);
		return "boss/tasks";
	}
	
	@PostMapping
	public String addTasks(@ModelAttribute("task") Task task, Model model) {
		taskService.addNewTask(task);
		taskService.setBossModel(model);
		return "boss/tasks";
	}
	
	@GetMapping("/del/{id}")
	public String removeTask(@PathVariable("id") Long id, Model model) {
		taskService.removetask(id);
		taskService.setBossModel(model);
		return "boss/tasks";
	}
}
