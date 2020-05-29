package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ResidencyFilter {

	private boolean bytext;
	private boolean bydateofbirth;
	private boolean byvisafrom;
	private boolean byvisato;
	private String byCompany;
	private String byFactory;
	private String byStatus;
	
	private SearchingMethod searchingMethod;
	private SearchByField searchbyfield;
	private String texttosearch;
	
	private SearchingMethod dateofbirthMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirthTo;
	
	private SearchingMethod visaMethodFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visaValidFromFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visaValidFromTo;
	
	private SearchingMethod visaMethodTo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visaValidToFrom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visaValidToTo;
	
	public ResidencyFilter() {
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
		this.visaMethodFrom = SearchingMethod.EQUAL;
		this.visaMethodTo = SearchingMethod.EQUAL;
		this.byStatus = "ALL";
	}
}
