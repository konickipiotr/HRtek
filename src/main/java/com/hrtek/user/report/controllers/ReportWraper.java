package com.hrtek.user.report.controllers;

import java.util.List;


public class ReportWraper<T> {
	
	private String reportType;
	private List<T> report;
	
	public ReportWraper() {
	}
	
	public ReportWraper(String reportType, List<T> report) {
		super();
		this.reportType = reportType;
		this.report = report;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public List<T> getReport() {
		return report;
	}
	public void setReport(List<T> report) {
		this.report = report;
	}
}
