package com.hrtek.user.report.views;

import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import java.time.LocalDate;


public class ReportMedical implements Comparable<ReportMedical> {

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

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportMedical o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case STARTMEDICAL: return FieldsComparator.compareDate(this.statrtMedical, o.getStatrtMedical(), isup);
			case ENDMEDICAL: return FieldsComparator.compareDate(this.endMedical, o.getEndMedical(), isup);
			case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
			default:
				break;
		}
		return 0;
	}
}
