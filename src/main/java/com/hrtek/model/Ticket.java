package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hrtek.admin.tickets.TicketType;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TicketType event;
	private String login;
	private Long userId;
	private String remarks;
	
	public Ticket() {
	}

	public Ticket(TicketType event, String login, Long userId, String remarks) {
		this.event = event;
		this.login = login;
		this.userId = userId;
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketType getEvent() {
		return event;
	}

	public void setEvent(TicketType event) {
		this.event = event;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", event=" + event + ", login=" + login + ", userId=" + userId + ", remarks="
				+ remarks + "]";
	}
}
