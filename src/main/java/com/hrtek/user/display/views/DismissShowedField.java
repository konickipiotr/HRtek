package com.hrtek.user.display.views;


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

	public boolean isbDateofbirth() {
		return bDateofbirth;
	}

	public void setbDateofbirth(boolean bDateofbirth) {
		this.bDateofbirth = bDateofbirth;
	}

	public boolean isbCitizenship() {
		return bCitizenship;
	}

	public void setbCitizenship(boolean bCitizenship) {
		this.bCitizenship = bCitizenship;
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

	public boolean isbRecruiter() {
		return bRecruiter;
	}

	public void setbRecruiter(boolean bRecruiter) {
		this.bRecruiter = bRecruiter;
	}

	public boolean isbStartWork() {
		return bStartWork;
	}

	public void setbStartWork(boolean bStartWork) {
		this.bStartWork = bStartWork;
	}

	public boolean isbStartZus() {
		return bStartZus;
	}

	public void setbStartZus(boolean bStartZus) {
		this.bStartZus = bStartZus;
	}

	public boolean isbEndZus() {
		return bEndZus;
	}

	public void setbEndZus(boolean bEndZus) {
		this.bEndZus = bEndZus;
	}

	public boolean isbEndWork() {
		return bEndWork;
	}

	public void setbEndWork(boolean bEndWork) {
		this.bEndWork = bEndWork;
	}

	public boolean isbPesel() {
		return bPesel;
	}

	public void setbPesel(boolean bPesel) {
		this.bPesel = bPesel;
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

	public boolean isbStatement() {
		return bStatement;
	}

	public void setbStatement(boolean bStatement) {
		this.bStatement = bStatement;
	}

	public boolean isbPermit() {
		return bPermit;
	}

	public void setbPermit(boolean bPermit) {
		this.bPermit = bPermit;
	}

	public boolean isbOther() {
		return bOther;
	}

	public void setbOther(boolean bOther) {
		this.bOther = bOther;
	}
}
