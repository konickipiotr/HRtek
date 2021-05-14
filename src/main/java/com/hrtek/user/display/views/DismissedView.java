package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.dismissed.Dismissed;
import com.hrtek.utils.FieldsComparator;


public class DismissedView implements Comparable<DismissedView> {

	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String citizenship;
	
	private String company;
	private String factory;
	private String recruiter;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endZus;
	
	private String pesel;
	private String passport;
	private String biopassport;
	
	private String statement;
	private String permit;
	private String other;	
	

	
	public DismissedView(Dismissed d) {
		this.id = d.getId();
		this.firstname = d.getFirstname();
		this.lastname = d.getLastname();
		this.dateofbirth = d.getDateofbirth();
		this.recruiter = d.getRecruiter();
		this.company = d.getCompany();
		this.factory = d.getFactory();
		this.citizenship = d.getCitizenship();
		this.startWork = d.getStartWork();
		this.startZus = d.getStartZus();
		this.endWork = d.getStartZus();
		this.endZus = d.getEndZus();
		this.statement = d.getStatement();
		this.permit = d.getPermit();
		this.other = d.getOthers();
		this.pesel = d.getPesel();
		this.passport = d.getPassport();
		this.biopassport = d.getBiopassport();
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;
	

	@Override
	public int compareTo(DismissedView o) {
		switch (field) {
		case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
		case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
		case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
		case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
		case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
		case RECRUITER: return FieldsComparator.compareText(this.recruiter, o.getRecruiter(), isup);
		
		case STARTWORK: return FieldsComparator.compareDate(this.startWork, o.getStartWork(), isup);
		case STARTZUS: return FieldsComparator.compareDate(this.startZus, o.getStartZus(), isup);
		case ENDZUS: return FieldsComparator.compareDate(this.endZus, o.getEndZus(), isup);
		case ENDWORK: return FieldsComparator.compareDate(this.endWork, o.getEndWork(), isup);
	
		case CITIZENSHIP: return FieldsComparator.compareText(this.citizenship, o.getCitizenship(), isup);
		case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
		case PASZPORT: return FieldsComparator.compareText(this.passport, o.getPassport(), isup);
		case BIOPASZPORT: return FieldsComparator.compareText(this.biopassport, o.getBiopassport(), isup);
		
		case PERMIT: return FieldsComparator.compareText(this.permit, o.getPermit(), isup);
		case STATEMENT: return FieldsComparator.compareText(this.statement, o.getStatement(), isup);
		case OTHER: return FieldsComparator.compareText(this.other, o.getOther(), isup);
		default:
			break;
		}
		return 0;
	}


	public DismissedView() {
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


	public String getCitizenship() {
		return citizenship;
	}


	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
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


	public String getRecruiter() {
		return recruiter;
	}


	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
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


	public String getPesel() {
		return pesel;
	}


	public void setPesel(String pesel) {
		this.pesel = pesel;
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}


	public String getBiopassport() {
		return biopassport;
	}


	public void setBiopassport(String biopassport) {
		this.biopassport = biopassport;
	}


	public String getStatement() {
		return statement;
	}


	public void setStatement(String statement) {
		this.statement = statement;
	}


	public String getPermit() {
		return permit;
	}


	public void setPermit(String permit) {
		this.permit = permit;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public static boolean isIsup() {
		return isup;
	}


	public static void setIsup(boolean isup) {
		DismissedView.isup = isup;
	}


	public static ViewFields getField() {
		return field;
	}


	public static void setField(ViewFields field) {
		DismissedView.field = field;
	}	
}
