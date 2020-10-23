package com.hrtek.admin.others;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.display.filters.SearchByField;
import com.hrtek.user.display.filters.SearchingMethod;

import lombok.Data;

@Data
public class WorkerFilters {

	private boolean bytext;
	private boolean bydateofbirth;
	private String byCompany;
	private String byFactory;

	private SearchingMethod searchingMethod;
	private SearchByField searchbyfield;
	private String texttosearch;
	
	private SearchingMethod dateofbirthMethod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateofbirthTo;
	
	
	public WorkerFilters() {
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
	}

	
}
