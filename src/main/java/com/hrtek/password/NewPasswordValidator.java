package com.hrtek.password;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hrtek.model.User;

public class NewPasswordValidator implements Validator {

	private User user;
	PasswordEncoder passwordEncoder;

	public NewPasswordValidator(User user, PasswordEncoder passwordEncoder) {
		this.user = user;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PasswordForm pf = (PasswordForm) target;
		
		if(!passwordEncoder.matches(pf.getOldpassword(), user.getPassword())) {
			errors.rejectValue("oldpassword", "valid.password.old");
		}
		
		if(!pf.getNewpassword1().equals(pf.getNewpassword2())) {
			errors.rejectValue("newpassword1", "valid.passwords.are.not.same");
		}
		
	}

}
