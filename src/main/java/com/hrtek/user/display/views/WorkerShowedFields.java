package com.hrtek.user.display.views;


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

	public boolean isbDateofbirth() {
		return bDateofbirth;
	}

	public void setbDateofbirth(boolean bDateofbirth) {
		this.bDateofbirth = bDateofbirth;
	}

	public boolean isbRecruiter() {
		return bRecruiter;
	}

	public void setbRecruiter(boolean bRecruiter) {
		this.bRecruiter = bRecruiter;
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

	public boolean isbEndWork() {
		return bEndWork;
	}

	public void setbEndWork(boolean bEndWork) {
		this.bEndWork = bEndWork;
	}

	public boolean isbEndZus() {
		return bEndZus;
	}

	public void setbEndZus(boolean bEndZus) {
		this.bEndZus = bEndZus;
	}

	public boolean isbStatementType() {
		return bStatementType;
	}

	public void setbStatementType(boolean bStatementType) {
		this.bStatementType = bStatementType;
	}

	public boolean isbStatement() {
		return bStatement;
	}

	public void setbStatement(boolean bStatement) {
		this.bStatement = bStatement;
	}

	public boolean isbStatementValidFrom() {
		return bStatementValidFrom;
	}

	public void setbStatementValidFrom(boolean bStatementValidFrom) {
		this.bStatementValidFrom = bStatementValidFrom;
	}

	public boolean isbStatementValidTo() {
		return bStatementValidTo;
	}

	public void setbStatementValidTo(boolean bStatementValidTo) {
		this.bStatementValidTo = bStatementValidTo;
	}

	public boolean isbPermit() {
		return bPermit;
	}

	public void setbPermit(boolean bPermit) {
		this.bPermit = bPermit;
	}

	public boolean isbPermitValidFrom() {
		return bPermitValidFrom;
	}

	public void setbPermitValidFrom(boolean bPermitValidFrom) {
		this.bPermitValidFrom = bPermitValidFrom;
	}

	public boolean isbPermitValidTo() {
		return bPermitValidTo;
	}

	public void setbPermitValidTo(boolean bPermitValidTo) {
		this.bPermitValidTo = bPermitValidTo;
	}

	public boolean isbOther() {
		return bOther;
	}

	public void setbOther(boolean bOther) {
		this.bOther = bOther;
	}
}
