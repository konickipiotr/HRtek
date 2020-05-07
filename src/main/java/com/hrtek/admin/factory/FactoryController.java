package com.hrtek.admin.factory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrtek.db.FactoryRepository;
import com.hrtek.model.Factory;

@Controller
@RequestMapping("/admin/factory")
public class FactoryController {
	
	@Autowired
	public FactoryRepository factoryRepo;
	
	@GetMapping
	public String showFactories(Model model) {
		model.addAttribute("factory_list", factoryRepo.findAll());
		return "admin/factory";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteFactory(@PathVariable("id") Long id) {
		this.factoryRepo.deleteById(id);
		//TODO usunąć fabrykę z workersów
		return "redirect:/admin/factory";
	}
	
	@GetMapping("/edit/{id}")
	public String toEdit(@PathVariable("id") Long id, Model model) {
		Optional<Factory> factory = factoryRepo.findById(id);
		if(factory.isEmpty()) {
			return "redirect:/admin/factory";
		}
		model.addAttribute("factory", factory.get());
		model.addAttribute("type", "update");
		return "admin/newfactory";		
	}
	

}
