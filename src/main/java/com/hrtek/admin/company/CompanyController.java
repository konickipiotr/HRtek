package com.hrtek.admin.company;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrtek.db.CompanyRepository;
import com.hrtek.model.Company;

@Controller
@RequestMapping("/admin/company")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepo;

	@GetMapping
	public String showCompanies(Model model) {
		
		model.addAttribute("companies", companyRepo.findAll());
		return "admin/company";
	}
	
	@GetMapping("/edit/{id}")
	public String editCompany(@PathVariable("id") Long id, Model model) {
		Optional<Company> oCompany = companyRepo.findById(id);
		if(oCompany.isEmpty()) {
			model.addAttribute("error_msg", "Błąd");
			model.addAttribute("companies", companyRepo.findAll());
			return "admin/company";
		}
		
		Company company = oCompany.get();
		model.addAttribute("company", company);
		model.addAttribute("type", "edit");
		return "admin/newcompany";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCompany(@PathVariable("id") Long id) {
		this.companyRepo.deleteById(id);
		return "redirect:/admin/company";
	}
}
