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
import com.hrtek.model.StatusFC;

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
	
	@GetMapping(path = "/enable/{id}")
	public String enableFactory(@PathVariable("id") Long id) {
		Optional<Factory> oFactory = this.factoryRepo.findById(id);
		if(oFactory.isPresent()) {
			Factory factory = oFactory.get();
			factory.setStatus(StatusFC.ENABLED);
			this.factoryRepo.save(factory);
		}

		return "redirect:/admin/factory";
	}
	
	@GetMapping(path = "/disable/{id}")
	public String disablleFactory(@PathVariable("id") Long id, Model model) {
		Optional<Factory> oFactory = this.factoryRepo.findById(id);
		if(oFactory.isPresent()) {
			Factory factory = oFactory.get();
			if(factory.getNumberofwokers() == 0) {
				factory.setStatus(StatusFC.DISABLED);
				this.factoryRepo.save(factory);
			}
			else
				model.addAttribute("error_msg", "Nie można dezaktywować fabryki dopóki pracuje w niej co najmniej jeden pracownik");
			
		}

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
