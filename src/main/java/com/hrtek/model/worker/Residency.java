package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

import lombok.Data;

@Entity
@Data
public class Residency {

	@Id
	private Long id;
	private String biopassport;
	private String passport;
	
	private String visa;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidTo;
	
	public Residency() {
	}
	
	public void update(WorkerAll w) {
		this.biopassport = w.getBiopassport();
		this.passport = w.getPassport();
		this.visa = w.getVisa();
		this.visaValidFrom = w.getVisaValidFrom();
		this.visaValidTo = w.getVisaValidTo();
	}
	
	public Residency(Worker w, NewWorker nw) {
		this.id = w.getId();
		if(nw.getIsBiopass() != null)
			this.biopassport = nw.getPassport();
		else
			this.passport = nw.getPassport();
	}
}

	
