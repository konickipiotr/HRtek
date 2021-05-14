package com.hrtek.user.statistic;

import com.hrtek.model.Factory;



public class FactoryStat {
	
	private Long id;
	private String shortname;
	private int numofworkers;
	
	public FactoryStat(Factory f) {
		this.id = f.getId();
		this.shortname = f.getShortname();
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

	public int getNumofworkers() {
		return numofworkers;
	}

	public void setNumofworkers(int numofworkers) {
		this.numofworkers = numofworkers;
	}	
}
