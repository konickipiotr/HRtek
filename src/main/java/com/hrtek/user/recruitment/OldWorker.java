package com.hrtek.user.recruitment;

import java.time.LocalDate;

import com.hrtek.user.dismissed.Dismissed;


public class OldWorker implements Comparable<OldWorker> {
	private Long id;
	private String name;
	private LocalDate endWork;
	
	public OldWorker() {
		
	}

	public OldWorker(Dismissed d) {
		this.id = d.getId();
		this.name = d.getLastname() + " " + d.getFirstname()+ " - " + d.getDateofbirth();
		this.endWork = d.getEndWork();
	}

	@Override
	public int compareTo(OldWorker o) {
		if(this.name.compareTo(o.name) == 0) {
			
			if(this.endWork.isBefore(o.getEndWork()))
				return 1;
			else
				return -1;
			
		}else if(this.name.compareTo(o.name) < 1){
			return -1;
		}else {
			return 1;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}	
}
