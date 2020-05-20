package com.hrtek.user.display.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.user.display.service.BasicService;
import com.hrtek.user.display.views.BasicShowedField;

@Controller
@RequestMapping("/showbasic")
public class BasicController {
	
	@Autowired
	private BasicService basicService;
	
	@GetMapping
	public String showbasci(Model model) {
		
		model.addAttribute("bv_list", basicService.getBasicViewList());
		model.addAttribute("fd", new BasicShowedField());
		return "user/display/basic";
	}
	
	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, @ModelAttribute BasicShowedField fd) {
		System.out.println(fd);

		System.out.println("tuuu");

		model.addAttribute("bv_list", basicService.getBasicViewList());
		model.addAttribute("fd", fd);
		return "user/display/basic";
	}

}
