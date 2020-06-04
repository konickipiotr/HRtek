package com.hrtek.user.report.controllers;

import java.util.List;

import lombok.Data;

@Data
public class ReportWraper<T> {
	
	private String reportType;
	private List<T> report;

}
