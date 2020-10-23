package com.hrtek.user.display.filters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class DateFilterOperation<T, V> {

	public abstract void setFilter(V v);
	public abstract List<T> datefilter(List<T> list);


	protected boolean checkEqual(LocalDateTime searched, LocalDateTime current) {
		if(searched == null || current == null) return false;
		searched = searched.truncatedTo(ChronoUnit.DAYS);
		current = current.truncatedTo(ChronoUnit.DAYS);
		if(searched.compareTo(current) == 0)return true;
		return false;
	}
	
	protected boolean checkRange(LocalDateTime searchFrom, LocalDateTime searchTo, LocalDateTime current) {
		if(current == null) return false;
		
		if(searchFrom != null && searchTo != null) 
			return isAfter(current, searchFrom) && isBefore(current, searchTo);
		else if(searchFrom == null && searchTo != null)
			return isBefore(current, searchTo);
		else if(searchFrom != null && searchTo == null)
			return isAfter(current, searchFrom);
		return false;
	}
	
	
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
	
	private boolean isAfter(LocalDateTime current, LocalDateTime searchFrom) {
		return current.isAfter(searchFrom);
	}
	
	private boolean isBefore(LocalDateTime current, LocalDateTime searchTo) {
		return current.isBefore(searchTo);
	}
	
	private boolean isAfter(LocalDate current, LocalDate searchFrom) {
		return current.isAfter(searchFrom);
	}
	
	private boolean isBefore(LocalDate current, LocalDate searchTo) {
		return current.isBefore(searchTo);
	}
}

	
