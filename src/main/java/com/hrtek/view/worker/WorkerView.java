package com.hrtek.view.worker;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;


public class WorkerView {
	private Long id;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING)
	private StatusWorker status;
	private String factory;
	private String company;
	private String recruiter;
	
	public WorkerView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		this.status = w.getStatus();
	}

	public WorkerView() {
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

	public StatusWorker getStatus() {
		return status;
	}

	public void setStatus(StatusWorker status) {
		this.status = status;
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

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}
}
