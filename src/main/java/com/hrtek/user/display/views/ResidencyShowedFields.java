package com.hrtek.user.display.views;


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

	public boolean isbPassport() {
		return bPassport;
	}

	public void setbPassport(boolean bPassport) {
		this.bPassport = bPassport;
	}

	public boolean isbBiopassport() {
		return bBiopassport;
	}

	public void setbBiopassport(boolean bBiopassport) {
		this.bBiopassport = bBiopassport;
	}

	public boolean isbVisa() {
		return bVisa;
	}

	public void setbVisa(boolean bVisa) {
		this.bVisa = bVisa;
	}

	public boolean isbVisaValidFrom() {
		return bVisaValidFrom;
	}

	public void setbVisaValidFrom(boolean bVisaValidFrom) {
		this.bVisaValidFrom = bVisaValidFrom;
	}

	public boolean isbVisaValidTo() {
		return bVisaValidTo;
	}

	public void setbVisaValidTo(boolean bVisaValidTo) {
		this.bVisaValidTo = bVisaValidTo;
	}
}
