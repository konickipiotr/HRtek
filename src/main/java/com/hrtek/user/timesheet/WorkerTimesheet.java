package com.hrtek.user.timesheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class WorkerTimesheet implements Comparable<WorkerTimesheet> {
	
	private Long id;
	private String name;
	private String workernr;
	private String department;
	private BigDecimal total;
	private int hsum;
	private String companyname;
	
	private List<String> hourlList;

	@Override
	public int compareTo(WorkerTimesheet o) {

		int ret =  this.companyname.compareTo(o.getCompanyname());
		if(ret == 0) {
			return this.name.compareToIgnoreCase(o.getName());
		}
		return ret;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkernr() {
		return workernr;
	}

	public void setWorkernr(String workernr) {
		this.workernr = workernr;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getTotal() {
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTotal(BigDecimal total) {
		this.total = total.setScale(2, RoundingMode.HALF_UP);
	}

	public int getHsum() {
		return hsum;
	}

	public void setHsum(int hsum) {
		this.hsum = hsum;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<String> getHourlList() {
		return hourlList;
	}

	public void setHourlList(List<String> hourlList) {
		this.hourlList = hourlList;
	}
}
