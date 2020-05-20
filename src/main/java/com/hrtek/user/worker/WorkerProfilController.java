package com.hrtek.user.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profil")
public class WorkerProfilController {
	
	@Autowired
	private ProfilService profileService;
	@Autowired
	private InUseService inUserService;

	@GetMapping("{id}")
	public String toProfil(@PathVariable("id") Long id, Model model) {
		Available av = inUserService.getAvailable(id);
		model.addAttribute("av", av);
		if(av!=null)
			System.out.println(av);
		profileService.setmodel(id, model);
		return "user/profil/profil";
	}
	
}
