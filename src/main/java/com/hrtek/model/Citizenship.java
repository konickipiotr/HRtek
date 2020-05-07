package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Citizenship {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	public Citizenship() {
	}

	public Citizenship(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Citizenship [id=" + id + ", name=" + name + "]";
	}	
}
