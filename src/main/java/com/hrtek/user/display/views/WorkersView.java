package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.utils.FieldsComparator;


public class WorkersView implements Comparable<WorkersView> {
	
	private int status;
	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String company;
	private String factory;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endZus;	
	private String statementType;
	private String statement;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate statementValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate statementValidTo;
	private String permit;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate permitValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate permitValidTo;
	private String other;	
	private String recruiter;
	
	public WorkersView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		if(w.getStatus().equals(StatusWorker.ACTIVE))
			this.status = 1;
		else
			this.status = 0;
	}
	
	public void setFromWorkerDate(WorkerDate wd) {
		this.startWork = wd.getStartWork();
		this.startZus = wd.getStartZus();
		this.endZus = wd.getEndZus();
		this.endWork = wd.getEndWork();
	}
	
	public void setFromStatemenPermit(PermitStatement ps) {
		this.statementType = ps.getStatementType();
		this.statement = ps.getStatement();
		this.statementValidFrom = ps.getStatementValidFrom();
		this.statementValidTo = ps.getStatementValidTo();
		this.permit = ps.getPermit();
		this.permitValidFrom = ps.getStatementValidFrom();
		this.permitValidTo = ps.getPermitValidTo();
		this.other = ps.getOther();	
	}
		
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;
	
	@Override
	public int compareTo(WorkersView o) {
		
		switch (field) {
		case STATUS: return FieldsComparator.compareNumber(this.status, o.getStatus(), isup);
		case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
		case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
		case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
		case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
		case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
		case STARTWORK: return FieldsComparator.compareDate(this.startWork, o.getStartWork(), isup);
		case STARTZUS: return FieldsComparator.compareDate(this.startZus, o.getStartZus(), isup);
		case ENDZUS: return FieldsComparator.compareDate(this.endZus, o.getEndZus(), isup);
		case ENDWORK: return FieldsComparator.compareDate(this.endWork, o.getEndWork(), isup);
		
		case STATEMENT: return FieldsComparator.compareText(this.statement, o.getStatement(), isup);
		case STATEMENTTYPE: return FieldsComparator.compareText(this.statementType, o.getStatementType(), isup);
		case STATEMENTFROM: return FieldsComparator.compareDate(this.statementValidFrom, o.getStatementValidFrom(), isup);
		case STATEMENTTO: return FieldsComparator.compareDate(this.statementValidTo, o.getStatementValidTo(), isup);
		case PERMIT: return FieldsComparator.compareText(this.permit, o.getPermit(), isup);
		case PERMITFROM: return FieldsComparator.compareDate(this.permitValidFrom, o.getPermitValidFrom(), isup);
		case PERMITTO: return FieldsComparator.compareDate(this.permitValidTo, o.getPermitValidTo(), isup);
		case OTHER: return FieldsComparator.compareText(this.other, o.getOther(), isup);
		
		default:
			break;
		}
		return 0;
	}

	public WorkersView() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public LocalDate getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}

	public LocalDate getStartZus() {
		return startZus;
	}

	public void setStartZus(LocalDate startZus) {
		this.startZus = startZus;
	}

	public LocalDate getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}

	public LocalDate getEndZus() {
		return endZus;
	}

	public void setEndZus(LocalDate endZus) {
		this.endZus = endZus;
	}

	public String getStatementType() {
		return statementType;
	}

	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public LocalDate getStatementValidFrom() {
		return statementValidFrom;
	}

	public void setStatementValidFrom(LocalDate statementValidFrom) {
		this.statementValidFrom = statementValidFrom;
	}

	public LocalDate getStatementValidTo() {
		return statementValidTo;
	}

	public void setStatementValidTo(LocalDate statementValidTo) {
		this.statementValidTo = statementValidTo;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public LocalDate getPermitValidFrom() {
		return permitValidFrom;
	}

	public void setPermitValidFrom(LocalDate permitValidFrom) {
		this.permitValidFrom = permitValidFrom;
	}

	public LocalDate getPermitValidTo() {
		return permitValidTo;
	}

	public void setPermitValidTo(LocalDate permitValidTo) {
		this.permitValidTo = permitValidTo;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		WorkersView.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		WorkersView.field = field;
	}
}

