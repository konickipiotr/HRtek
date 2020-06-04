package com.hrtek.user.report.views;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReportStartWork {
	
	private String firstname;
	private String lastname;
	private LocalDate startWork;
	private LocalDate endWork;
}
