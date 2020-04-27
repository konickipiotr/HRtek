package com.hrtek;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

@Controller
public class InitController {
	
	private UserInfoRepository userInfoRepo;
	private UserRepository userRepo;

	@Autowired
	public InitController(UserInfoRepository userInfoRepo, UserRepository userRepo) {
		this.userInfoRepo = userInfoRepo;
		this.userRepo = userRepo;
	}

	@GetMapping("/init")
	public String userInit(Principal principal, HttpSession session) {
		User user = userRepo.findByUsername(principal.getName());
		UserInfo userInfo = userInfoRepo.findById(user.getId()).get();
		session.setAttribute("user", userInfo);
		
		if(user.getRoles().equals("BOSS")) return "redirect:/boss/";
		if(user.getRoles().equals("ADMIN")) return "redirect:/admin/";
		return "redirect:/";
	}
}
