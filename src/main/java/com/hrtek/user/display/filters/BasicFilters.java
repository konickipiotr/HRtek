package com.hrtek.user.display.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.StatusWorker;

import lombok.Data;

@Data
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


}
