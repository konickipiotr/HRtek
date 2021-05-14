package com.hrtek.admin.log;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.display.filters.SearchingMethod;


public class LogFilter {
	
	private boolean byTimestamp;
	private boolean bytext;
	private String byType;
	private String byPerson;
	
	private String texttosearch;
	
	private SearchingMethod timestampMethod;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime timestamp;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime timestampTo;
	
	public LogFilter() {
		this.timestampMethod = SearchingMethod.EQUAL;
		this.byType = "ALL";
	}

	public boolean isByTimestamp() {
		return byTimestamp;
	}

	public void setByTimestamp(boolean byTimestamp) {
		this.byTimestamp = byTimestamp;
	}

	public boolean isBytext() {
		return bytext;
	}

	public void setBytext(boolean bytext) {
		this.bytext = bytext;
	}

	public String getByType() {
		return byType;
	}

	public void setByType(String byType) {
		this.byType = byType;
	}

	public String getByPerson() {
		return byPerson;
	}

	public void setByPerson(String byPerson) {
		this.byPerson = byPerson;
	}

	public String getTexttosearch() {
		return texttosearch;
	}

	public void setTexttosearch(String texttosearch) {
		this.texttosearch = texttosearch;
	}

	public SearchingMethod getTimestampMethod() {
		return timestampMethod;
	}

	public void setTimestampMethod(SearchingMethod timestampMethod) {
		this.timestampMethod = timestampMethod;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDateTime getTimestampTo() {
		return timestampTo;
	}

	public void setTimestampTo(LocalDateTime timestampTo) {
		this.timestampTo = timestampTo;
	}
}
