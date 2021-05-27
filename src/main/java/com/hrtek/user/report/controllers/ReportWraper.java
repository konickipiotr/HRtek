package com.hrtek.user.report.controllers;

import com.hrtek.user.display.views.ViewFields;

import java.util.List;


public class ReportWraper<T> {
	
	private String reportType;
	private List<String> headers;
	private List<T> report;
	private boolean sortUp;
	private ViewFields sortBy;
	private List<ViewFields> sortT;
	
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

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<T> getReport() {
		return report;
	}

	public void setReport(List<T> report) {
		this.report = report;
	}

	public boolean isSortUp() {
		return sortUp;
	}

	public void setSortUp(boolean sortUp) {
		this.sortUp = sortUp;
	}

	public ViewFields getSortBy() {
		return sortBy;
	}

	public void setSortBy(ViewFields sortBy) {
		this.sortBy = sortBy;
	}

	public List<ViewFields> getSortT() {
		return sortT;
	}

	public void setSortT(List<ViewFields> sortT) {
		this.sortT = sortT;
	}
}
