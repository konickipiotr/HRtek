package com.hrtek.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FieldsComparator {
	private FieldsComparator() {}
	
	public static int compareDateTime(LocalDateTime member, LocalDateTime o, boolean up) {
		if(up) {
			if(member == null) return 1;
			if(o == null) return -1;
			return member.compareTo(o);
		}
		if(member == null) return -1;
		if(o == null) return 1;
		return -member.compareTo(o);
	}
	
	public static int compareDate(LocalDate member, LocalDate o, boolean up) {
		if(up) {
			if(member == null) return 1;
			if(o == null) return -1;
			return member.compareTo(o);
		}
		if(member == null) return -1;
		if(o == null) return 1;
		return -member.compareTo(o);
	}
	
	public static int compareText(String member, String o, boolean up) {
		if(up) {
			if(member == null) return 1;
			if(o == null) return -1;
			return member.compareToIgnoreCase(o);
		}
		if(member == null) return -1;
		if(o == null) return 1;
		return -member.compareToIgnoreCase(o);
	}
	
	public static int compareNumber(int thisval, int o, boolean up) {
		if(up) {
			if(thisval > o) return -1;
			if(thisval < o) return 1;
			return 0;
		}
		if(thisval < o) return -1;
		if(thisval > o) return 1;
		return 0;
	}
}
