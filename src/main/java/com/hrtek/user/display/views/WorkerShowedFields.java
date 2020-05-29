package com.hrtek.user.display.views;

import lombok.Data;

@Data
public class WorkerShowedFields {

	private boolean bDateofbirth;
	private boolean bRecruiter;
	private boolean bCompany;
	private boolean bFactory;
	private boolean bStartWork;
	private boolean bStartZus;
	private boolean bEndWork;
	private boolean bEndZus;	
	private boolean bStatementType;
	private boolean bStatement;
	private boolean bStatementValidFrom;
	private boolean bStatementValidTo;
	private boolean bPermit;
	private boolean bPermitValidFrom;
	private boolean bPermitValidTo;
	private boolean bOther;	
	
	public WorkerShowedFields() {
		
	}
	
	public WorkerShowedFields(boolean val) {
		this.bDateofbirth = val;
		this.bRecruiter = val;
		this.bCompany = val;
		this.bFactory = val;
		this.bStartWork = val;
		this.bStartZus = val;
		this.bEndWork = val;
		this.bEndZus = val;
		this.bStatementType = val;
		this.bStatement = val;
		this.bStatementValidFrom = val;
		this.bStatementValidTo = val;
		this.bPermit = val;
		this.bPermitValidFrom = val;
		this.bPermitValidTo = val;
		this.bOther = val;
	}
}
