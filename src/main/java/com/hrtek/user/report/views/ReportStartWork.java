package com.hrtek.user.report.views;

import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import java.time.LocalDate;


public class ReportStartWork implements Comparable<ReportStartWork> {
	
	private String firstname;
	private String lastname;
	private LocalDate startWork;
	private LocalDate endWork;
	
	public ReportStartWork() {
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

	public LocalDate getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}

	public LocalDate getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportStartWork o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case STARTWORK: return FieldsComparator.compareDate(this.startWork, o.getStartWork(), isup);
			case ENDWORK: return FieldsComparator.compareDate(this.endWork, o.getEndWork(), isup);
			default:
				break;
		}
		return 0;
	}
}
