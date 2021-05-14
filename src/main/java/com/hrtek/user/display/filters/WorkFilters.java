package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


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

	public boolean isByStartWork() {
		return byStartWork;
	}

	public void setByStartWork(boolean byStartWork) {
		this.byStartWork = byStartWork;
	}

	public boolean isByStartZus() {
		return byStartZus;
	}

	public void setByStartZus(boolean byStartZus) {
		this.byStartZus = byStartZus;
	}

	public boolean isByEndZus() {
		return byEndZus;
	}

	public void setByEndZus(boolean byEndZus) {
		this.byEndZus = byEndZus;
	}

	public boolean isByEndWork() {
		return byEndWork;
	}

	public void setByEndWork(boolean byEndWork) {
		this.byEndWork = byEndWork;
	}

	public boolean isByPermiFrom() {
		return byPermiFrom;
	}

	public void setByPermiFrom(boolean byPermiFrom) {
		this.byPermiFrom = byPermiFrom;
	}

	public boolean isByPermiTo() {
		return byPermiTo;
	}

	public void setByPermiTo(boolean byPermiTo) {
		this.byPermiTo = byPermiTo;
	}

	public boolean isByStatementFrom() {
		return byStatementFrom;
	}

	public void setByStatementFrom(boolean byStatementFrom) {
		this.byStatementFrom = byStatementFrom;
	}

	public boolean isByStatementTo() {
		return byStatementTo;
	}

	public void setByStatementTo(boolean byStatementTo) {
		this.byStatementTo = byStatementTo;
	}

	public String getByCompany() {
		return byCompany;
	}

	public void setByCompany(String byCompany) {
		this.byCompany = byCompany;
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

	public String getByStatus() {
		return byStatus;
	}

	public void setByStatus(String byStatus) {
		this.byStatus = byStatus;
	}

	public String getByStatementType() {
		return byStatementType;
	}

	public void setByStatementType(String byStatementType) {
		this.byStatementType = byStatementType;
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

	public SearchingMethod getStartWorkMethod() {
		return startWorkMethod;
	}

	public void setStartWorkMethod(SearchingMethod startWorkMethod) {
		this.startWorkMethod = startWorkMethod;
	}

	public LocalDate getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}

	public LocalDate getStartWorkTo() {
		return startWorkTo;
	}

	public void setStartWorkTo(LocalDate startWorkTo) {
		this.startWorkTo = startWorkTo;
	}

	public SearchingMethod getStartZusMethod() {
		return startZusMethod;
	}

	public void setStartZusMethod(SearchingMethod startZusMethod) {
		this.startZusMethod = startZusMethod;
	}

	public LocalDate getStartZus() {
		return startZus;
	}

	public void setStartZus(LocalDate startZus) {
		this.startZus = startZus;
	}

	public LocalDate getStartZusTo() {
		return startZusTo;
	}

	public void setStartZusTo(LocalDate startZusTo) {
		this.startZusTo = startZusTo;
	}

	public SearchingMethod getEndZusMethod() {
		return endZusMethod;
	}

	public void setEndZusMethod(SearchingMethod endZusMethod) {
		this.endZusMethod = endZusMethod;
	}

	public LocalDate getEndZus() {
		return endZus;
	}

	public void setEndZus(LocalDate endZus) {
		this.endZus = endZus;
	}

	public LocalDate getEndZusTo() {
		return endZusTo;
	}

	public void setEndZusTo(LocalDate endZusTo) {
		this.endZusTo = endZusTo;
	}

	public SearchingMethod getEndWorkMethod() {
		return endWorkMethod;
	}

	public void setEndWorkMethod(SearchingMethod endWorkMethod) {
		this.endWorkMethod = endWorkMethod;
	}

	public LocalDate getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}

	public LocalDate getEndWorkTo() {
		return endWorkTo;
	}

	public void setEndWorkTo(LocalDate endWorkTo) {
		this.endWorkTo = endWorkTo;
	}

	public SearchingMethod getStatementValidFromMethod() {
		return statementValidFromMethod;
	}

	public void setStatementValidFromMethod(SearchingMethod statementValidFromMethod) {
		this.statementValidFromMethod = statementValidFromMethod;
	}

	public LocalDate getStatementValidFromFrom() {
		return statementValidFromFrom;
	}

	public void setStatementValidFromFrom(LocalDate statementValidFromFrom) {
		this.statementValidFromFrom = statementValidFromFrom;
	}

	public LocalDate getStatementValidFromTo() {
		return statementValidFromTo;
	}

	public void setStatementValidFromTo(LocalDate statementValidFromTo) {
		this.statementValidFromTo = statementValidFromTo;
	}

	public SearchingMethod getStatementValidToMethod() {
		return statementValidToMethod;
	}

	public void setStatementValidToMethod(SearchingMethod statementValidToMethod) {
		this.statementValidToMethod = statementValidToMethod;
	}

	public LocalDate getStatementValidToFrom() {
		return statementValidToFrom;
	}

	public void setStatementValidToFrom(LocalDate statementValidToFrom) {
		this.statementValidToFrom = statementValidToFrom;
	}

	public LocalDate getStatementValidToTo() {
		return statementValidToTo;
	}

	public void setStatementValidToTo(LocalDate statementValidToTo) {
		this.statementValidToTo = statementValidToTo;
	}

	public SearchingMethod getPermitValidFromoMethod() {
		return permitValidFromoMethod;
	}

	public void setPermitValidFromoMethod(SearchingMethod permitValidFromoMethod) {
		this.permitValidFromoMethod = permitValidFromoMethod;
	}

	public LocalDate getPermitValidFromFrom() {
		return permitValidFromFrom;
	}

	public void setPermitValidFromFrom(LocalDate permitValidFromFrom) {
		this.permitValidFromFrom = permitValidFromFrom;
	}

	public LocalDate getPermitValidFromTo() {
		return permitValidFromTo;
	}

	public void setPermitValidFromTo(LocalDate permitValidFromTo) {
		this.permitValidFromTo = permitValidFromTo;
	}

	public SearchingMethod getPermitValidToMethod() {
		return permitValidToMethod;
	}

	public void setPermitValidToMethod(SearchingMethod permitValidToMethod) {
		this.permitValidToMethod = permitValidToMethod;
	}

	public LocalDate getPermitValidToFrom() {
		return permitValidToFrom;
	}

	public void setPermitValidToFrom(LocalDate permitValidToFrom) {
		this.permitValidToFrom = permitValidToFrom;
	}

	public LocalDate getPermitValidToTo() {
		return permitValidToTo;
	}

	public void setPermitValidToTo(LocalDate permitValidToTo) {
		this.permitValidToTo = permitValidToTo;
	}	
}
