package com.hrtek.user.timesheet;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;


public class DateTimesheetOperation {
	
	private final LocalDate lastPrevious = LocalDate.of(2020, 02, 01);
	private final LocalDate lastNext = LocalDate.of(2040, 12, 1);

	private LocalDate selected;
	
	public DateTimesheetOperation(int mon) {
		LocalDate now = LocalDate.now(ZoneId.systemDefault());
		selected = now.plusMonths(mon);
	}
	
	public int getMonthLength() {
		YearMonth yearMonth = YearMonth.of(selected.getYear(), selected.getMonthValue());
		return yearMonth.lengthOfMonth();
	}
	
	public int getFirstDayOfMonth() {
		return selected.getDayOfYear() - selected.getDayOfMonth();
	}
	
	public int getYear() {
		return selected.getYear();
	}
	
	public int getMonth() {
		return selected.getMonthValue();
	}
	
	public boolean previousIsPossible() {
		return selected.isAfter(lastPrevious);
	}
	
	public boolean nextIsPossible() {
		return selected.isBefore(lastNext);
	}

	public LocalDate getSelected() {
		return selected;
	}

	public void setSelected(LocalDate selected) {
		this.selected = selected;
	}
}
