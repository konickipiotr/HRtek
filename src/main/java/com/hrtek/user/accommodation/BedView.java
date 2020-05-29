package com.hrtek.user.accommodation;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.accommodation.Bed;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BedView {

	private Long id;
	private Long roomid;
	private Long houseid;
	private Long workerid;
	private String workername;
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
	}
	
}
