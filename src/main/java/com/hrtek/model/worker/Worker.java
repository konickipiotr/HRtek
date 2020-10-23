package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

import lombok.Data;

@Entity
@Data
public class Worker {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING)
	private StatusWorker status;
	private Long factoryid;
	private Long companyid;
	private Long recruiter;
	
	public Worker() {
		this.status = StatusWorker.INACTIVE;
	}

	public Worker(NewWorker nw) {
		this.firstname = nw.getFirstname();
		this.lastname = nw.getLastname();
		
		if(nw.getStartZus() == null)
			status = StatusWorker.INACTIVE;
		else 
			status = StatusWorker.ACTIVE;
		
		this.factoryid = nw.getFactoryid();
		this.companyid = nw.getCompanyid();
		this.recruiter = nw.getRecruiter();
	}
	
	public Worker(WorkerAll nw) {
		this.firstname = nw.getFirstname();
		this.lastname = nw.getLastname();
		
		if(nw.getStartZus() == null)
			status = StatusWorker.INACTIVE;
		else 
			status = StatusWorker.ACTIVE;
		
		this.factoryid = nw.getFactoryid();
		this.companyid = nw.getCompanyid();
		this.recruiter = nw.getRecruiter();
	}

	public Worker(Long id, String firstname, String lastname, StatusWorker status, Long factoryid, Long company,
			Long recruiter) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.factoryid = factoryid;
		this.companyid = company;
		this.recruiter = recruiter;
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}

	@Override
	public String toString() {
		return "[firstname=" + firstname + ", lastname=" + lastname + ", status=" + status + ", factoryid="
				+ factoryid + ", companyid=" + companyid + ", recruiter=" + recruiter + "]";
	}
	
	
}
