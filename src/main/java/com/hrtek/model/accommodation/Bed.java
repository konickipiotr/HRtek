package com.hrtek.model.accommodation;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.accommodation.Bedstatus;

@Entity
public class Bed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long roomid;
	private Long houseid;
	private Long workerid;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate occupyFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate expire;
	@Enumerated(EnumType.STRING)
	private Bedstatus bedstatus;
	
	public Bed() {
	}

	public Bed(Long roomid, Long houseid, Long workerid, LocalDate expire, Bedstatus bedStatus) {
		this.roomid = roomid;
		this.houseid = houseid;
		this.workerid = workerid;
		this.expire = expire;
		this.bedstatus = bedStatus;
	}
	
	public void setFree() {
		this.workerid = null;
		this.expire = null;
		this.bedstatus = Bedstatus.FREE;
	}
	
	public void setOccupied(Long id, LocalDate expire) {
		this.workerid = id;
		this.expire = expire;
		this.bedstatus = Bedstatus.OCCUPIED;
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
