package com.hrtek.user.display.views;

import lombok.Data;

@Data
public class ResidencyShowedFields {
	
	private boolean bDateofbirth;
	private boolean bCompany;
	private boolean bFactory;
	private boolean bPassport;
	private boolean bBiopassport;
	private boolean bVisa;
	private boolean bVisaValidFrom;
	private boolean bVisaValidTo;
	
	public ResidencyShowedFields() {	
	}
	
	public ResidencyShowedFields(boolean val) {
		this.bDateofbirth = val;
		this.bCompany = val;
		this.bFactory = val;
		this.bPassport = val;
		this.bBiopassport = val;
		this.bVisa = val;
		this.bVisaValidFrom = val;
		this.bVisaValidTo = val;
	}
}
