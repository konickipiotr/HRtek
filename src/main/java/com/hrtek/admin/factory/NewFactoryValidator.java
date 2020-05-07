package com.hrtek.admin.factory;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.db.FactoryRepository;
import com.hrtek.model.Factory;

public class NewFactoryValidator implements Validator {
	
	private FactoryRepository factoryRepo;

	public NewFactoryValidator(FactoryRepository factoryRepo) {
		this.factoryRepo = factoryRepo;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Factory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Factory factory = (Factory) target;

		if(factoryRepo.existsByFullname(factory.getFullname())) 
			errors.rejectValue("fullname", "valid.msg.fullname.exist");
		
		if(factoryRepo.existsByShortname(factory.getShortname())) 
			errors.rejectValue("shortname", "valid.msg.shortname.exist");
		
		if(factoryRepo.existsByNip(factory.getNip())) 
			errors.rejectValue("nip", "valid.msg.nip.exist");
		
		if(factoryRepo.existsByKrs(factory.getKrs())) 
			errors.rejectValue("krs", "valid.msg.krs.exist");
	}
}
