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
public class WorkerBasic {
	
	@Id
	private Long id;
	private Long department;
	private Integer citizenship;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String sex;
	private String accountnr;
	private String pesel;
	private String workerNo;
	
	public WorkerBasic() {
	}

	public void update(WorkerAll w) {
		this.department = w.getDepartment();
		this.citizenship = w.getCitizenship();
		this.dateofbirth = w.getDateofbirth();
		this.sex = w.getSex();
		this.accountnr = w.getAccountnr();
		this.pesel = w.getPesel();
		this.workerNo = w.getWorkerNo();
	}
	
	public WorkerBasic(Worker w, NewWorker nw) {
		this.id = w.getId();
		this.dateofbirth = nw.getDateofbirth();
		this.sex = nw.getSex();
	}

	public WorkerBasic(Worker worker, WorkerAll wall) {
		this.id = worker.getId();
		this.dateofbirth = wall.getDateofbirth();
		this.sex = wall.getSex();
		this.accountnr = wall.getAccountnr();
		this.pesel = wall.getPesel();
		this.workerNo = wall.getWorkerNo();
		this.department = wall.getDepartment();
		this.citizenship = wall.getCitizenship();
	}

	@Override
	public String toString() {
		return "[department=" + department + ", citizenship=" + citizenship + ", dateofbirth=" + dateofbirth
				+ ", sex=" + sex + ", accountnr=" + accountnr + ", pesel=" + pesel + ", workerNo=" + workerNo + "]";
	}
}
