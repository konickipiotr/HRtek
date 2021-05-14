package com.hrtek.user.display.views;


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

	public boolean isbDateofbirth() {
		return bDateofbirth;
	}

	public void setbDateofbirth(boolean bDateofbirth) {
		this.bDateofbirth = bDateofbirth;
	}

	public boolean isbSex() {
		return bSex;
	}

	public void setbSex(boolean bSex) {
		this.bSex = bSex;
	}

	public boolean isbCitizenship() {
		return bCitizenship;
	}

	public void setbCitizenship(boolean bCitizenship) {
		this.bCitizenship = bCitizenship;
	}

	public boolean isbPesel() {
		return bPesel;
	}

	public void setbPesel(boolean bPesel) {
		this.bPesel = bPesel;
	}

	public boolean isbPaszport() {
		return bPaszport;
	}

	public void setbPaszport(boolean bPaszport) {
		this.bPaszport = bPaszport;
	}

	public boolean isbBbiopaszport() {
		return bBbiopaszport;
	}

	public void setbBbiopaszport(boolean bBbiopaszport) {
		this.bBbiopaszport = bBbiopaszport;
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
}
