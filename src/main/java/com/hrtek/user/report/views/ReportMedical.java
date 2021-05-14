package com.hrtek.user.report.views;

import java.time.LocalDate;


public class ReportMedical {

	private String firstname;
	private String lastname;
	private LocalDate statrtMedical;
	private LocalDate endMedical;
	private String factory;
	
	public ReportMedical() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getStatrtMedical() {
		return statrtMedical;
	}

	public void setStatrtMedical(LocalDate statrtMedical) {
		this.statrtMedical = statrtMedical;
	}

	public LocalDate getEndMedical() {
		return endMedical;
	}

	public void setEndMedical(LocalDate endMedical) {
		this.endMedical = endMedical;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}	
}
