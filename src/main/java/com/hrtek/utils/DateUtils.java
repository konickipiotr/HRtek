package com.hrtek.utils;

import java.sql.Date;

public class DateUtils {
	public static boolean checkIsBefore(Date toCompare, String to) {
		if(toCompare == null)
			return false;
		if( to == null || to.isBlank())
			return true;
		if(toCompare.before(Date.valueOf(to)))
			return true;
		return false;
	}
	
	public static  boolean checkisAfter(Date toCompare, String from) {
		if(toCompare == null)
			return false;
		if( from == null || from.isBlank())
			return true;
		if(toCompare.after(Date.valueOf(from)))
			return true;
		return false;
	}
	
	public static Date convertDate(String sdate) {
		if(!(sdate == null || sdate.isBlank())) 
			return Date.valueOf(sdate);
		
		return null;
	}
}
