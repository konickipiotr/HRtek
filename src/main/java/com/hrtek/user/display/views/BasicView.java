package com.hrtek.user.display.views;

import java.time.LocalDate;

import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;

import lombok.Data;

@Data
public class BasicView {

	private int status;
	private Long id;
	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String sex;
	private String citizenship;
	private String pesel;
	private String paszport;
	private String biopaszport;
	private String company;
	private String factory;
	private LocalDate startWork;
	private LocalDate startZus;
	private LocalDate endWork;
	private LocalDate endZus;	
	
	public BasicView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		if(w.getStatus().equals(StatusWorker.ACTIVE))
			this.status = 1;
		else
			this.status = 0;
	}
	
	public void setFromWorkerBasic(WorkerBasic wb) {
		this.dateofbirth = wb.getDateofbirth();
		this.sex = wb.getSex();
		this.pesel = wb.getPesel();
	}
	
	public void setFromWorkerDate(WorkerDate wd) {
		this.startWork = wd.getStartWork();
		this.startZus = wd.getStartZus();
		this.endZus = wd.getEndZus();
	}
	
	public void setFromResidency(Residency re) {
		this.paszport = re.getPassport();
		this.biopaszport = re.getBiopassport();
	}
}
