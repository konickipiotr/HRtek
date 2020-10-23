package com.hrtek.admin.company;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.Company;
import com.hrtek.model.Log;
import com.hrtek.model.StatusFC;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.Msg;

@Controller
@RequestMapping("/admin/company")
public class CompanyController {

	private CompanyRepository companyRepo;
	private LogRepository logRepo;

	@Autowired
	public CompanyController(CompanyRepository companyRepo, LogRepository logRepo) {
		this.companyRepo = companyRepo;
		this.logRepo = logRepo;
	}

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
	
//	@GetMapping("/delete/{id}")
//	public String deleteCompany(@PathVariable("id") Long id) {
//		this.companyRepo.deleteById(id);company
//		return "redirect:/admin/company";
//	}
	
	@GetMapping(path = "/enable/{id}")
	public String enableCompany(@PathVariable("id") Long id,  HttpSession session) {
		Optional<Company> oCompany = this.companyRepo.findById(id);
		if(oCompany.isPresent()) {
			Company company = oCompany.get();
			company.setStatus(StatusFC.ENABLED);
			this.companyRepo.save(company);
			UserInfo ui = (UserInfo) session.getAttribute("user");
			this.logRepo.save(new Log(ui.getName(), Msg.enableFactory + company.getFullname(), LogType.CREATE));
		}

		return "redirect:/admin/company";
	}
	
	@GetMapping(path = "/disable/{id}")
	public String disableCompany(@PathVariable("id") Long id, Model model, HttpSession session) {
		Optional<Company> oCompany = this.companyRepo.findById(id);
		if(oCompany.isPresent()) {
			Company company = oCompany.get();
			if(company.getNumberofwokers() == 0) {
				company.setStatus(StatusFC.DISABLED);
				this.companyRepo.save(company);
				UserInfo ui = (UserInfo) session.getAttribute("user");
				this.logRepo.save(new Log(ui.getName(), Msg.enableFactory + company.getFullname(), LogType.DELETE));
			}
			else {
				model.addAttribute("error_msg", "Nie można dezaktywować firmy dopóki pracuje w niej co najmniej jeden pracownik");
			}
			model.addAttribute("companies", companyRepo.findAll());
			
		}

		return "admin/company";
	}
}
