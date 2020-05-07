package com.hrtek.admin.employee;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.db.UserRepository;

public class CredentialValidator implements Validator {

	private UserRepository userRepo;
	
	public CredentialValidator(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NewEmployeeModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewEmployeeModel nem = (NewEmployeeModel) target;
		
		if(!nem.getPassword().equals(nem.getPassword2()))
			errors.rejectValue("password", "valid.msg.passwordnotsame");
		
		if(userRepo.existsByUsername(nem.getUsername()))
			errors.rejectValue("username", "valid.msg.usernameexists");
	}
}
