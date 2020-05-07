package com.hrtek.admin.factory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.db.FactoryRepository;
import com.hrtek.model.Factory;

@Controller
@RequestMapping("/admin/newfactory")
public class NewFactoryController {
	
	@Autowired
	public FactoryRepository factoryRepo;

	@GetMapping
	public String tonewfactory(Model model) {
		model.addAttribute("factory", new Factory());
		model.addAttribute("type", "new");
		return "admin/newfactory";
	}
	
	@PostMapping
	public String addNewFactory(@ModelAttribute("factory") Factory factory, 
									@RequestParam("type") String type,
									BindingResult result,
									Model  model) {
		
		if(type.equals("new")) {
			new NewFactoryValidator(factoryRepo).validate(factory, result);
			if(result.hasErrors()) {
				model.addAttribute("factory", factory);
				model.addAttribute("type", "new");
				return "admin/newfactory";
			}
		}else {
			Optional<Factory> fac = factoryRepo.findById(factory.getId());
			if(fac.isEmpty()) {
				return "redirect:/admin/factory";
			}
			new EditFactoryValidator(factoryRepo, fac.get());  //TODO do przemyslenia
			if(result.hasErrors()) {
				return "admin/newfactory";
			}
		}
		
		this.factoryRepo.save(factory);
		model.addAttribute("factory_list", factoryRepo.findAll());
		return "admin/factory";
		
	}
}
