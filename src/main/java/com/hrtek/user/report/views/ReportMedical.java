package com.hrtek.user.report.views;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReportMedical {

	private String firstname;
	private String lastname;
	private LocalDate statrtMedical;
	private LocalDate endMedical;
	private String factory;
}
