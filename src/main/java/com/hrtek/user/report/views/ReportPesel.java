package com.hrtek.user.report.views;


import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

public class ReportPesel implements Comparable<ReportPesel> {

	private String firstname;
	private String lastname;
	private String pesel;
	private String factory;
	
	public ReportPesel() {
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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
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
	public int compareTo(ReportPesel o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
			case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
			default:
				break;
		}
		return 0;
	}
}
