package com.hrtek.admin.company;

import java.util.Optional;

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

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.Company;
import com.hrtek.model.Log;
import com.hrtek.model.StatusFC;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.Msg;

@Controller
@RequestMapping("/admin/newcompany")
public class NewComapnyController {
	
	private CompanyRepository companyRepo;
	private LogRepository logRepo;
	
	@Autowired
	public NewComapnyController(CompanyRepository companyRepo, LogRepository logRepo) {
		this.companyRepo = companyRepo;
		this.logRepo = logRepo;
	}

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
								HttpSession session,
								Model model) {
		String logmsg = "";
		if(type.equals("new")) {
			new NewCompanyValidator(companyRepo).validate(company, result);
			if(result.hasErrors()) {
				model.addAttribute("type", "new");
				model.addAttribute("company", company);
				return "admin/newcompany";
			}	
			logmsg = Msg.newCompany + company.toString();
		}else {
			Optional<Company> oCompany = companyRepo.findById(company.getId());
			if(oCompany.isEmpty()) {
				model.addAttribute("companies", companyRepo.findAll());
				return "admin/company";
			}
			new EditCompanyValidation(companyRepo, oCompany.get());  //TODO do przemyslenia
			if(result.hasErrors()) {
				return "admin/company";
			}			
			logmsg = Msg.modifiedCompany + oCompany.get().toString() + "<br /> to: </br />" + company.toString();
		}
		company.setStatus(StatusFC.ENABLED);
		this.companyRepo.save(company);
		
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg , LogType.MODIFY));
		return "redirect:/admin/company";
	}
}
