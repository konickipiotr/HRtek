package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


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

	public boolean isByStartMedicalFrom() {
		return byStartMedicalFrom;
	}

	public void setByStartMedicalFrom(boolean byStartMedicalFrom) {
		this.byStartMedicalFrom = byStartMedicalFrom;
	}

	public boolean isByStartMedicalTo() {
		return byStartMedicalTo;
	}

	public void setByStartMedicalTo(boolean byStartMedicalTo) {
		this.byStartMedicalTo = byStartMedicalTo;
	}

	public boolean isByAddToSystem() {
		return byAddToSystem;
	}

	public void setByAddToSystem(boolean byAddToSystem) {
		this.byAddToSystem = byAddToSystem;
	}

	public String getByRecruiter() {
		return byRecruiter;
	}

	public void setByRecruiter(String byRecruiter) {
		this.byRecruiter = byRecruiter;
	}

	public String getByFactory() {
		return byFactory;
	}

	public void setByFactory(String byFactory) {
		this.byFactory = byFactory;
	}

	public String getByCompany() {
		return byCompany;
	}

	public void setByCompany(String byCompany) {
		this.byCompany = byCompany;
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

	public SearchingMethod getStartMedicalFromMethod() {
		return startMedicalFromMethod;
	}

	public void setStartMedicalFromMethod(SearchingMethod startMedicalFromMethod) {
		this.startMedicalFromMethod = startMedicalFromMethod;
	}

	public LocalDate getStartMedicalFromFrom() {
		return startMedicalFromFrom;
	}

	public void setStartMedicalFromFrom(LocalDate startMedicalFromFrom) {
		this.startMedicalFromFrom = startMedicalFromFrom;
	}

	public LocalDate getStartMedicalFromTo() {
		return startMedicalFromTo;
	}

	public void setStartMedicalFromTo(LocalDate startMedicalFromTo) {
		this.startMedicalFromTo = startMedicalFromTo;
	}

	public SearchingMethod getEndMedicalToMethod() {
		return endMedicalToMethod;
	}

	public void setEndMedicalToMethod(SearchingMethod endMedicalToMethod) {
		this.endMedicalToMethod = endMedicalToMethod;
	}

	public LocalDate getEndMedicalFrom() {
		return endMedicalFrom;
	}

	public void setEndMedicalFrom(LocalDate endMedicalFrom) {
		this.endMedicalFrom = endMedicalFrom;
	}

	public LocalDate getEndMedicalTo() {
		return endMedicalTo;
	}

	public void setEndMedicalTo(LocalDate endMedicalTo) {
		this.endMedicalTo = endMedicalTo;
	}

	public SearchingMethod getAddToSystemMethod() {
		return addToSystemMethod;
	}

	public void setAddToSystemMethod(SearchingMethod addToSystemMethod) {
		this.addToSystemMethod = addToSystemMethod;
	}

	public LocalDate getAddToSystemFrom() {
		return addToSystemFrom;
	}

	public void setAddToSystemFrom(LocalDate addToSystemFrom) {
		this.addToSystemFrom = addToSystemFrom;
	}

	public LocalDate getAddToSystemTo() {
		return addToSystemTo;
	}

	public void setAddToSystemTo(LocalDate addToSystemTo) {
		this.addToSystemTo = addToSystemTo;
	}
}
