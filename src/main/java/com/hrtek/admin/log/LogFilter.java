package com.hrtek.admin.log;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.display.filters.SearchingMethod;

import lombok.Data;

@Data
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

}
