package com.hrtek.view.worker;

import java.time.LocalDate;

import com.hrtek.model.worker.Contact;

import lombok.Data;

@Data
public class ContactView {
	
	private Long id;
	private String house;
	private Long houseid;
	private String room;
	private LocalDate expire;
	private String pladdress;
	private String plpostcode;
	private String plcity;
	private String address;
	private String postcode;
	private String city;
	private String phone;
	private String email;

	public ContactView(Contact c) {
		this.email = c.getEmail();
		this.phone = c.getPhone();
		this.address = c.getAddress();
		this.postcode = c.getPostcode();
		this.city = c.getCity();
		this.pladdress = c.getPladdress();
		this.plcity = c.getPlcity();
		this.plpostcode = c.getPlpostcode();
	}
}
