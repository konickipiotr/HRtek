package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPostions {
	
	@Id
	@GeneratedValue
	public Integer id;
	public String position;
	
	public UserPostions() {
	}

	public UserPostions(String position) {
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "UserPostions [id=" + id + ", position=" + position + "]";
	}
}
