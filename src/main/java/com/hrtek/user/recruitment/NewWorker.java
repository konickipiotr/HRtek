package com.hrtek.user.recruitment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class NewWorker {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String sex;
	private String email;
	private String phone;
	private Long recruiter;
	private String note;
	
	private Boolean isBiopass;
	private String passport;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private Long factoryid;
	private Long companyid;
	
	
	private String address;
	private String postcode;
	private String city;
	private String country;
	
	private Long bedid;
	private Boolean isOhter;
	private String pladdress;
	private String plpostcode;
	private String plcity;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate acomdatefrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate acomdateTo;
	
	private BigDecimal wage;
	private String sWage;
	private String sCWage;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate agreementFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate agreementTo;
	
	public NewWorker() {	
		this.sex = "M";
	}
	
	public NewWorker(Candidate c) {
		fillFromCandidate(c);
	}
	
	public void fillFromCandidate(Candidate c) {
		this.id = c.getId();
		this.firstname = c.getFirstname();
		this.lastname = c.getLastname();
		this.sex = c.getSex();
		this.email = c.getEmail();
		this.phone = c.getPhone();
		this.recruiter = c.getRecruiter();
		this.note = c.getNote();
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

	public Long getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Long recruiter) {
		this.recruiter = recruiter;
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

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Long getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
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

	public Long getBedid() {
		return bedid;
	}

	public void setBedid(Long bedid) {
		this.bedid = bedid;
	}

	public Boolean getIsOhter() {
		return isOhter;
	}

	public void setIsOhter(Boolean isOhter) {
		this.isOhter = isOhter;
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

	public LocalDate getAcomdatefrom() {
		return acomdatefrom;
	}

	public void setAcomdatefrom(LocalDate acomdatefrom) {
		this.acomdatefrom = acomdatefrom;
	}

	public LocalDate getAcomdateTo() {
		return acomdateTo;
	}

	public void setAcomdateTo(LocalDate acomdateTo) {
		this.acomdateTo = acomdateTo;
	}

	public BigDecimal getWage() {
		return wage.setScale(2, RoundingMode.HALF_UP);
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage.setScale(2, RoundingMode.HALF_UP);
	}

	public String getsWage() {
		return sWage;
	}

	public void setsWage(String sWage) {
		this.sWage = sWage;
	}

	public String getsCWage() {
		return sCWage;
	}

	public void setsCWage(String sCWage) {
		this.sCWage = sCWage;
	}

	public LocalDate getAgreementFrom() {
		return agreementFrom;
	}

	public void setAgreementFrom(LocalDate agreementFrom) {
		this.agreementFrom = agreementFrom;
	}

	public LocalDate getAgreementTo() {
		return agreementTo;
	}

	public void setAgreementTo(LocalDate agreementTo) {
		this.agreementTo = agreementTo;
	}

	public Boolean getBiopass() {
		return isBiopass;
	}

	public void setBiopass(Boolean biopass) {
		isBiopass = biopass;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getOhter() {
		return isOhter;
	}

	public void setOhter(Boolean ohter) {
		isOhter = ohter;
	}
}
