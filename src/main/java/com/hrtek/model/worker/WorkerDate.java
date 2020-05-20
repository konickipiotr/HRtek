package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

import lombok.Data;

@Entity
@Data
public class WorkerDate {

	@Id
	private Long id;
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
	
	public WorkerDate() {
	}
	
	public WorkerDate(Worker w, NewWorker nw) {
		this.id = w.getId();
		this.startZus = nw.getStartZus();
		this.endZus = nw.getEndZus();
		this.addToSystem = LocalDate.now();
	}
	
	public void update(WorkerAll w) {
		this.startZus = w.getStartZus();
		this.endZus = w.getEndZus();
		this.startWork = w.getStartWork();
		this.startMedicalExams = w.getStartMedicalExams();
		this.endMedicalExams = w.getEndMedicalExams();
	}
}
