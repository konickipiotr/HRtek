package com.hrtek.user.recruitment;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;

import lombok.Data;

@Data
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
	
	private Integer citizenship;
	private Long department;
	private String workerNo;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startWork;
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
}
