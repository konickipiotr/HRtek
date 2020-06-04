package com.hrtek.user.timesheet;

import lombok.Data;

@Data
public class MonthFrom {
	
	private Long workerid;
	private Long factoryid;
	private int mon;
	private int year;
	private String[] hour;

}
