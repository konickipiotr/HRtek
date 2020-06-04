package com.hrtek.user.recruitment;

import java.time.LocalDate;

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

import com.hrtek.files.FilesService;
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
		
		///// TEST
		NewWorker newWorker = new NewWorker();
		newWorker.setFirstname("Adam");
		newWorker.setLastname("Jakubowski");
		newWorker.setSex("M");
		newWorker.setDateofbirth(LocalDate.of(1990, 05, 25));
		newWorker.setPassport("Pas123123");
		newWorker.setEmail("adam@mail.com");
		model.addAttribute("newWorker", newWorker);
		recruitmentService.setModel(model, newWorker);
		
		//model.addAttribute("newWorker", new NewWorker());
		newWorker.setWage(17.34);
		newWorker.setSWage("siedemnaście złotych, trzydzieści cztery grosze");
		return "user/hire/recruitment2";
	}
	
	@PostMapping("/select")
	public String selectCanditate(@RequestParam("candidateid") Long id, Model model) {
		NewWorker nw = recruitmentService.selectCandidatAsNewWorker(id);
		
		//TEST
//		if(nw.getFirstname().equals("Jola")) {
//			nw.setIsBiopass(true);
//			nw.setPassport("BP159159159");
//			nw.setDateofbirth(LocalDate.of(1995, 04, 30));
//			nw.setAddress("Mickiewicza 20");
//			nw.setPostcode("54-879");
//			nw.setCity("Wrocław");
//			//nw.setAgreementFrom("2020-01-01");
//			//nw.setAgreementTo("2021-05-01");
//			
//		}else {
//			nw.setIsBiopass(false);
//			nw.setPassport("P3322558899");
//			nw.setDateofbirth(LocalDate.of(1990, 05, 25));
//		}
		
		nw.setWage(17.34);
		nw.setSWage("siedemnaście złotych, trzydzieści cztery grosze");
		recruitmentService.setModel(model, nw);
		model.addAttribute("newWorker", nw);
		return "user/hire/recruitment2";
	}
	
	@PostMapping(params = "action=hire")
	public String saveNewWorker(@ModelAttribute("newWorker") NewWorker nw, Model model, BindingResult result) {
		new RecruitmentValidator().validate(nw, result);
		if(result.hasErrors()) {
			model.addAttribute("error_msg", "Coś poszło nie tak");
			model.addAttribute("status", "fail");
		}else {
			hireService.hire(nw);
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
