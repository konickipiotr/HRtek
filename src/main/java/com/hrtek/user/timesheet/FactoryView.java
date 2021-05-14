package com.hrtek.user.timesheet;

import java.util.List;

import com.hrtek.model.Factory;


public class FactoryView {

	private Long id;
	private String shortname;
	private int numberofwokers;
	private double hourlyrate;
	private List<WorkerTimesheet> wts;
	
	public FactoryView(Long id, String shortname, int numberofwokers, double hourlyrate) {
		this.id = id;
		this.shortname = shortname;
		this.numberofwokers = numberofwokers;
		this.hourlyrate = hourlyrate;
	}
	
	public FactoryView(Factory f) {
		this.id = f.getId();
		this.shortname = f.getShortname();
		this.numberofwokers = f.getNumberofwokers();
		this.hourlyrate = f.getHourlyrate();
	}

	public FactoryView() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public int getNumberofwokers() {
		return numberofwokers;
	}

	public void setNumberofwokers(int numberofwokers) {
		this.numberofwokers = numberofwokers;
	}

	public double getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(double hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	public List<WorkerTimesheet> getWts() {
		return wts;
	}

	public void setWts(List<WorkerTimesheet> wts) {
		this.wts = wts;
	}		
}
