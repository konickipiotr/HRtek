package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


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

	public boolean isByvisafrom() {
		return byvisafrom;
	}

	public void setByvisafrom(boolean byvisafrom) {
		this.byvisafrom = byvisafrom;
	}

	public boolean isByvisato() {
		return byvisato;
	}

	public void setByvisato(boolean byvisato) {
		this.byvisato = byvisato;
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

	public String getByStatus() {
		return byStatus;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
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

	public SearchingMethod getVisaMethodFrom() {
		return visaMethodFrom;
	}

	public void setVisaMethodFrom(SearchingMethod visaMethodFrom) {
		this.visaMethodFrom = visaMethodFrom;
	}

	public LocalDate getVisaValidFromFrom() {
		return visaValidFromFrom;
	}

	public void setVisaValidFromFrom(LocalDate visaValidFromFrom) {
		this.visaValidFromFrom = visaValidFromFrom;
	}

	public LocalDate getVisaValidFromTo() {
		return visaValidFromTo;
	}

	public void setVisaValidFromTo(LocalDate visaValidFromTo) {
		this.visaValidFromTo = visaValidFromTo;
	}

	public SearchingMethod getVisaMethodTo() {
		return visaMethodTo;
	}

	public void setVisaMethodTo(SearchingMethod visaMethodTo) {
		this.visaMethodTo = visaMethodTo;
	}

	public LocalDate getVisaValidToFrom() {
		return visaValidToFrom;
	}

	public void setVisaValidToFrom(LocalDate visaValidToFrom) {
		this.visaValidToFrom = visaValidToFrom;
	}

	public LocalDate getVisaValidToTo() {
		return visaValidToTo;
	}

	public void setVisaValidToTo(LocalDate visaValidToTo) {
		this.visaValidToTo = visaValidToTo;
	}
}
