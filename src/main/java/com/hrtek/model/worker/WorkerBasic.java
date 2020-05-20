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
	private Long workerNo;
	
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
}
