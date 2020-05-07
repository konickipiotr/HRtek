package com.hrtek.admin.employee;

import com.hrtek.model.UserInfo;

public class EmployeeView {
	
	private Long id;
	private String login;
	private String firstname;
	private String lastname;
	private String position;
	private String email;
	private String phone;
	private String sex;
	
	public EmployeeView() {
	}

	public EmployeeView(UserInfo e) {
		this.id = e.getId();
		this.firstname = e.getFirstname();
		this.lastname = e.getLastname();
		this.email = e.getEmail();
		this.phone = e.getPhone();
		if(e.getSex() == 0)
			this.sex = "F";
		else
			this.sex = "M";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "EmployeeView [id=" + id + ", login=" + login + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", position=" + position + ", email=" + email + ", phone=" + phone + ", sex=" + sex + "]";
	}
}
