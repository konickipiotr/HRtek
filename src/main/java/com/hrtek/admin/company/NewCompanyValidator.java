package com.hrtek.admin.company;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.db.CompanyRepository;
import com.hrtek.model.Company;

public class NewCompanyValidator implements Validator {
	
	private CompanyRepository companyRepo;
	
	public NewCompanyValidator(CompanyRepository companyRepo) {
		this.companyRepo = companyRepo;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Company.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Company company = (Company) target;
		
		if(companyRepo.existsByFullname(company.getFullname())) 
			errors.rejectValue("fullname", "valid.msg.fullname.exist");
		
		if(companyRepo.existsByShortname(company.getShortname())) 
			errors.rejectValue("shortname", "valid.msg.shortname.exist");
		
		if(companyRepo.existsByNip(company.getNip())) 
			errors.rejectValue("nip", "valid.msg.nip.exist");
		
		if(companyRepo.existsByKrs(company.getKrs())) 
			errors.rejectValue("krs", "valid.msg.krs.exist");
		
		if(companyRepo.existsByRegon(company.getRegon())) 
			errors.rejectValue("regon", "valid.msg.regon.exist");
		
		if(companyRepo.existsByKraz(company.getKraz())) 
			errors.rejectValue("regon", "valid.msg.kraz.exist");
	}
}
