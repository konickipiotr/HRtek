package com.hrtek.model;

public class ListModel {

	private Long id;
	private String value;
	
	public ListModel() {
	}

	public ListModel(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ListModel [id=" + id + ", value=" + value + "]";
	}
}
