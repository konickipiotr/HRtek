package com.hrtek.user.recruitment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.files.FilesService;
import com.hrtek.model.worker.Worker;
import com.hrtek.user.dismissed.HireAginService;

@Controller
@RequestMapping("/recruitment")
public class OtherDataController {
	
	private HireService hireService;
	private RecruitmentService recruitmentService;
	private FilesService filesService;
	private HireAginService hireAginService;

	@Autowired
	public OtherDataController(HireService hireService, RecruitmentService recruitmentService,
			FilesService filesService, HireAginService hireAginService) {
		this.hireService = hireService;
		this.recruitmentService = recruitmentService;
		this.filesService = filesService;
		this.hireAginService = hireAginService;
	}

	@PostMapping(params = "action=other")
	public String toOthers(@RequestParam("id") Long id,  Model model) {
		
		WorkerAll workerAll = hireService.prepareWorkerAll(id);
		recruitmentService.setOtherDataModel(model, workerAll);
		
		model.addAttribute("workerAll", workerAll);
		return "user/hire/recruitment3";
	}
	
	@PostMapping(params = "action=saveothers")
	public String saveOthers(@ModelAttribute("workerAll") WorkerAll workerAll, Model model, BindingResult result, @RequestParam("uploadFiles") MultipartFile[] uploadFiles, HttpSession session) {

		new AllWorkerDataValidator().validate(workerAll, result);
		model.addAttribute("workerAll", workerAll);
		if(result.hasErrors()) {
			model.addAttribute("error_msg", "Coś poszło nie tak");
			recruitmentService.setOtherDataModel(model, workerAll);
			return "user/hire/recruitment3";
		}else {
			Worker worker = hireService.updateWorker(workerAll, session);
			if(worker != null)
				filesService.uploadWorkerFiles(uploadFiles, worker);
			return "redirect:/profil/" + workerAll.getId();
		}
	}
	
	@PostMapping(params = "action=hireagain")
	public String hireagainsave(@ModelAttribute("workerAll") WorkerAll workerAll, Model model, BindingResult result, @RequestParam("uploadFiles") MultipartFile[] uploadFiles, HttpSession session) {
		Long oldid = workerAll.getId();
		new AllWorkerDataValidator().validate(workerAll, result);
		model.addAttribute("workerAll", workerAll);
		if(result.hasErrors()) {
			model.addAttribute("error_msg", "Coś poszło nie tak");
			recruitmentService.setOtherDataModel(model, workerAll);
			model.addAttribute("hireagain", true);
			return "user/hire/recruitment3";
		}else {
			Worker worker = hireService.hireAgain(workerAll, session);
			if(worker != null) {
				filesService.uploadWorkerFiles(uploadFiles, worker);
				filesService.copyWorkerDate_HireAgain(worker, oldid);
			}
			return "redirect:/profil/" + worker.getId();
		}
	}
	
	

	
}
