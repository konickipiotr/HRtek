package com.hrtek.user.report.views;


public class ReportWorkTime {
	
	private String firstname;
	private String lastname;
	private String company;
	private String months;
	private int days;
	private boolean greaterThansixteen = false;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public boolean isGreaterThansixteen() {
		return greaterThansixteen;
	}
	public void setGreaterThansixteen(boolean greaterThansixteen) {
		this.greaterThansixteen = greaterThansixteen;
	}
}
