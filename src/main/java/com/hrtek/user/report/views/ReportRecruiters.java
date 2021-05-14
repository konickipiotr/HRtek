package com.hrtek.user.report.views;

import java.time.LocalDate;


public class ReportRecruiters {
	
	private String rfirstname;
	private String rlastname;
	private String wfirstname;
	private String wlastname;
	private LocalDate addtosystem;
	
	public ReportRecruiters() {
	}

	public String getRfirstname() {
		return rfirstname;
	}

	public void setRfirstname(String rfirstname) {
		this.rfirstname = rfirstname;
	}

	public String getRlastname() {
		return rlastname;
	}

	public void setRlastname(String rlastname) {
		this.rlastname = rlastname;
	}

	public String getWfirstname() {
		return wfirstname;
	}

	public void setWfirstname(String wfirstname) {
		this.wfirstname = wfirstname;
	}

	public String getWlastname() {
		return wlastname;
	}

	public void setWlastname(String wlastname) {
		this.wlastname = wlastname;
	}

	public LocalDate getAddtosystem() {
		return addtosystem;
	}

	public void setAddtosystem(LocalDate addtosystem) {
		this.addtosystem = addtosystem;
	}	
}
