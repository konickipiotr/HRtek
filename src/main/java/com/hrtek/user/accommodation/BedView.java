package com.hrtek.user.accommodation;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.accommodation.Bed;

public class BedView {

	private Long id;
	private Long roomid;
	private Long houseid;
	private Long workerid;
	private String workername;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate occupyFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate expire;
	@Enumerated(EnumType.STRING)
	private Bedstatus bedstatus;
	
	public BedView(Bed b) {
		this.id = b.getId();
		this.roomid = b.getRoomid();
		this.workerid = b.getWorkerid();
		this.expire = b.getExpire();
		this.houseid = b.getHouseid();
		this.bedstatus = b.getBedstatus();
		this.occupyFrom = b.getOccupyFrom();
	}

	public BedView() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public Long getWorkerid() {
		return workerid;
	}

	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public LocalDate getOccupyFrom() {
		return occupyFrom;
	}

	public void setOccupyFrom(LocalDate occupyFrom) {
		this.occupyFrom = occupyFrom;
	}

	public LocalDate getExpire() {
		return expire;
	}

	public void setExpire(LocalDate expire) {
		this.expire = expire;
	}

	public Bedstatus getBedstatus() {
		return bedstatus;
	}

	public void setBedstatus(Bedstatus bedstatus) {
		this.bedstatus = bedstatus;
	}
}
