package com.hrtek.user.dismissed;

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

import lombok.Data;

@Entity
@Data
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
	private double hourlyrate;
	private double wage;
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

}
