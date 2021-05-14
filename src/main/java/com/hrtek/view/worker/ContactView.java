package com.hrtek.view.worker;

import java.time.LocalDate;

import com.hrtek.model.worker.Contact;


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

	public ContactView() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public LocalDate getExpire() {
		return expire;
	}

	public void setExpire(LocalDate expire) {
		this.expire = expire;
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
}
