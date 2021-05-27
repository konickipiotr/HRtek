package com.hrtek.user.timesheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.hrtek.model.Factory;


public class FactoryView {

	private Long id;
	private String shortname;
	private int numberofwokers;
	private BigDecimal hourlyrate;
	private List<WorkerTimesheet> wts;
	
	public FactoryView(Long id, String shortname, int numberofwokers, BigDecimal hourlyrate) {
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

	public BigDecimal getHourlyrate() {
		return hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public void setHourlyrate(BigDecimal hourlyrate) {
		this.hourlyrate = hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public List<WorkerTimesheet> getWts() {
		return wts;
	}

	public void setWts(List<WorkerTimesheet> wts) {
		this.wts = wts;
	}		
}
