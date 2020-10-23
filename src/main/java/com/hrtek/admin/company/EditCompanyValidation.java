package com.hrtek.admin.company;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.db.CompanyRepository;
import com.hrtek.model.Company;

public class EditCompanyValidation implements Validator {
	
	private CompanyRepository companyRepo;
	private Company companyOld;
	
	public EditCompanyValidation(CompanyRepository companyRepo, Company company) {
		this.companyRepo = companyRepo;
		this.companyOld = company;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Company.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Company newData = (Company) target;
		
		if(companyRepo.existsByFullname(newData.getFullname()))
			if(!newData.getFullname().equals(companyOld.getFullname()))
				errors.rejectValue("fullname", "valid.msg.fullname.exist");
		
		if(companyRepo.existsByShortname(newData.getShortname())) 
			if(!newData.getShortname().equals(companyOld.getShortname()))
				errors.rejectValue("shortname", "valid.msg.shortname.exist");
		
		if(companyRepo.existsByNip(newData.getNip()))
			if(!newData.getNip().equals(companyOld.getNip()))
				errors.rejectValue("nip", "valid.msg.nip.exist");
		
		if(companyRepo.existsByKrs(newData.getKrs()))
			if(!newData.getKrs().equals(newData.getKrs()))
				errors.rejectValue("krs", "valid.msg.krs.exist");
		
	}

}
