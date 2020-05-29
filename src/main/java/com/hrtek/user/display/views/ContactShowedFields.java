package com.hrtek.user.display.views;

import lombok.Data;

@Data
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

}
