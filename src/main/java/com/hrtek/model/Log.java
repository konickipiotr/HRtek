package com.hrtek.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.enums.LogType;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import lombok.Data;

@Entity
@Data
public class Log implements Comparable<Log>{
	
	@Id
	@GeneratedValue
	private long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime tstamp;
	private String who;
	@Lob
	private String message;
	private LogType logtype;
	@Transient
	private String date;
	@Transient
	private String time;
	
	public Log() {
		LocalDateTime dd = LocalDateTime.now(GlobalSettings.zid);
		dd.truncatedTo(ChronoUnit.MINUTES);
		this.tstamp = dd;
	}
	
	public Log(String who, String message, LogType logtype) {
		this.tstamp = LocalDateTime.now(GlobalSettings.zid);
		this.who = who;
		this.message = message;
		this.logtype = logtype;
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.TIMESTAMP;

	@Override
	public int compareTo(Log o) {
		switch (field) {
		case TIMESTAMP: return FieldsComparator.compareDateTime(this.tstamp, o.getTstamp(), isup);
		case WHO: return FieldsComparator.compareText(this.who, o.getWho(), isup);
		case LOGTYPE: return FieldsComparator.compareText(this.logtype.toString(), o.getLogtype().toString(), isup);
		default:
			break;
		}
		return 0;
	}
	
	public void covert() {
		this.date = this.tstamp.toLocalDate().toString();
		this.time = this.tstamp.toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString();
	}
	
	

}
