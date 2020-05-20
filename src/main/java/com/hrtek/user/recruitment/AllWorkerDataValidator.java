package com.hrtek.user.recruitment;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AllWorkerDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WorkerAll.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WorkerAll w = (WorkerAll) target;
		
		checkDate(w.getPermitValidFrom(), w.getPermitValidTo(), "permitValidTo", errors);
		checkDate(w.getStartMedicalExams(), w.getEndMedicalExams(), "endMedicalExams", errors);
		checkDate(w.getStatementValidFrom(), w.getStatementValidTo(), "statementValidTo", errors);
		checkDate(w.getVisaValidFrom(), w.getVisaValidTo(), "visaValidTo", errors);
		
		if(w.getPhone().isBlank() && w.getEmail().isBlank()) {
			ValidationUtils.rejectIfEmpty(errors, "email", "valid.contact");
			ValidationUtils.rejectIfEmpty(errors, "phone", "valid.contact");
		}
		
		if(w.getBiopassport().isBlank() && w.getPassport().isBlank()) {
			ValidationUtils.rejectIfEmpty(errors, "passport", "valid.onePassportNotEmpty");
			ValidationUtils.rejectIfEmpty(errors, "biopassport", "valid.onePassportNotEmpty");
		}
		
	}
	
	private void checkDate(LocalDate form, LocalDate to, String field, Errors errors) {
		if(form != null && to != null) {
			if(to.isBefore(form)) {
				errors.rejectValue(field, "valid.dateBeforOther");
			}
		}
		
		
	}

}
