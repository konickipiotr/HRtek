package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.NewWorker;
import com.hrtek.user.recruitment.WorkerAll;

@Entity
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
	
	

	public WorkerBasic(Long id, Long department, Integer citizenship, LocalDate dateofbirth, String sex,
			String accountnr, String pesel, String workerNo) {
		this.id = id;
		this.department = department;
		this.citizenship = citizenship;
		this.dateofbirth = dateofbirth;
		this.sex = sex;
		this.accountnr = accountnr;
		this.pesel = pesel;
		this.workerNo = workerNo;
	}

	@Override
	public String toString() {
		return "[department=" + department + ", citizenship=" + citizenship + ", dateofbirth=" + dateofbirth
				+ ", sex=" + sex + ", accountnr=" + accountnr + ", pesel=" + pesel + ", workerNo=" + workerNo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Integer getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Integer citizenship) {
		this.citizenship = citizenship;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAccountnr() {
		return accountnr;
	}

	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getWorkerNo() {
		return workerNo;
	}

	public void setWorkerNo(String workerNo) {
		this.workerNo = workerNo;
	}
}
