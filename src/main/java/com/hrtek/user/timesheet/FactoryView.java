package com.hrtek.user.timesheet;

import java.util.List;

import com.hrtek.model.Factory;

import lombok.Data;

@Data
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
}
