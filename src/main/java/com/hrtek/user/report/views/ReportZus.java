package com.hrtek.user.report.views;

import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import java.time.LocalDate;


public class ReportZus implements Comparable<ReportZus> {

	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String sex;
	private String pesel;
	private String citizenship;
	private String facotry;
	private String company;
	private String passport;
	private String type;
	private LocalDate startZus;
	private LocalDate endZus;
	private String address;
	
	public ReportZus() {
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

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getFacotry() {
		return facotry;
	}

	public void setFacotry(String facotry) {
		this.facotry = facotry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartZus() {
		return startZus;
	}

	public void setStartZus(LocalDate startZus) {
		this.startZus = startZus;
	}

	public LocalDate getEndZus() {
		return endZus;
	}

	public void setEndZus(LocalDate endZus) {
		this.endZus = endZus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ReportZus o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.lastname, o.getLastname(), isup);
			case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
			case SEX: return FieldsComparator.compareText(this.sex, o.getSex(), isup);
			case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
			case CITIZENSHIP: return FieldsComparator.compareText(this.citizenship, o.getCitizenship(), isup);
			case FACTORY: return FieldsComparator.compareText(this.facotry, o.getFacotry(), isup);
			case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
			case PASZPORT: return FieldsComparator.compareText(this.passport, o.getPassport(), isup);
			case TYPE: return FieldsComparator.compareText(this.type, o.getType(), isup);
			case STARTZUS: return FieldsComparator.compareDate(this.startZus, o.getStartZus(), isup);
			case ENDZUS: return FieldsComparator.compareDate(this.endZus, o.getEndZus(), isup);
			case ADDRESS: return FieldsComparator.compareText(this.address, o.getAddress(), isup);

			default:
				break;
		}
		return 0;
	}
}
