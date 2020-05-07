package com.hrtek.admin.employee;

public class NewEmployeeModel {

	private String username;
	private String password;
	private String password2;
	private String roles;
	private int status;
	private String firstname;
	private String lastname;
	private String imgphoto;
	private int position;
	private String email;
	private String phone;
	private String sex;
	
	public NewEmployeeModel() {
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getImgphoto() {
		return imgphoto;
	}

	public void setImgphoto(String imgphoto) {
		this.imgphoto = imgphoto;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
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
		return "NewEmployeeModel [username=" + username + ", password=" + password + ", password2=" + password2
				+ ", roles=" + roles + ", status=" + status + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", imgphoto=" + imgphoto + ", position=" + position + ", email=" + email + ", phone=" + phone
				+ ", sex=" + sex + "]";
	}
}
