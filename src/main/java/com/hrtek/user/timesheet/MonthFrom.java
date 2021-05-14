package com.hrtek.user.timesheet;


public class MonthFrom {
	
	private Long workerid;
	private Long factoryid;
	private int mon;
	private int year;
	private String[] hour;
	public Long getWorkerid() {
		return workerid;
	}
	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}
	public Long getFactoryid() {
		return factoryid;
	}
	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String[] getHour() {
		return hour;
	}
	public void setHour(String[] hour) {
		this.hour = hour;
	}
}
