package com.hrtek.admin.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;

@Controller
@RequestMapping("/admin/newemployee")
public class NewEmployeeController {
	
	private UserPositonsRepository userPostionRepo;
	private UserInfoRepository userInfoRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public NewEmployeeController(UserPositonsRepository userPostionRepo, UserInfoRepository userInfoRepository,
			UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userPostionRepo = userPostionRepo;
		this.userInfoRepository = userInfoRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	public String newEmplyeePersona(Model model) {
		model.addAttribute("newEmployeeModel", new NewEmployeeModel());
		
		List<UserPostions> positons = userPostionRepo.findAll();
		for(int i = 0; i < positons.size(); i++) {
			if(positons.get(i).getPosition().equals("Admin") || positons.get(i).getPosition().equals("Boss")) {
				positons.remove(i);
				i--;
			}
		}
		model.addAttribute("positions", positons);
		return "admin/newemployee1";
	}
	
	@PostMapping
	public String newEmployeeCredential(@ModelAttribute("newEmployeeModel") NewEmployeeModel nem, Model model) {

		if(userInfoRepository.existsByFirstnameAndLastname(nem.getFirstname(), nem.getLastname())) {
			model.addAttribute("msg_warrning", "Osoba " + nem.getFirstname() + " " + nem.getLastname() +" znajduje sie w bazie");
		}else {
			nem.setUsername(nem.getLastname().toLowerCase() + nem.getFirstname().toLowerCase());
		}
		model.addAttribute("newEmployeeModel", nem);
		return "admin/newemployee2";
	}
	
	@PostMapping("/add")
	public String addToDataBase(@ModelAttribute("newEmployeeModel") NewEmployeeModel nem, 
										BindingResult result,
										Model model) {
		new CredentialValidator(userRepository).validate(nem, result);
		model.addAttribute("newEmployeeModel", nem);
		if(result.hasErrors()) {
			return "admin/newemployee2";
		}
		
		User user = new User(nem);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
		
		this.userInfoRepository.save(new UserInfo(nem, user));
		return "admin/newemployeesummary";
	}
}
