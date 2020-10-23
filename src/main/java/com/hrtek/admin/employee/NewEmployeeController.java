package com.hrtek.admin.employee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.db.LogRepository;
import com.hrtek.db.MyNoteRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.enums.LogType;
import com.hrtek.enums.UserStatus;
import com.hrtek.files.doc.CredentialsDoc;
import com.hrtek.files.doc.SaveFile;
import com.hrtek.model.Log;
import com.hrtek.model.MyNote;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.settings.Msg;

@Controller
@RequestMapping("/admin/newemployee")
public class NewEmployeeController {
	
	private UserPositonsRepository userPostionRepo;
	private UserInfoRepository userInfoRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private MyNoteRepository myNoteRepo;
	private LogRepository logRepo;

	@Autowired
	public NewEmployeeController(UserPositonsRepository userPostionRepo, UserInfoRepository userInfoRepository,
			UserRepository userRepository, PasswordEncoder passwordEncoder, MyNoteRepository myNoteRepo,
			LogRepository logRepo) {
		this.userPostionRepo = userPostionRepo;
		this.userInfoRepository = userInfoRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.myNoteRepo = myNoteRepo;
		this.logRepo = logRepo;
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

		UserPostions userP = userPostionRepo.findByPosition(GlobalSettings.agent);
		if(nem.getPosition() == userP.getId()) {
			User user = new User(nem);
			user.setPassword(passwordEncoder.encode("xxx"));
			user.setStatus(UserStatus.INACTIVE);
			this.userRepository.save(user);
			
			UserInfo userI = new UserInfo(nem, user);
			this.userInfoRepository.save(userI);
			this.myNoteRepo.save(new MyNote(user.getId()));
			return "redirect:/admin/employees";
		}
		model.addAttribute("newEmployeeModel", nem);
		return "admin/newemployee2";
	}
	
	@PostMapping("/add")
	public String addToDataBase(@ModelAttribute("newEmployeeModel") NewEmployeeModel nem, 
										BindingResult result,
										HttpSession session,
										Model model) {
		new CredentialValidator(userRepository).validate(nem, result);
		model.addAttribute("newEmployeeModel", nem);
		if(result.hasErrors()) {
			return "admin/newemployee2";
		}
		
		User user = new User(nem);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
		
		UserInfo userI = new UserInfo(nem, user);
		this.userInfoRepository.save(userI);
		this.myNoteRepo.save(new MyNote(user.getId()));
		
		
		model.addAttribute("id", user.getId());
		model.addAttribute("pass", nem.getPassword());
		return "admin/newemployeesummary";
	}
	
	private List<UserPostions> getPositionList() {
		List<UserPostions> positons = userPostionRepo.findAll();
		for(int i = 0; i < positons.size(); i++) {
			if(positons.get(i).getPosition().equals("Boss")) {
				positons.remove(i);
				i--;
			}
		}
		return positons;
	}
	
	@PostMapping("/download")
	public String downloadCredetial(@RequestParam("id") Long id, @RequestParam("pass") String pass, RedirectAttributes ra) {
		User user = userRepository.findById(id).get();
		UserInfo userinfo = userInfoRepository.findById(id).get();
		CredentialsDoc cd = new CredentialsDoc(user, userinfo, pass);
		cd.prepareDoc();
		SaveFile sfile = new SaveFile();
		String path = sfile.saveDoc(cd);
		ra.addAttribute("filename", path);
		return "redirect:/download";		
	}
}
