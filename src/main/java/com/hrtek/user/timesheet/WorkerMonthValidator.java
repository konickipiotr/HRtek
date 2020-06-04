package com.hrtek.user.timesheet;

public class WorkerMonthValidator {
	
	private MonthFrom mf;
	private String msg;
	private int countErr;
	private boolean wrongInput = false;
	private boolean wrongRange = false;

	public WorkerMonthValidator(MonthFrom mf) {
		this.mf = mf;
		this.msg = "";
		this.countErr = 0;
	}
	
	public String getMessge() {
		if(countErr > 0) {
			msg += "Errors: " + countErr + ". Type:";
			if(wrongInput) msg += "wrong input ";
			if(wrongRange) msg += "wrong range ";
		}
		return this.msg;
	}
	
	public boolean validate() {
		String[] arr = mf.getHour();
		
		for(int i = 0; i < arr.length; i++) {
			if(!(arr[i].toLowerCase().equals("ho") || arr[i].toLowerCase().equals("nw") || arr[i].toLowerCase().equals("00"))) {
				try {
					int val = Integer.parseInt(arr[i]);
					if(val<0 || val > 24) {
						countErr++;
						wrongRange = true;
					}
				}catch (NumberFormatException e) {
					wrongInput = true;
					countErr++;
				}
			}
			
			if(arr[i].toLowerCase().equals("ho"))
				arr[i] = arr[i].toUpperCase();
			
			if(arr[i].toLowerCase().equals("nw"))
				arr[i] = arr[i].toUpperCase();
		}
		
		if(countErr == 0) return true;
		return false;
	}
	
}
