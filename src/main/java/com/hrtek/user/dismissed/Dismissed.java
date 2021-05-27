package com.hrtek.user.dismissed;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.model.worker.WorkerFinance;


@Entity
public class Dismissed {
	
	@Id
	@GeneratedValue
	private Long id;
	private String workerNo;
	private String factory;
	private String company;
	private String firstname;
	private String lastname;
	private String sex;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String citizenship;
	private String department;
	private String email;
	private String phone;
	private String recruiter;
	private String pesel;
	private String accountnr;
	private BigDecimal hourlyrate;
	private BigDecimal wage;
	@Lob
	private String note;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endWork;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	
	private LocalDate startMedicalExams;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	
	private LocalDate endMedicalExams;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate addToSystem;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dismisseddate;
	
	private String passport;
	private String biopassport;
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
	private String others;
	
	private String visa;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidTo;
	
	private String address;
	private String postcode;
	private String city;
	
	private String pladdress;
	private String plpostcode;
	private String plcity;

	public Dismissed() {
		this.hourlyrate = new BigDecimal("0");
		this.wage = new BigDecimal("0");
	}

	public void fromWorker(Worker w) {
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
	}
	
	public void fromWorkerBasic(WorkerBasic wb) {
		this.dateofbirth = wb.getDateofbirth();
		this.sex = wb.getSex();
		this.pesel = wb.getPesel();
		this.accountnr = wb.getAccountnr();
		this.workerNo = wb.getWorkerNo();
	}
	
	public void fromWorkerFinance(WorkerFinance wf) {
		this.hourlyrate = wf.getHourlyrate();
		this.wage = wf.getWage();
	}
	
	public void fromWorkerDate(WorkerDate wd) {
		this.startZus = wd.getStartZus();
		this.startWork = wd.getStartWork();
		this.endZus = wd.getEndZus();
		this.endWork = wd.getEndWork();
		this.startMedicalExams = wd.getStartMedicalExams();
		this.endMedicalExams = wd.getEndMedicalExams();
		this.addToSystem = wd.getAddToSystem();
	}
	
	public void fromResidency(Residency r) {
		this.biopassport = r.getBiopassport();
		this.passport = r.getPassport();
		this.visa = r.getVisa();
		this.visaValidFrom = r.getVisaValidFrom();
		this.visaValidTo = r.getVisaValidTo();
	}
	
	public void fromPermitStatement(PermitStatement ps) {
		this.statement = ps.getStatement();
		this.statementType = ps.getStatementType();
		this.statementValidFrom = ps.getStatementValidFrom();
		this.statementValidTo = ps.getStatementValidTo();
		this.permit = ps.getPermit();
		this.permitValidFrom = ps.getPermitValidFrom();
		this.permitValidTo = ps.getPermitValidTo();
		this.others = ps.getOther();
	}
	
	public void fromContact(Contact c) {
		this.pladdress = c.getPladdress();
		this.plpostcode = c.getPlpostcode();
		this.plcity = c.getPlcity();
		this.postcode = c.getPostcode();
		this.address = c.getAddress();
		this.city = c.getCity();
		this.email = c.getEmail();
		this.phone = c.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkerNo() {
		return workerNo;
	}

	public void setWorkerNo(String workerNo) {
		this.workerNo = workerNo;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getAccountnr() {
		return accountnr;
	}

	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}

	public BigDecimal getHourlyrate() {
		return hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public void setHourlyrate(BigDecimal hourlyrate) {
		this.hourlyrate = hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getWage() {
		return wage.setScale(2, RoundingMode.HALF_UP);
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage.setScale(2, RoundingMode.HALF_UP);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public LocalDate getAddToSystem() {
		return addToSystem;
	}

	public void setAddToSystem(LocalDate addToSystem) {
		this.addToSystem = addToSystem;
	}

	public LocalDate getDismisseddate() {
		return dismisseddate;
	}

	public void setDismisseddate(LocalDate dismisseddate) {
		this.dismisseddate = dismisseddate;
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

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
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
}
