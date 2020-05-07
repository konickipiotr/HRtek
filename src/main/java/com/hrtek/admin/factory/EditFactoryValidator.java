package com.hrtek.admin.factory;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.db.FactoryRepository;
import com.hrtek.model.Factory;

public class EditFactoryValidator implements Validator {

	private FactoryRepository factoryRepo;
	private Factory oldData;

	public EditFactoryValidator(FactoryRepository factoryRepo, Factory oldData) {
		this.factoryRepo = factoryRepo;
		this.oldData = oldData;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Factory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Factory newData = (Factory) target;
		
		if(factoryRepo.existsByFullname(newData.getFullname()))
			if(!newData.getFullname().equals(oldData.getFullname()))
				errors.rejectValue("fullname", "valid.msg.fullname.exist");
		
		if(factoryRepo.existsByShortname(newData.getShortname())) 
			if(!newData.getShortname().equals(oldData.getShortname()))
				errors.rejectValue("shortname", "valid.msg.shortname.exist");
		
		if(factoryRepo.existsByNip(newData.getNip()))
			if(!newData.getNip().equals(oldData.getNip()))
				errors.rejectValue("nip", "valid.msg.nip.exist");
		
		if(factoryRepo.existsByKrs(newData.getKrs()))
			if(!newData.getKrs().equals(newData.getKrs()))
				errors.rejectValue("krs", "valid.msg.krs.exist");
		
	}

}
