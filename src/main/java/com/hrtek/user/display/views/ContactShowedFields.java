package com.hrtek.user.display.views;

public class ContactShowedFields {

	private boolean bDateofbirth;
	private boolean bCompany;
	private boolean bFactory;
	private boolean bPhone;
	private boolean bEmail;
	private boolean bHouseid;
	private boolean bPladdress;
	private boolean bPlpostcode;
	private boolean bPlcity;
	private boolean bAddress;
	private boolean bPostcode;
	private boolean bCity;
	
	
	public ContactShowedFields() {
	}
	
	public ContactShowedFields(boolean val) {
		this.bDateofbirth = val;
		this.bCompany = val;
		this.bFactory = val;
		this.bPladdress = val;
		this.bPlpostcode = val;
		this.bPlcity = val;
		this.bAddress = val;
		this.bPostcode = val;
		this.bCity = val;
		this.bPhone = val;
		this.bEmail = val;
	}

	public boolean isbDateofbirth() {
		return bDateofbirth;
	}

	public void setbDateofbirth(boolean bDateofbirth) {
		this.bDateofbirth = bDateofbirth;
	}

	public boolean isbCompany() {
		return bCompany;
	}

	public void setbCompany(boolean bCompany) {
		this.bCompany = bCompany;
	}

	public boolean isbFactory() {
		return bFactory;
	}

	public void setbFactory(boolean bFactory) {
		this.bFactory = bFactory;
	}

	public boolean isbPhone() {
		return bPhone;
	}

	public void setbPhone(boolean bPhone) {
		this.bPhone = bPhone;
	}

	public boolean isbEmail() {
		return bEmail;
	}

	public void setbEmail(boolean bEmail) {
		this.bEmail = bEmail;
	}

	public boolean isbHouseid() {
		return bHouseid;
	}

	public void setbHouseid(boolean bHouseid) {
		this.bHouseid = bHouseid;
	}

	public boolean isbPladdress() {
		return bPladdress;
	}

	public void setbPladdress(boolean bPladdress) {
		this.bPladdress = bPladdress;
	}

	public boolean isbPlpostcode() {
		return bPlpostcode;
	}

	public void setbPlpostcode(boolean bPlpostcode) {
		this.bPlpostcode = bPlpostcode;
	}

	public boolean isbPlcity() {
		return bPlcity;
	}

	public void setbPlcity(boolean bPlcity) {
		this.bPlcity = bPlcity;
	}

	public boolean isbAddress() {
		return bAddress;
	}

	public void setbAddress(boolean bAddress) {
		this.bAddress = bAddress;
	}

	public boolean isbPostcode() {
		return bPostcode;
	}

	public void setbPostcode(boolean bPostcode) {
		this.bPostcode = bPostcode;
	}

	public boolean isbCity() {
		return bCity;
	}

	public void setbCity(boolean bCity) {
		this.bCity = bCity;
	}
}
