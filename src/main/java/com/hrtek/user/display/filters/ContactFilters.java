package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


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

	public boolean isBytext() {
		return bytext;
	}

	public void setBytext(boolean bytext) {
		this.bytext = bytext;
	}

	public boolean isBydateofbirth() {
		return bydateofbirth;
	}

	public void setBydateofbirth(boolean bydateofbirth) {
		this.bydateofbirth = bydateofbirth;
	}

	public String getByCompany() {
		return byCompany;
	}

	public void setByCompany(String byCompany) {
		this.byCompany = byCompany;
	}

	public String getByFactory() {
		return byFactory;
	}

	public void setByFactory(String byFactory) {
		this.byFactory = byFactory;
	}

	public Long getByHouse() {
		return byHouse;
	}

	public void setByHouse(Long byHouse) {
		this.byHouse = byHouse;
	}

	public SearchingMethod getSearchingMethod() {
		return searchingMethod;
	}

	public void setSearchingMethod(SearchingMethod searchingMethod) {
		this.searchingMethod = searchingMethod;
	}

	public SearchByField getSearchbyfield() {
		return searchbyfield;
	}

	public void setSearchbyfield(SearchByField searchbyfield) {
		this.searchbyfield = searchbyfield;
	}

	public String getTexttosearch() {
		return texttosearch;
	}

	public void setTexttosearch(String texttosearch) {
		this.texttosearch = texttosearch;
	}

	public SearchingMethod getDateofbirthMethod() {
		return dateofbirthMethod;
	}

	public void setDateofbirthMethod(SearchingMethod dateofbirthMethod) {
		this.dateofbirthMethod = dateofbirthMethod;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public LocalDate getDateofbirthTo() {
		return dateofbirthTo;
	}

	public void setDateofbirthTo(LocalDate dateofbirthTo) {
		this.dateofbirthTo = dateofbirthTo;
	}
}
