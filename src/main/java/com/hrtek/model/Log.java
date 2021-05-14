package com.hrtek.model;

import java.time.LocalDateTime;
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


@Entity
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getTstamp() {
		return tstamp;
	}

	public void setTstamp(LocalDateTime tstamp) {
		this.tstamp = tstamp;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LogType getLogtype() {
		return logtype;
	}

	public void setLogtype(LogType logtype) {
		this.logtype = logtype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		Log.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		Log.field = field;
	}
}
