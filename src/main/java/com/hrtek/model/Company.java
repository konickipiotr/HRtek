package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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
	}

	@Override
	public String toString() {
		return "[pkd=" + pkd + ", nip=" + nip + ", krs=" + krs + ", regon=" + regon + ", kraz=" + kraz
				+ ", shortname=" + shortname + ", fullname=" + fullname + ", address=" + address + ", postcode="
				+ postcode + ", city=" + city + ", numberofwokers=" + numberofwokers + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusFC getStatus() {
		return status;
	}

	public void setStatus(StatusFC status) {
		this.status = status;
	}

	public String getPkd() {
		return pkd;
	}

	public void setPkd(String pkd) {
		this.pkd = pkd;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getKrs() {
		return krs;
	}

	public void setKrs(String krs) {
		this.krs = krs;
	}

	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public String getKraz() {
		return kraz;
	}

	public void setKraz(String kraz) {
		this.kraz = kraz;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public int getNumberofwokers() {
		return numberofwokers;
	}

	public void setNumberofwokers(int numberofwokers) {
		this.numberofwokers = numberofwokers;
	}
}
