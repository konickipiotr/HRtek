package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;
import com.hrtek.utils.FieldsComparator;

import lombok.Data;

@Data
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
}
