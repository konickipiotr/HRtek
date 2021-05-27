package com.hrtek.user.managingfile;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class MonHeader {

	private Map<Integer, String> dayH = new TreeMap<>();

	public MonHeader(LocalDate ld) {
		YearMonth yearMonthObject = YearMonth.of(ld.getYear(), ld.getMonthValue());
		int daysInMonth = yearMonthObject.lengthOfMonth();
		
		for(int i = 1; i <= daysInMonth; i++) {
			LocalDate day = LocalDate.of(ld.getYear(), ld.getMonthValue(), i);
			String dayofWeek = day.getDayOfWeek().getDisplayName(TextStyle.SHORT,Locale.ENGLISH);
			dayH.put(i, dayofWeek);
		}
	}

	public Map<Integer, String> getDayH() {
		return dayH;
	}

	public void setDayH(Map<Integer, String> dayH) {
		this.dayH = dayH;
	}
}
