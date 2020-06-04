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

import com.hrtek.db.MyNoteRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.MyNote;
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
	private MyNoteRepository myNoteRepo;

	@Autowired
	public NewEmployeeController(UserPositonsRepository userPostionRepo, UserInfoRepository userInfoRepository,
			UserRepository userRepository, PasswordEncoder passwordEncoder, MyNoteRepository myNoteRepo) {
		this.userPostionRepo = userPostionRepo;
		this.userInfoRepository = userInfoRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.myNoteRepo = myNoteRepo;
	}

	@GetMapping
	public String newEmplyeePersona(Model model) {
		model.addAttribute("newEmployeeModel", new NewEmployeeModel());
		model.addAttribute("positions", getPositionList());
		return "admin/newemployee1";
	}
	
	@PostMapping
	public String newEmployeeCredential(@ModelAttribute("newEmployeeModel") NewEmployeeModel nem, Model model) {
		if((nem.getPhone() == null || nem.getPhone().isBlank()) && (nem.getEmail() == null || nem.getEmail().isBlank())) {
			model.addAttribute("positions", getPositionList());
			model.addAttribute("error_msg", "Dane kontaktowe nie zostały wypełnione");
			model.addAttribute("newEmployeeModel", nem);
			return "admin/newemployee1";
		}
		
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
		this.myNoteRepo.save(new MyNote(user.getId()));
		return "admin/newemployeesummary";
	}
	
	private List<UserPostions> getPositionList() {
		List<UserPostions> positons = userPostionRepo.findAll();
		for(int i = 0; i < positons.size(); i++) {
			if(positons.get(i).getPosition().equals("Admin") || positons.get(i).getPosition().equals("Boss")) {
				positons.remove(i);
				i--;
			}
		}
		return positons;
	}
}
