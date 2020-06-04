package com.hrtek.user.report.views;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReportZus {

	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String sex;
	private String pesel;
	private String citizenship;
	private String facotry;
	private String company;
	private String passport;
	private String type;
	private LocalDate startZus;
	private LocalDate endZus;
	private String address;
}
