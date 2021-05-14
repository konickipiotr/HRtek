package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.hrtek.model.accommodation.House;
import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;


@Entity
public class Contact {

	@Id
	private Long id;
	private Long houseid;
	private Long roomid;
	private Long bedid;
	private String pladdress;
	private String plpostcode;
	private String plcity;
	private String address;
	private String postcode;
	private String city;
	private String phone;
	private String email;
	@Transient
	private Boolean isOhter;
	@Transient
	private LocalDate acomdate;
	
	public Contact() {
	}
	
	public void setaccommodation(Long bed, Long room, Long house) {
		this.bedid = bed;
		this.roomid = room;
		this.houseid = house;
	}
	
	public void setContact(NewWorker n) {
		this.phone = n.getPhone();
		this.email = n.getEmail();
	}
	
	public void setContact(WorkerAll n) {
		this.phone = n.getPhone();
		this.email = n.getEmail();
	}
	
	public void setAddressAbroad(NewWorker n) {
		this.address = n.getAddress() != null ? n.getAddress() : "";
		this.postcode = n.getPostcode() != null ? n.getPostcode() : "";
		this.city = n.getCity() != null ? n.getCity() : "";
	}
	
	public void setAddressAbroad(WorkerAll n) {
		this.address = n.getAddress() != null ? n.getAddress() : "";
		this.postcode = n.getPostcode() != null ? n.getPostcode() : "";
		this.city = n.getCity() != null ? n.getCity() : "";
	}
	
	public void setAddressPl(NewWorker nw) {
		this.pladdress = nw.getPladdress() != null ? nw.getPladdress() : "";
		this.plpostcode = nw.getPlpostcode() != null ? nw.getPlpostcode() : "";
		this.plcity = nw.getPlcity() != null ? nw.getPlcity() : "";
	}
	
	public void setAddressPl(WorkerAll nw) {
		this.pladdress = nw.getPladdress() != null ? nw.getPladdress() : "";
		this.plpostcode = nw.getPlpostcode() != null ? nw.getPlpostcode() : "";
		this.plcity = nw.getPlcity() != null ? nw.getPlcity() : "";
	}

	
	public Contact(Worker w){
		this.id = w.getId();
	}
	
	public void removePersonFromHouse() {
		this.pladdress = "";
		this.plpostcode = "";
		this.plcity = "";
		this.houseid = null;
		this.bedid = null;
		this.roomid = null;
	}
	
	public void addFromHouse(House h) {
		this.pladdress = h.getAddress();
		this.postcode = h.getPostcode();
		this.plcity = h.getCity();
	}

	@Override
	public String toString() {
		return " [pladdress=" + pladdress + ", plpostcode=" + plpostcode + ", plcity=" + plcity + ", address="
				+ address + ", postcode=" + postcode + ", city=" + city + ", phone=" + phone + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getBedid() {
		return bedid;
	}

	public void setBedid(Long bedid) {
		this.bedid = bedid;
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

	public Boolean getIsOhter() {
		return isOhter;
	}

	public void setIsOhter(Boolean isOhter) {
		this.isOhter = isOhter;
	}

	public LocalDate getAcomdate() {
		return acomdate;
	}

	public void setAcomdate(LocalDate acomdate) {
		this.acomdate = acomdate;
	}	
}
