package com.hrtek.user.statistic;

import com.hrtek.model.Factory;

import lombok.Data;

@Data
public class FactoryStat {
	
	private Long id;
	private String shortname;
	private int numofworkers;
	
	public FactoryStat(Factory f) {
		this.id = f.getId();
		this.shortname = f.getShortname();
	}
}
