package com.hrtek.user.recruitment;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.files.doc.DocumentService;

@Controller
@RequestMapping("/recruitment")
public class NewWorkerController {

	private RecruitmentService recruitmentService;
	private HireService hireService;
	private DocumentService docService;
	
	@Autowired
	public NewWorkerController(RecruitmentService recruitmentService, HireService hireService,
			DocumentService docService) {
		this.recruitmentService = recruitmentService;
		this.hireService = hireService;
		this.docService = docService;
	}

	@GetMapping
	public String toRecruitment(Model model) {
		NewWorker newWorker = new NewWorker();
		recruitmentService.setModel(model, newWorker);
		
		newWorker.setWage(17.34);
		newWorker.setSWage("siedemnaście złotych, trzydzieści cztery grosze");
		model.addAttribute("newWorker", newWorker);
		model.addAttribute("status", "");
		return "user/hire/recruitment2";
	}
	
	@PostMapping("/select")
	public String selectCanditate(@RequestParam("candidateid") Long id, Model model) {
		NewWorker nw = recruitmentService.selectCandidatAsNewWorker(id);
		nw.setWage(17.34);
		nw.setSWage("siedemnaście złotych, trzydzieści cztery grosze");
		recruitmentService.setModel(model, nw);
		model.addAttribute("newWorker", nw);
		return "user/hire/recruitment2";
	}
	
	@PostMapping(params = "action=hire")
	public String saveNewWorker(@ModelAttribute("newWorker") NewWorker nw, Model model, BindingResult result, HttpSession session) {
		new RecruitmentValidator().validate(nw, result);
		if(result.hasErrors()) {
			model.addAttribute("error_msg", "Coś poszło nie tak");
			model.addAttribute("status", "fail");
		}else {
			hireService.hire(nw, session);
			model.addAttribute("status", "success");
			model.addAttribute("success_msg", "Pomyslnie zatrudniono "+ nw.getFirstname() +" " + nw.getLastname());
		}
		
		recruitmentService.setModel(model, nw);
		model.addAttribute("newWorker", nw);
		return "user/hire/recruitment2";
	}
	
	@PostMapping(params = "action=contract")
	public String generateContract(@ModelAttribute("newWorker") NewWorker nw, Model model, RedirectAttributes ra) {
		recruitmentService.setModel(model, nw);
		model.addAttribute("newWorker", nw);
		
		String path = docService.prepareContract(nw.getId(), nw.getWage(), nw.getSWage());
		ra.addAttribute("filename", path);
		return "redirect:/download";
	}
}
