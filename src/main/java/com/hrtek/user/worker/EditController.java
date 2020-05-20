package com.hrtek.user.worker;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.model.UserInfo;
import com.hrtek.model.worker.Worker;
import com.hrtek.user.recruitment.WorkerAll;

@Controller
@RequestMapping("/profiledit")
public class EditController {
	
	private InUseService inUseService;
	private ProfilService profileService;
	private EditService editService;
	
	public EditController(InUseService inUseService, ProfilService profileService, EditService editService) {
		this.inUseService = inUseService;
		this.profileService = profileService;
		this.editService = editService;
	}

	@GetMapping("/{type}/{id}")
	public String toEdit(@PathVariable("type") UsedTable usedTable,
							@PathVariable("id") Long workerid,
							HttpSession session,
							Model model) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		if(!inUseService.lockup(user, workerid, usedTable)){
			profileService.setmodel(workerid, model);
			return "user/profil/profil";
		}
		
		setModel(model, workerid,  usedTable );
		return "user/profil" + getPath(usedTable);	
	}
	
	@PostMapping
	public String saveChanges(@RequestParam("type") UsedTable type, @ModelAttribute("workerall") WorkerAll all, HttpSession session) {
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		System.out.println(type);
		editService.update(type, all);
		inUseService.unlock(all.getId(), type, user.getId());
		return "redirect:/profil/" + all.getId();
	}
	
	private void setModel(Model model, Long workerid, UsedTable useTable) {
		switch (useTable) {
		case WORKER: editService.setWorkerModel(workerid, model);break;
		case BASIC: editService.setBasicModel(workerid, model);break;
		case DATE: editService.setDatetModel(workerid, model);break;
		case RESIDENCY: editService.setResidencytModel(workerid, model);break;
		case FINANCE: editService.setFinanceModel(workerid, model);break;
		case PERMIT: editService.setPermitModel(workerid, model);break;
		case STATEMENT: editService.setStatementModel(workerid, model);break;
		case CONTACT: editService.setContactModel(workerid, model);break;
		case ADDRESSPL: editService.setAddressPlModel(workerid, model);break;
		case ADDRESS: editService.setContactModel(workerid, model);break;
		default:
			break;
		}
	}
	
	private String getPath(UsedTable usedTable) {
		switch (usedTable) {
		case WORKER:return "/editWorker";
		case BASIC:return "/editBasic";
		case DATE:return "/editDate";
		case RESIDENCY:return "/editResidency";
		case FINANCE:return "/editFinance";
		case PERMIT:return "/editPermint";
		case STATEMENT:return "/editStatement";
		case CONTACT:return "/editContact";
		case ADDRESSPL:return "/editAddresspl";
		case ADDRESS:return "/editAddress";
		default:
			return null;
		}
	}
}
