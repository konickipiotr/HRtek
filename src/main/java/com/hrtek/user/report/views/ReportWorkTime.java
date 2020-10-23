package com.hrtek.user.report.views;

import lombok.Data;

@Data
public class ReportWorkTime {
	
	private String firstname;
	private String lastname;
	private String company;
	private String months;
	private int days;
	private boolean greaterThansixteen = false;
}
