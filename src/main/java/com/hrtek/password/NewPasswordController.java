package com.hrtek.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.db.UserRepository;
import com.hrtek.enums.UserStatus;
import com.hrtek.model.User;

@Controller
@RequestMapping("/firstlogin")
public class NewPasswordController {
	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public NewPasswordController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	public String firstlogin(@ModelAttribute("passwordForm") PasswordForm passwordForm,
								@RequestParam("id") Long id,
								BindingResult result,
								Model model) {
		
		User user = userRepo.findById(id).get();
		new NewPasswordValidator(user, passwordEncoder).validate(passwordForm, result);
		
		if(result.hasErrors()) {
			model.addAttribute("passwordForm", passwordForm);
			model.addAttribute("login", user.getUsername());
			model.addAttribute("id", user.getId());
			return "firstlogin";
		}
		
		user.setPassword(passwordEncoder.encode(passwordForm.getNewpassword1()));
		user.setStatus(UserStatus.ACTIVE);
		this.userRepo.save(user);
		return "redirect:/init";
	}
	
}
