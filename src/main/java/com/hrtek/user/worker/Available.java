package com.hrtek.user.worker;

import lombok.Data;

@Data
public class Available {
	
	private InUse worker;
	private InUse basic;
	private InUse date;
	private InUse residency;
	private InUse finance;
	private InUse permit;
	private InUse statement;
	private InUse contact;
	private InUse addresspl;
	private InUse address;
}
