package com.hrtek.user.display.views;

import lombok.Data;

@Data
public class BasicShowedField {

	private boolean bDateofbirth;
	private boolean bSex;
	private boolean bCitizenship;
	private boolean bPesel;
	private boolean bPaszport;
	private boolean bBbiopaszport;
	private boolean bCompany;
	private boolean bFactory;
	private boolean bStartWork;
	private boolean bStartZus;
	private boolean bEndZus;
	private boolean bEndWork;
	
	public BasicShowedField() {
		
	}
	
	public BasicShowedField(boolean val) {
		bDateofbirth = val;
		bSex = val;
		bCitizenship = val;
		bPesel = val;
		bPaszport = val;
		bBbiopaszport = val;
		bCompany = val;
		bFactory = val;
		bStartWork = val;
		bStartZus = val;
		bEndZus = val;
		bEndWork = val;
	}
	
}
