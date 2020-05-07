package com.hrtek.user.recruitment;

import java.sql.Date;

public class RecruitModel {

	private Long id;
	private String firstname;
	private String lastname;
	private String sex;
	private String email;
	private String phone;
	private Long recruterid;
	private String note;
	private Boolean isBiopass;
	private String noPassport;
	private Long companyid;
	private Long factoryid;
	private Long bedid;
	private Date dateofbirth;
	private String street;
	private String postcode;
	private String City;
	private Date agreementFrom;
	private Date agreementTo;
	
	public RecruitModel() {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRecruterid() {
		return recruterid;
	}

	public void setRecruterid(Long recruterid) {
		this.recruterid = recruterid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsBiopass() {
		return isBiopass;
	}

	public void setIsBiopass(Boolean isBiopass) {
		this.isBiopass = isBiopass;
	}

	public String getNoPassport() {
		return noPassport;
	}

	public void setNoPassport(String noPassport) {
		this.noPassport = noPassport;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public Long getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}

	public Long getBedid() {
		return bedid;
	}

	public void setBedid(Long bedid) {
		this.bedid = bedid;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Date getAgreementFrom() {
		return agreementFrom;
	}

	public void setAgreementFrom(Date agreementFrom) {
		this.agreementFrom = agreementFrom;
	}

	public Date getAgreementTo() {
		return agreementTo;
	}

	public void setAgreementTo(Date agreementTo) {
		this.agreementTo = agreementTo;
	}
}
