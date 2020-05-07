package com.hrtek.model.accommodation;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hrtek.user.accommodation.Bedstatus;
import com.hrtek.utils.DateUtils;

@Entity
public class Bed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long roomid;
	private Long houseid;
	private Long workerid;
	private Date expire;
	@Enumerated(EnumType.STRING)
	private Bedstatus bedstatus;
	
	public Bed() {
	}

	public Bed(Long roomid, Long houseid, Long workerid, Date expire, Bedstatus bedStatus) {
		this.roomid = roomid;
		this.houseid = houseid;
		this.workerid = workerid;
		this.expire = expire;
		this.bedstatus = bedStatus;
	}
	
	public void setFree() {
		this.workerid = 0l;
		this.expire = null;
		this.bedstatus = Bedstatus.FREE;
	}
	
	public void setOccupied(Long id, String expire) {
		this.workerid = id;
		this.expire = DateUtils.convertDate(expire);
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

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public Bedstatus getBedstatus() {
		return bedstatus;
	}

	public void setBedstatus(Bedstatus bedStatus) {
		this.bedstatus = bedStatus;
	}

	@Override
	public String toString() {
		return "BedModel [id=" + id + ", roomid=" + roomid + ", houseid=" + houseid + ", workerid=" + workerid
				+ ", expire=" + expire + ", bedstatus=" + bedstatus + "]";
	}
}
