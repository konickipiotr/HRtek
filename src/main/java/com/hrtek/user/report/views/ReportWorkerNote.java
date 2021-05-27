package com.hrtek.user.report.views;


import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

public class ReportWorkerNote implements Comparable<ReportWorkerNote>{

	private String firstname;
	private String lastname;
	private String note;

	public ReportWorkerNote() {
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportWorkerNote o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case NOTE: return FieldsComparator.compareText(this.note, o.getNote(), isup);
			default:
				break;
		}
		return 0;
	}
}
