package com.hrtek.utils;

import com.hrtek.settings.GlobalSettings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

	public static int compareDate(String member, String o, boolean up) {
		LocalDate dMember, dOther;
		try {
			dMember = new SimpleDateFormat("dd/MM/yyyy")
					.parse(member)
					.toInstant()
					.atZone(GlobalSettings.zid)
					.toLocalDate();

			dOther = new SimpleDateFormat("dd/MM/yyyy")
					.parse(o)
					.toInstant()
					.atZone(GlobalSettings.zid)
					.toLocalDate();

		} catch (ParseException e) {
			if(up)
				return 1;
			else
				return -1;
		}

		if(up) {
			if(dMember == null) return 1;
			if(dOther == null) return -1;
			return dMember.compareTo(dOther);
		}
		if(dMember == null) return -1;
		if(dOther == null) return 1;
		return -dMember.compareTo(dOther);
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

	public static int compareNumber(String member, String other, boolean up) {

		int thisval;
		int o;

		try{
			thisval = Integer.parseInt(member);
			o = Integer.parseInt(other);
		}catch (NumberFormatException e){
			return 0;
		}

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
