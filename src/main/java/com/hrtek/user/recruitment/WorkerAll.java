package com.hrtek.user.recruitment;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.user.dismissed.Dismissed;

public class WorkerAll {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String sex;
	private String email;
	private String phone;
	private Long recruiter;
	private String note;
	
	private Boolean isBiopass;
	private String passport;
	private String biopassport;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private Long factoryid;
	private Long companyid;
	
	private String address;
	private String postcode;
	private String city;
	
	private Long bedid;
	private Boolean isOhter;
	private String pladdress;
	private String plpostcode;
	private String plcity;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate acomdate;
	
	private Integer citizenship;
	private Long department;
	private String workerNo;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startMedicalExams;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	
	private LocalDate endMedicalExams;

	
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
	
	private String visa;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidTo;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	
	private LocalDate addToSystem;
	
	private String pesel;
	private String other;
	private String accountnr;
	private double bonus;
	private double wage;
	private String sWage;
	
	public void setWorker(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		this.factoryid = w.getFactoryid();
		this.companyid = w.getCompanyid();
		this.recruiter = w.getRecruiter();
	}
	
	public void setWorkerBasic(WorkerBasic wb) {
		this.department = wb.getDepartment();
		this.citizenship = wb.getCitizenship();
		this.dateofbirth = wb.getDateofbirth();
		this.sex = wb.getSex();
		this.accountnr = wb.getAccountnr();
		this.pesel = wb.getPesel();
		this.workerNo = wb.getWorkerNo();
	}
	
	public void setFromWorkerDate(WorkerDate wd) {
		this.startZus = wd.getStartZus();
		this.endZus = wd.getEndZus();
		this.startWork = wd.getStartWork();
		this.endWork = wd.getEndWork();
		this.startMedicalExams = wd.getStartMedicalExams();
		this.endMedicalExams = wd.getEndMedicalExams();
	}
	
	public void setFromContact(Contact c) {
		
		this.pladdress = c.getPladdress();
		this.plcity = c.getCity();
		this.plpostcode = c.getPlpostcode();
		this.address = c.getAddress();
		this.city = c.getCity();
		this.postcode = c.getPostcode();
		this.phone = c.getPhone();
		this.email = c.getEmail();
		this.bedid = c.getBedid();	
		
		if(bedid == null) {
			this.isOhter = true; 
		}
	}
	
	public void setFromPermitStatement(PermitStatement p) {
		this.statement = p.getStatement();
		this.statementValidFrom = p.getStatementValidFrom();
		this.statementValidTo = p.getStatementValidTo();
		this.statementType = p.getStatementType();
		this.permit = p.getPermit();
		this.permitValidFrom = p.getPermitValidFrom();
		this.permitValidTo = p.getPermitValidTo();
		this.other = p.getOther();
	}
	
	public void setFromResidency(Residency r) {
		this.biopassport = r.getBiopassport();
		this.passport = r.getPassport();
		this.visa = r.getVisa();
		this.visaValidFrom = r.getVisaValidFrom();
		this.visaValidTo = r.getVisaValidTo();
	}

	public WorkerAll() {
		
	}
	
	public WorkerAll(Dismissed d) {
		this.id = d.getId();
		this.firstname = d.getFirstname();
		this.lastname = d.getLastname();
		this.sex = d.getSex();
		this.workerNo = d.getWorkerNo();
		this.dateofbirth = d.getDateofbirth();
		this.email = d.getEmail();
		this.phone = d.getPhone();
		this.pesel = d.getPesel();
		this.accountnr = d.getAccountnr();
		this.note = d.getNote();
		this.passport = d.getPassport();
		this.biopassport = d.getBiopassport();
		this.address = d.getAddress();
		this.postcode = d.getPostcode();
		this.city = d.getCity();
		this.addToSystem = d.getAddToSystem();
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Long recruiter) {
		this.recruiter = recruiter;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsBiopass() {
		return isBiopass;
	}

	public void setIsBiopass(Boolean isBiopass) {
		this.isBiopass = isBiopass;
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

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Long getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getBedid() {
		return bedid;
	}

	public void setBedid(Long bedid) {
		this.bedid = bedid;
	}

	public Boolean getIsOhter() {
		return isOhter;
	}

	public void setIsOhter(Boolean isOhter) {
		this.isOhter = isOhter;
	}

	public String getPladdress() {
		return pladdress;
	}

	public void setPladdress(String pladdress) {
		this.pladdress = pladdress;
	}

	public String getPlpostcode() {
		return plpostcode;
	}

	public void setPlpostcode(String plpostcode) {
		this.plpostcode = plpostcode;
	}

	public String getPlcity() {
		return plcity;
	}

	public void setPlcity(String plcity) {
		this.plcity = plcity;
	}

	public LocalDate getAcomdate() {
		return acomdate;
	}

	public void setAcomdate(LocalDate acomdate) {
		this.acomdate = acomdate;
	}

	public Integer getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Integer citizenship) {
		this.citizenship = citizenship;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public String getWorkerNo() {
		return workerNo;
	}

	public void setWorkerNo(String workerNo) {
		this.workerNo = workerNo;
	}

	public LocalDate getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}

	public LocalDate getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}

	public LocalDate getStartZus() {
		return startZus;
	}

	public void setStartZus(LocalDate startZus) {
		this.startZus = startZus;
	}

	public LocalDate getEndZus() {
		return endZus;
	}

	public void setEndZus(LocalDate endZus) {
		this.endZus = endZus;
	}

	public LocalDate getStartMedicalExams() {
		return startMedicalExams;
	}

	public void setStartMedicalExams(LocalDate startMedicalExams) {
		this.startMedicalExams = startMedicalExams;
	}

	public LocalDate getEndMedicalExams() {
		return endMedicalExams;
	}

	public void setEndMedicalExams(LocalDate endMedicalExams) {
		this.endMedicalExams = endMedicalExams;
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

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public LocalDate getVisaValidFrom() {
		return visaValidFrom;
	}

	public void setVisaValidFrom(LocalDate visaValidFrom) {
		this.visaValidFrom = visaValidFrom;
	}

	public LocalDate getVisaValidTo() {
		return visaValidTo;
	}

	public void setVisaValidTo(LocalDate visaValidTo) {
		this.visaValidTo = visaValidTo;
	}

	public LocalDate getAddToSystem() {
		return addToSystem;
	}

	public void setAddToSystem(LocalDate addToSystem) {
		this.addToSystem = addToSystem;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getAccountnr() {
		return accountnr;
	}

	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public String getsWage() {
		return sWage;
	}

	public void setsWage(String sWage) {
		this.sWage = sWage;
	}
}
