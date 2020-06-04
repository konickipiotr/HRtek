package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Company {
	
	@Id
	@GeneratedValue
	private Long id;
	private StatusFC status;
	private String pkd;
	private String nip;
	private String krs;
	private String regon;
	private String kraz;
	private String shortname;
	private String fullname;
	private String address;
	private String postcode;
	private String city;
	private int numberofwokers;
	private double nettorate;
	
	public Company() {
	}
	
	public String agreementData() {
		return fullname + ", " + address + ", " + postcode + " " + city + ", NIP " + nip + ", KRAZ " + kraz;
	}

	public void addPerson() {
		this.numberofwokers++;
	}
	
	public void removePerson() {
		this.numberofwokers--;
	}

	
	public Company(StatusFC status, String pkd, String nip, String krs, String regon, String kraz, String shortname,
			String fullname, String address, String postcode, String city, int numberofwokers, double nettorate) {
		this.status = status;
		this.pkd = pkd;
		this.nip = nip;
		this.krs = krs;
		this.regon = regon;
		this.kraz = kraz;
		this.shortname = shortname;
		this.fullname = fullname;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.numberofwokers = numberofwokers;
		this.nettorate = nettorate;
	}
	
	
}
