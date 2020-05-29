package com.hrtek.user.display.filters;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public abstract class DateFilterOperation<T, V> {

	public abstract void setFilter(V v);
	public abstract List<T> datefilter(List<T> list);


	
	
	protected boolean checkEqual(LocalDate searched, LocalDate current) {
		if(searched == null || current == null) return false;
		if(searched.compareTo(current) == 0)return true;
		return false;
	}
	
	protected boolean checkRange(LocalDate searchFrom, LocalDate searchTo, LocalDate current) {
		if(current == null) return false;
		
		if(searchFrom != null && searchTo != null) 
			return isAfter(current, searchFrom) && isBefore(current, searchTo);
		else if(searchFrom == null && searchTo != null)
			return isBefore(current, searchTo);
		else if(searchFrom != null && searchTo == null)
			return isAfter(current, searchFrom);
		return false;
	}
	
	protected boolean isLessThan26(LocalDate dateofbirth) {
		if(dateofbirth == null) return false; 
		LocalDate now = LocalDate.now(); //TODO zone?
		LocalDate minus26 = now.minusYears(26);
		if(dateofbirth.isBefore(minus26)) return false;
		return true;
	}
	
	private boolean isAfter(LocalDate current, LocalDate searchFrom) {
		return current.isAfter(searchFrom);
	}
	
	private boolean isBefore(LocalDate current, LocalDate searchTo) {
		return current.isBefore(searchTo);
	}
}

	
