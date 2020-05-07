package com.hrtek.user.recruitment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruitment")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping
	public String toRecuritment(Model model) {
		
		model.addAttribute("candidate", new Candidate());
		setModel(model);
		return "user/hire/recruitment1";
	}
	
	@PostMapping(params = "action=save")
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate, Model model) {
		
		if(candidate.getPhone().isBlank() || candidate.getEmail().isBlank()) {
			model.addAttribute("message_contact", "Pole telefon lub email musi zostać wypełnione");
			model.addAttribute("candidate", candidate);
			
			return "user/hire/recruitment1";
		}else {
			model.addAttribute("candidate", new Candidate());
			candidateService.addCandidate(candidate);
		}
		setModel(model);
		model.addAttribute("candidate", new Candidate());
		model.addAttribute("success_msg", "Pomyslnie dodano kandydata");
		return "user/hire/recruitment1";
	}
	
	@GetMapping("{id}")
	public String deleteCandidate(@PathVariable("id") Long id) {
		candidateService.deleteCandidate(id);
		return "user/hire/recruitment1";
		
	}
	
	private void setModel(Model model) {
		model.addAttribute("candidate_list", candidateService.getCandidateViewList());
		model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
	}
	
	
}
