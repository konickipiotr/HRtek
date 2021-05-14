package com.hrtek.user.worker;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InUse {

	@Id
	@GeneratedValue
	private Long id;
	private Long workerid;
	private Long userid;
	@Enumerated(EnumType.STRING)
	private UsedTable usedTable;
	//@Column(name = "expired", columnDefinition="TIMESTAMP")
	private LocalDateTime expired;
	private String username;
	
	public InUse(Long workerid, Long userid, UsedTable usedTable, LocalDateTime expired, String username) {
		this.workerid = workerid;
		this.userid = userid;
		this.usedTable = usedTable;
		this.expired = expired;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWorkerid() {
		return workerid;
	}

	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public UsedTable getUsedTable() {
		return usedTable;
	}

	public void setUsedTable(UsedTable usedTable) {
		this.usedTable = usedTable;
	}

	public LocalDateTime getExpired() {
		return expired;
	}

	public void setExpired(LocalDateTime expired) {
		this.expired = expired;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
}
