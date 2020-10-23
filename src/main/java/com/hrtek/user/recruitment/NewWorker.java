package com.hrtek.user.recruitment;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NewWorker {
	
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
	
	private double wage;
	private String sWage;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startZus;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endZus;
	
	public NewWorker() {	
		this.sex = "M";
	}
	
	public NewWorker(Candidate c) {
		fillFromCandidate(c);
	}
	
	public void fillFromCandidate(Candidate c) {
		this.id = c.getId();
		this.firstname = c.getFirstname();
		this.lastname = c.getLastname();
		this.sex = c.getSex();
		this.email = c.getEmail();
		this.phone = c.getPhone();
		this.recruiter = c.getRecruiter();
		this.note = c.getNote();
	}

}
