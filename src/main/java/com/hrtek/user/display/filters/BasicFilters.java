package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class BasicFilters {

	private boolean bytext;
	private boolean bydateofbirth;
	private boolean byStartWork;
	private boolean byStartZus;
	private boolean byEndZus;
	private boolean byEndWork;
	private String bysex;
	private String byCitizenship;
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
	
	public BasicFilters() {
		this.searchbyfield = SearchByField.FIRSTNAME;
		this.searchingMethod = SearchingMethod.EQUAL;
		this.dateofbirthMethod = SearchingMethod.EQUAL;
		this.startWorkMethod = SearchingMethod.EQUAL;
		this.startZusMethod = SearchingMethod.EQUAL;
		this.endWorkMethod = SearchingMethod.EQUAL;
		this.endZusMethod = SearchingMethod.EQUAL;
		this.bysex = "all";
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

	public String getBysex() {
		return bysex;
	}

	public void setBysex(String bysex) {
		this.bysex = bysex;
	}

	public String getByCitizenship() {
		return byCitizenship;
	}

	public void setByCitizenship(String byCitizenship) {
		this.byCitizenship = byCitizenship;
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
}
