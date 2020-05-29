package com.hrtek.user.display.views;

import lombok.Data;

@Data
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
	
	
}
