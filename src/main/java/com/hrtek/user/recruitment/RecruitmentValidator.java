package com.hrtek.user.recruitment;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RecruitmentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NewWorker.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewWorker nw = (NewWorker) target;
		
		if(nw.getPhone().isBlank() && nw.getEmail().isBlank()) {
			ValidationUtils.rejectIfEmpty(errors, "email", "valid.contact");
			ValidationUtils.rejectIfEmpty(errors, "phone", "valid.contact");
		}
		
		LocalDate form = nw.getStartZus();
		LocalDate to = nw.getEndZus();
		
		if(form != null && to != null) {
			if(to.isBefore(form)) {
				errors.rejectValue("endZus", "valid.dateBeforOther");
			}
		}

	}
}
