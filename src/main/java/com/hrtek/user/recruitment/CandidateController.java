package com.hrtek.user.recruitment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.user.dismissed.HireAginService;

@Controller
@RequestMapping("/canditate")
public class CandidateController {

	private RecruitmentService recruitmentService;
	private HireAginService hireAginService;
	
	@Autowired
	public CandidateController(RecruitmentService recruitmentService, HireAginService hireAginService) {
		this.recruitmentService = recruitmentService;
		this.hireAginService = hireAginService;
	}

	@GetMapping
	public String toRecuritment(Model model, String stext) {
				
		model.addAttribute("candidate", new Candidate());
		setModel(model);
		List<OldWorker> list = hireAginService.getUniqeListOfOldWorkers();
		
		if(stext != null && !stext.isBlank()) {
			List<OldWorker> newlist = new ArrayList<OldWorker>();
			for(OldWorker o : list) {
				if(o.getName().toLowerCase().contains(stext)) {
					newlist.add(o);
				}
			}
			list = newlist;
		}
		model.addAttribute("oldW", list);
		return "user/hire/recruitment1";
	}
	
	@PostMapping(params = "action=save")
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate, Model model, HttpSession session) {
		
		if(candidate.getPhone().isBlank() && candidate.getEmail().isBlank()) {
			model.addAttribute("message_contact", "Pole telefon lub email musi zostać wypełnione");
			model.addAttribute("candidate", candidate);
			setModel(model);
			return "user/hire/recruitment1";
		}
		
		recruitmentService.addCandidate(candidate, session);
		
		setModel(model);
		model.addAttribute("candidate", new Candidate());
		model.addAttribute("success_msg", "Pomyslnie dodano kandydata");
		return "user/hire/recruitment1";
	}
	
	@GetMapping("{id}")
	public String deleteCandidate(@PathVariable("id") Long id, Model model, HttpSession session) {
		recruitmentService.deleteCandidate(id, session);
		return "redirect:/canditate";
	}
	
	private void setModel(Model model) {
		model.addAttribute("candidate_list", recruitmentService.getCandidateViewList());
		model.addAttribute("recruiters", recruitmentService.getCoordinatorsAndAgents());
	}
	
	@PostMapping(params = "action=saveandnext")
	public String saveAndNextCandidate(@ModelAttribute("candidate") Candidate candidate, Model model, HttpSession session) {
		if(candidate.getPhone().isBlank() && candidate.getEmail().isBlank()) {
			model.addAttribute("message_contact", "Pole telefon lub email musi zostać wypełnione");
			model.addAttribute("candidate", candidate);
			return "user/hire/recruitment1";
		}
		
		recruitmentService.addCandidate(candidate, session);
	
		NewWorker newWorker = new  NewWorker();
		newWorker.fillFromCandidate(candidate);
		recruitmentService.setModel(model, newWorker);
		model.addAttribute("newWorker", newWorker);
		return "user/hire/recruitment2";
	}
	
	@PostMapping("/filterold")
	public String hireagain(@RequestParam("id") Long id, Model model) {
		WorkerAll workerAll = hireAginService.prepareWorkerAll(id);
		recruitmentService.setOtherDataModel(model, workerAll);
		
		model.addAttribute("workerAll", workerAll);
		model.addAttribute("hireagain", true);
		return "user/hire/recruitment3";
	}
	
	@PostMapping(value = "/filterold", params = "action=filter")
	public String filterOldWorkers(@RequestParam("stext") String stext,  Model model ) {
		model.addAttribute("candidate", new Candidate());
		setModel(model);
		List<OldWorker> list = hireAginService.getUniqeListOfOldWorkers();
		
		if(stext != null && !stext.isBlank()) {
			List<OldWorker> newlist = new ArrayList<OldWorker>();
			for(OldWorker o : list) {
				if(o.getName().toLowerCase().contains(stext)) {
					newlist.add(o);
				}
			}
			list = newlist;
		}
		model.addAttribute("oldW", list);
		return "user/hire/recruitment1";
	}
	
}
