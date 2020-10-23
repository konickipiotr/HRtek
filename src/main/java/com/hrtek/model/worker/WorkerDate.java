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
		//this.startZus = nw.getStartZus();
		this.addToSystem = LocalDate.now();
	}
	
	public WorkerDate(Worker worker, WorkerAll wall) {
		this.id = worker.getId();
		this.startZus = wall.getStartZus();
		this.endZus = wall.getEndZus();
		this.startWork = wall.getStartWork();
		this.endWork = wall.getEndZus();
		this.startWork = wall.getStartWork();
		this.addToSystem = wall.getAddToSystem();
		this.startMedicalExams = wall.getStartMedicalExams();
		this.endMedicalExams = wall.getEndMedicalExams();
	}

	public void update(WorkerAll w) {
		this.startZus = w.getStartZus();
		this.endZus = w.getEndZus();
		this.startWork = w.getStartWork();
		this.startMedicalExams = w.getStartMedicalExams();
		this.endMedicalExams = w.getEndMedicalExams();
	}

	@Override
	public String toString() {
		return " [startZus=" + startZus + ", endZus=" + endZus + ", startWork=" + startWork + ", endWork="
				+ endWork + ", startMedicalExams=" + startMedicalExams + ", endMedicalExams=" + endMedicalExams
				+ ", addToSystem=" + addToSystem + "]";
	}
}
