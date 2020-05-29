package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.hrtek.model.accommodation.House;
import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

import lombok.Data;

@Entity
@Data
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
}
