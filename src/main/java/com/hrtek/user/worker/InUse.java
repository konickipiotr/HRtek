package com.hrtek.user.worker;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class InUse {

	@Id
	@GeneratedValue
	private Long id;
	private Long workerid;
	private Long userid;
	@Enumerated(EnumType.STRING)
	private UsedTable usedTable;
	@Column(name = "expired", columnDefinition="TIMESTAMP")
	private Timestamp expired;
	private String username;
	
	public InUse(Long workerid, Long userid, UsedTable usedTable, Timestamp expired, String username) {
		this.workerid = workerid;
		this.userid = userid;
		this.usedTable = usedTable;
		this.expired = expired;
		this.username = username;
	}
	
	
}
