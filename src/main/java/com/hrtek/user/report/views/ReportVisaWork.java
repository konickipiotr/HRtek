package com.hrtek.user.report.views;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReportVisaWork {
	
	private String firstname;
	private String lastname;
	private String type;
	private LocalDate startWork;
	private LocalDate startStatement;
}
