package com.hrtek;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String toLoginPage() {
		return "login";
	}
	
	@GetMapping("/")
	public String toUserHome() {
		return "user/home";
	}
	
	@GetMapping("/boss")
	public String toBossHome() {
		return "boss/home";
	}
}
