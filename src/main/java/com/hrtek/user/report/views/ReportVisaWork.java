package com.hrtek.user.report.views;

import java.time.LocalDate;


public class ReportVisaWork {
	
	private String firstname;
	private String lastname;
	private String type;
	private LocalDate startWork;
	private LocalDate startStatement;
	
	public ReportVisaWork() {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getStartWork() {
		return startWork;
	}
	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}
	public LocalDate getStartStatement() {
		return startStatement;
	}
	public void setStartStatement(LocalDate startStatement) {
		this.startStatement = startStatement;
	}
}
