package com.hrtek.user.report.views;

import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import java.time.LocalDate;


public class ReportVisaWork implements Comparable<ReportVisaWork>{
	
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

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportVisaWork o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case STARTWORK: return FieldsComparator.compareDate(this.startWork, o.getStartWork(), isup);
			case STATEMENTTYPE: return FieldsComparator.compareText(this.type, o.getType(), isup);
			case STATEMENTFROM: return FieldsComparator.compareDate(this.startStatement, o.getStartStatement(), isup);
			default:
				break;
		}
		return 0;
	}
}
