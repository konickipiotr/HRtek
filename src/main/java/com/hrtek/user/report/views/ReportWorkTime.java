package com.hrtek.user.report.views;


import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

public class ReportWorkTime implements Comparable<ReportWorkTime>{
	
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

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportWorkTime o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
			case DAY: return FieldsComparator.compareNumber(this.days, o.getDays(), isup);
			case GREATERTHANSIXTEEN: {
				if(this.months.equals("EMPTY") && o.getMonths().equals("EMPTY"))
					return 0;
				if(isup) {
					if (this.months.equals("EMPTY"))
						return 1;
					if (o.getMonths().equals("EMPTY"))
						return -1;
				}else {
					if (this.months.equals("EMPTY"))
						return -1;
					if (o.getMonths().equals("EMPTY"))
						return 1;
				}
				return FieldsComparator.compareNumber( ( Integer.valueOf(this.months) * 30 + this.days), ( Integer.valueOf(o.months) * 30 + o.days), isup);
			}
			default:
				break;
		}
		return 0;
	}
}
