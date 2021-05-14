package com.hrtek.user.statistic;

import java.util.List;

import com.hrtek.model.Company;


public class CompanyStat {
	
	private Long id;
	private String shortname;
	private int less26;
	private int more26;
	private int currentnumofworkers;
	private List<FactoryStat> factorystat;
	
	public CompanyStat(Company c) {
		this.id = c.getId();
		this.shortname = c.getShortname();
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

	public int getLess26() {
		return less26;
	}

	public void setLess26(int less26) {
		this.less26 = less26;
	}

	public int getMore26() {
		return more26;
	}

	public void setMore26(int more26) {
		this.more26 = more26;
	}

	public int getCurrentnumofworkers() {
		return currentnumofworkers;
	}

	public void setCurrentnumofworkers(int currentnumofworkers) {
		this.currentnumofworkers = currentnumofworkers;
	}

	public List<FactoryStat> getFactorystat() {
		return factorystat;
	}

	public void setFactorystat(List<FactoryStat> factorystat) {
		this.factorystat = factorystat;
	}	
}
