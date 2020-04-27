package com.hrtek.admin.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FactoryController {
	
	@Autowired
	private FactoryService factoryService;
	
	@GetMapping(path = "/admin/factory")
	public String showFactories(Model model) {
		model.addAttribute("factory_list", factoryService.factoryRepo.findAll());
		return "admin/factory";
	}

}
