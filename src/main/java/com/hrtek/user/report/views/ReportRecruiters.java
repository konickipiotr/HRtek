package com.hrtek.user.report.views;

import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import java.time.LocalDate;


public class ReportRecruiters implements Comparable<ReportRecruiters> {
	
	private String rName;
	private String wfirstname;
	private String wlastname;
	private LocalDate addtosystem;
	
	public ReportRecruiters() {
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
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

	public static boolean isup = false;
	public static ViewFields field = ViewFields.RECRUITER;

	@Override
	public int compareTo(ReportRecruiters o) {
		switch (field) {
			case RECRUITER: return FieldsComparator.compareText(this.rName, o.getrName(), isup);
			case FIRSTNAME: return FieldsComparator.compareText(this.wfirstname, o.getWfirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.wlastname, o.getWlastname(), isup);
			case ADDTOSYSTEM: return FieldsComparator.compareDate(this.addtosystem, o.getAddtosystem(), isup);
			default:
				break;
		}
		return 0;
	}
}
