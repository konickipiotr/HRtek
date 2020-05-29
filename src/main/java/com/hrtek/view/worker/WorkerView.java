package com.hrtek.view.worker;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

}
