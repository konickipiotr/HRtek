package com.hrtek.user.statistic;

import java.util.List;

import com.hrtek.model.Company;

import lombok.Data;

@Data
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
	
	
}
