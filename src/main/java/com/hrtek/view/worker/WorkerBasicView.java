package com.hrtek.view.worker;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.WorkerBasic;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class WorkerBasicView {
	
	private Long id;
	private String department;
	private String citizenship;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String sex;
	private String accountnr;
	private String pesel;
	private Long workerNo;
	
	public WorkerBasicView(WorkerBasic wb) {
		this.id = wb.getId();
		this.dateofbirth = wb.getDateofbirth();
		this.sex = wb.getSex();
		this.accountnr = wb.getAccountnr();
		this.pesel = wb.getPesel();
		this.workerNo = wb.getWorkerNo();
	}
}
