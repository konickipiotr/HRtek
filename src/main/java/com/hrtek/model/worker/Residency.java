package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

@Entity
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

	public Residency(Worker worker, WorkerAll wall) {
		this.id = worker.getId();
		this.biopassport = wall.getBiopassport();
		this.passport = wall.getPassport();
		this.visa = wall.getVisa();
		this.visaValidFrom = wall.getVisaValidFrom();
		this.visaValidTo = wall.getVisaValidTo();
	}

	@Override
	public String toString() {
		return " [biopassport=" + biopassport + ", passport=" + passport + ", visa=" + visa
				+ ", visaValidFrom=" + visaValidFrom + ", visaValidTo=" + visaValidTo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiopassport() {
		return biopassport;
	}

	public void setBiopassport(String biopassport) {
		this.biopassport = biopassport;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public LocalDate getVisaValidFrom() {
		return visaValidFrom;
	}

	public void setVisaValidFrom(LocalDate visaValidFrom) {
		this.visaValidFrom = visaValidFrom;
	}

	public LocalDate getVisaValidTo() {
		return visaValidTo;
	}

	public void setVisaValidTo(LocalDate visaValidTo) {
		this.visaValidTo = visaValidTo;
	}	
}

	
