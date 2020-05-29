package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DataFilters {
	private boolean bytext;
	private boolean bydateofbirth;
	
	private boolean byStartMedicalFrom;
	private boolean byStartMedicalTo;
	private boolean byAddToSystem;
	
	
	private String byRecruiter;
	private String byFactory;
	private String byCompany;
	private String byStatus;
	
	private SearchingMethod searchingMethod;
	private SearchByField searchbyfield;
	private String texttosearch;
	
	private SearchingMethod dateofbirthMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirthTo;
	
	private SearchingMethod startMedicalFromMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startMedicalFromFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startMedicalFromTo;
	
	private SearchingMethod endMedicalToMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endMedicalFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endMedicalTo;
	
	private SearchingMethod addToSystemMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addToSystemFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate addToSystemTo;
	
	public DataFilters() {
		this.byStatus = "ALL";
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
		this.startMedicalFromMethod = SearchingMethod.EQUAL;
		this.endMedicalToMethod = SearchingMethod.EQUAL;
		this.addToSystemMethod =  SearchingMethod.EQUAL;
	}
}
