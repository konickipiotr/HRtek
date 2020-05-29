package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContactFilters {
	private boolean bytext;
	private boolean bydateofbirth;
	private String byCompany;
	private String byFactory;
	private Long byHouse;
	
	private SearchingMethod searchingMethod;
	private SearchByField searchbyfield;
	private String texttosearch;
	
	private SearchingMethod dateofbirthMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirthTo;
	
	public ContactFilters() {
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
	}
}
