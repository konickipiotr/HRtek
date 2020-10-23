package com.hrtek.admin.factory;

import java.util.Optional;

import javax.servlet.http.HttpSession;

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
import com.hrtek.db.LogRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.Factory;
import com.hrtek.model.Log;
import com.hrtek.model.StatusFC;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.Msg;

@Controller
@RequestMapping("/admin/newfactory")
public class NewFactoryController {

	private FactoryRepository factoryRepo;
	private LogRepository logRepo;
	
	@Autowired
	public NewFactoryController(FactoryRepository factoryRepo, LogRepository logRepo) {
		this.factoryRepo = factoryRepo;
		this.logRepo = logRepo;
	}

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
									HttpSession session,
									Model  model) {
		String logmsg = "";
		if(type.equals("new")) {
			new NewFactoryValidator(factoryRepo).validate(factory, result);
			if(result.hasErrors()) {
				model.addAttribute("factory", factory);
				model.addAttribute("type", "new");
				return "admin/newfactory";
			}
			logmsg = Msg.newFactory + factory.toString();
		}else {
			Optional<Factory> fac = factoryRepo.findById(factory.getId());
			if(fac.isEmpty()) {
				return "redirect:/admin/factory";
			}
			new EditFactoryValidator(factoryRepo, fac.get());  //TODO do przemyslenia
			if(result.hasErrors()) {
				return "admin/newfactory";
			}
			logmsg = Msg.modifiedFactory + fac.get().toString() + "<br /> to: </br />" + factory.toString();
		}
		factory.setStatus(StatusFC.ENABLED);
		this.factoryRepo.save(factory);
		model.addAttribute("factory_list", factoryRepo.findAll());
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg , LogType.MODIFY));
		return "admin/factory";
		
	}
}
