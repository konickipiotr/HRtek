package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;
import com.hrtek.utils.FieldsComparator;


public class ContactViewDis implements Comparable<ContactViewDis> {
	
	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String company;
	private String factory;
	private String phone;
	private String email;
	private Long houseid;
	private String pladdress;
	private String plpostcode;
	private String plcity;
	private String address;
	private String postcode;
	private String city;

	
	public ContactViewDis(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
	}
	
	public void setFromContact(Contact c) {
		this.address = c.getAddress();
		this.postcode = c.getPostcode();
		this.city = c.getCity();
		this.email = c.getEmail();
		this.phone = c.getPhone();
		this.houseid = c.getHouseid();
		this.pladdress = c.getPladdress();
		this.plpostcode = c.getPlpostcode();
		this.plcity = c.getPlcity();
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(ContactViewDis o) {
		switch (field) {
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
			case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
			case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
			case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
			case EMAIL: return FieldsComparator.compareText(this.email, o.getEmail(), isup);
			case PHONE: return FieldsComparator.compareText(this.phone, o.getPhone(), isup);
			case ADDRESS: return FieldsComparator.compareText(this.address, o.getAddress(), isup);
			case POSTCODE: return FieldsComparator.compareText(this.postcode, o.getPostcode(), isup);
			case CITY: return FieldsComparator.compareText(this.city, o.getCity(), isup);
			case PLADDRESS: return FieldsComparator.compareText(this.pladdress, o.getPladdress(), isup);
			case PLPOSTCODE: return FieldsComparator.compareText(this.plpostcode, o.getPlpostcode(), isup);
			case PLCITY: return FieldsComparator.compareText(this.plcity, o.getPlcity(), isup);
		}
		return 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public String getPladdress() {
		return pladdress;
	}

	public void setPladdress(String pladdress) {
		this.pladdress = pladdress;
	}

	public String getPlpostcode() {
		return plpostcode;
	}

	public void setPlpostcode(String plpostcode) {
		this.plpostcode = plpostcode;
	}

	public String getPlcity() {
		return plcity;
	}

	public void setPlcity(String plcity) {
		this.plcity = plcity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		ContactViewDis.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		ContactViewDis.field = field;
	}
}
