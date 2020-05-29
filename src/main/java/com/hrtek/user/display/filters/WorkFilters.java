package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WorkFilters {

	private boolean bytext;
	private boolean bydateofbirth;
	private boolean byStartWork;
	private boolean byStartZus;
	private boolean byEndZus;
	private boolean byEndWork;
	private boolean byPermiFrom;
	private boolean byPermiTo;
	private boolean byStatementFrom;
	private boolean byStatementTo;	
	private String byCompany;
	private String byRecruiter;
	private String byFactory;
	private String byStatus;
	private String byStatementType;
	
	
	private SearchingMethod searchingMethod;
	private SearchByField searchbyfield;
	private String texttosearch;
	
	private SearchingMethod dateofbirthMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirthTo;
	
	private SearchingMethod startWorkMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startWork;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startWorkTo;
	
	private SearchingMethod startZusMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startZus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startZusTo;
	
	private SearchingMethod endZusMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endZus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endZusTo;
	
	private SearchingMethod endWorkMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endWork;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endWorkTo;
	
	private SearchingMethod statementValidFromMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate statementValidFromFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate statementValidFromTo;
	
	private SearchingMethod statementValidToMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate statementValidToFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate statementValidToTo;
	
	private SearchingMethod permitValidFromoMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate permitValidFromFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate permitValidFromTo;
	
	private SearchingMethod permitValidToMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate permitValidToFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate permitValidToTo;
	
	public WorkFilters() {
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
		this.startWorkMethod = SearchingMethod.EQUAL;
		this.startZusMethod = SearchingMethod.EQUAL;
		this.endWorkMethod = SearchingMethod.EQUAL;
		this.endZusMethod = SearchingMethod.EQUAL;
		this.statementValidFromMethod = SearchingMethod.EQUAL;
		this.statementValidToMethod = SearchingMethod.EQUAL;
		this.permitValidFromoMethod = SearchingMethod.EQUAL;
		this.permitValidToMethod = SearchingMethod.EQUAL;
		this.byStatus = "ALL";
	}
	
}
