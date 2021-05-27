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

		if(slist.stream().allMatch(i -> i.equals("XX")))
			return null;
		
		WorkerTimesheet workerTs = new WorkerTimesheet();
		workerTs.setId(ts.getWorkerid());
		int hsum = calculateHours(ilist);
		workerTs.setHsum(hsum);
		workerTs.setHourlList(slist);

		return workerTs;
	}
	
	
	public static List<String> getStringHourList(String currenMonth){
		String[] array=currenMonth.split("(?<=\\G.{2})");
		return Arrays.asList(array);
	}
	
	public static List<Integer> getIntegerHourList(List<String> slist){
		List<Integer> ilist = new ArrayList<Integer>();
		for(String s : slist) {
			if(s.equals("NW") || s.equals("HO") || s.equals("XX"))
				continue;
			
			ilist.add(Integer.parseInt(s));
		}
		return ilist;		
	}
	
	public static int calculateHours(List<Integer> ilist) {
		return ilist.stream()
						.reduce(0, (x, y) -> x + y);
	}
}
