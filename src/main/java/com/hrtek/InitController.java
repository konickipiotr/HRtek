package com.hrtek;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.enums.UserStatus;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.password.PasswordForm;
import com.hrtek.settings.InitService;

@Controller
public class InitController {
	
	private UserInfoRepository userInfoRepo;
	private UserRepository userRepo;
	private InitService initService;

	@Autowired
	public InitController(UserInfoRepository userInfoRepo, UserRepository userRepo, InitService initService) {
		this.userInfoRepo = userInfoRepo;
		this.userRepo = userRepo;
		this.initService = initService;
	}


	@GetMapping("/init")
	public String userInit(Principal principal, HttpSession session, Model model) {
		initService.initHRtek();
		
		User user = userRepo.findByUsername(principal.getName());
		UserInfo userInfo = userInfoRepo.findById(user.getId()).get();
		session.setAttribute("user", userInfo);
		session.setAttribute("ROLE", user.getRoles());
		
		if(user.getStatus() == UserStatus.FIRSTLOGIN) {
			model.addAttribute("login", user.getUsername());
			model.addAttribute("id", user.getId());
			model.addAttribute("passwordForm", new PasswordForm());
			return "firstlogin";
		}
		
		if(user.getRoles().equals("BOSS")) return "redirect:/boss";
		if(user.getRoles().equals("ADMIN")) return "redirect:/admin";
		return "redirect:/";
	}
}
