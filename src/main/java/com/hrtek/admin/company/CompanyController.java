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
import com.hrtek.model.Factory;
import com.hrtek.model.StatusFC;

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
	
	@GetMapping(path = "/enable/{id}")
	public String enableCompany(@PathVariable("id") Long id) {
		Optional<Company> oCompany = this.companyRepo.findById(id);
		if(oCompany.isPresent()) {
			Company company = oCompany.get();
			company.setStatus(StatusFC.ENABLED);
			this.companyRepo.save(company);
		}

		return "redirect:/admin/company";
	}
	
	@GetMapping(path = "/disable/{id}")
	public String disableCompany(@PathVariable("id") Long id, Model model) {
		Optional<Company> oCompany = this.companyRepo.findById(id);
		if(oCompany.isPresent()) {
			Company company = oCompany.get();
			if(company.getNumberofwokers() == 0) {
				company.setStatus(StatusFC.DISABLED);
				this.companyRepo.save(company);
			}
			else {
				model.addAttribute("error_msg", "Nie można dezaktywować firmy dopóki pracuje w niej co najmniej jeden pracownik");
			}
			model.addAttribute("companies", companyRepo.findAll());
			
		}

		return "admin/company";
	}
}
