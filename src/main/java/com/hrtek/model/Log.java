package com.hrtek.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "date", columnDefinition="TIMESTAMP")
	private Timestamp date;
	private String who;
	@Lob
	private String message;
	
	public Log() {
		this.date = new Timestamp(System.currentTimeMillis());
	}
	
	public Log(String who, String message) {
		this.date = new Timestamp(System.currentTimeMillis());
		this.who = who;
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
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
	@Override
	public String toString() {
		return "Log [id=" + id + ", date=" + date.toString() + ", who=" + who + ", message=" + message + "]";
	}
}
