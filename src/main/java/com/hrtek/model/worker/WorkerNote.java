package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class WorkerNote {

	@Id
	private Long id;
	@Lob
	private String text;
	
	
	public WorkerNote() {
	}

	public WorkerNote(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
