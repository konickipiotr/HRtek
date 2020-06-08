package com.hrtek.admin.company;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.db.CompanyRepository;
import com.hrtek.model.Company;
import com.hrtek.model.StatusFC;

@Controller
@RequestMapping("/admin/newcompany")
public class NewComapnyController {
	
	@Autowired
	private CompanyRepository companyRepo;

	@GetMapping
	public String tonewcompany(Model model) {
		model.addAttribute("company", new Company());
		model.addAttribute("type", "new");
		return "admin/newcompany";
	}
	
	@PostMapping
	public String addcompany(@ModelAttribute("company") Company company,
								@RequestParam("type") String type,
								BindingResult result,
								Model model) {
		if(type.equals("new")) {
			new NewCompanyValidator(companyRepo).validate(company, result);
			if(result.hasErrors()) {
				model.addAttribute("type", "new");
				model.addAttribute("company", company);
				return "admin/newcompany";
			}	
		}else {
			Optional<Company> oCompany = companyRepo.findById(company.getId());
			if(oCompany.isEmpty()) {
				model.addAttribute("companies", companyRepo.findAll());
				return "admin/company";
			}
			//TODO nie pozwolić na zmianę na istniejące 
		}
		company.setStatus(StatusFC.ENABLED);
		this.companyRepo.save(company);
		return "redirect:/admin/company";
	}
}
