package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MyNote {

	@Id
	private Long id;
	@Lob
	private String text;
	
	public MyNote(Long id) {
		this.id = id;
	}

	public MyNote() {
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
