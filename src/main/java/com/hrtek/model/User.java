package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hrtek.admin.employee.NewEmployeeModel;
import com.hrtek.enums.UserStatus;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String roles;
	@Enumerated(EnumType.ORDINAL)
	private UserStatus status;
	
	public User() {
	}

	public User(String username, String password, String roles, UserStatus status) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.status = status;
	}

	public User(NewEmployeeModel n) {
		this.username = n.getUsername();
		this.password = n.getPassword();
		this.roles = "USER";
		this.status = UserStatus.FIRSTLOGIN;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + ", status="
				+ status + "]";
	}	
}
