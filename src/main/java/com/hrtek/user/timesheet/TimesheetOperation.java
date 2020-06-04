package com.hrtek.user.timesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimesheetOperation {
	
	private DateTimesheetOperation dts;

	public TimesheetOperation(DateTimesheetOperation dts) {
		this.dts = dts;
	}

	public WorkerTimesheet getWorkerTimesheet(Timesheet ts) {
		
		String syear = "y" + dts.getYear();
		String currentYear = ts.getCurrentYear(syear);
		String currentMonth = currentYear.substring(2 * dts.getFirstDayOfMonth(), 2 * dts.getFirstDayOfMonth() + 2 * dts.getMonthLength());
		
		List<String> slist = getStringHourList(currentMonth);
		List<Integer> ilist = getIntegerHourList(slist);
		
		WorkerTimesheet workerTs = new WorkerTimesheet();
		workerTs.setId(ts.getWorkerid());
		workerTs.setHsum(calculateHours(ilist));
		workerTs.setHourlList(slist);

		return workerTs;
	}
	
	
	private List<String> getStringHourList(String currenMonth){
		String[] array=currenMonth.split("(?<=\\G.{2})");
		return Arrays.asList(array);
	}
	
	private List<Integer> getIntegerHourList(List<String> slist){
		List<Integer> ilist = new ArrayList<Integer>();
		for(String s : slist) {
			if(s.equals("00") || s.equals("NW") || s.equals("HO"))
				continue;
			
			ilist.add(Integer.parseInt(s));
		}
		return ilist;		
	}
	
	private int calculateHours(List<Integer> ilist) {
		return ilist.stream()
						.reduce(0, (x, y) -> x + y);
	}
}
