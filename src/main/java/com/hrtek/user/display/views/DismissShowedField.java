package com.hrtek.user.display.views;

import lombok.Data;

@Data
public class DismissShowedField {
	
	
	private boolean bDateofbirth;
	private boolean bCitizenship;
	
	private boolean bCompany;
	private boolean bFactory;
	private boolean bRecruiter;
	
	private boolean bStartWork;
	private boolean bStartZus;
	private boolean bEndZus;
	private boolean bEndWork;
	
	private boolean bPesel;
	private boolean bPassport;
	private boolean bBiopassport;
	private boolean bStatement;
	private boolean bPermit;
	private boolean bOther;	

	
	public DismissShowedField() {

	}
	
	public DismissShowedField(boolean val) {
		bDateofbirth = val;
		bCitizenship = val;
		bPesel = val;
		bPassport = val;
		bBiopassport = val;
		bCompany = val;
		bFactory = val;
		bStartWork = val;
		bStartZus = val;
		bEndZus = val;
		bEndWork = val;
		bRecruiter = val;
		bStatement = val;
		bPermit = val;
		bOther = val;
	}
}
