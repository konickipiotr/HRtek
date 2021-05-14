package com.hrtek.user.display.views;


public class DataShowedFields {
	
	private boolean bDateofbirth;
	private boolean bCompany;
	private boolean bFactory;
	private boolean bRecruiter;
	private boolean bStartMedicalExams;;
	private boolean bEndMedicalExams;
	private boolean bAddToSystem;

	public DataShowedFields() {
	}

	public DataShowedFields(boolean val) {
		this.bDateofbirth = val;
		this.bCompany = val;
		this.bFactory = val;
		this.bRecruiter = val;
		this.bStartMedicalExams = val;
		this.bEndMedicalExams = val;
		this.bAddToSystem = val;
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

	public boolean isbRecruiter() {
		return bRecruiter;
	}

	public void setbRecruiter(boolean bRecruiter) {
		this.bRecruiter = bRecruiter;
	}

	public boolean isbStartMedicalExams() {
		return bStartMedicalExams;
	}

	public void setbStartMedicalExams(boolean bStartMedicalExams) {
		this.bStartMedicalExams = bStartMedicalExams;
	}

	public boolean isbEndMedicalExams() {
		return bEndMedicalExams;
	}

	public void setbEndMedicalExams(boolean bEndMedicalExams) {
		this.bEndMedicalExams = bEndMedicalExams;
	}

	public boolean isbAddToSystem() {
		return bAddToSystem;
	}

	public void setbAddToSystem(boolean bAddToSystem) {
		this.bAddToSystem = bAddToSystem;
	}	
}
