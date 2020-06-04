package com.hrtek.user.timesheet;

import java.util.List;

import lombok.Data;

@Data
public class WorkerTimesheet {
	
	private Long id;
	private String name;
	private String workernr;
	private String department;
	private double total;
	private int hsum;
	
	private List<String> hourlList;

}
