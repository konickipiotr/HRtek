package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.hrtek.admin.employee.NewEmployeeModel;

@Entity
public class UserInfo {
	
	@Id
	private Long id;
	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;
	private String imgphoto;
	private int position;
	@Email
	private String email;
	private String phone;
	private int sex;
	
	public UserInfo() {
	}

	public UserInfo(Long id, @NotBlank String firstname, @NotBlank String lastname, String imgphoto, int position,
			@Email String email, String phone, int sex) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.imgphoto = imgphoto;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
	}
	
	public void update(UserInfo n) {
		this.firstname = n.getFirstname();
		this.lastname = n.getLastname();
		this.imgphoto = "";
		this.position = n.getPosition();
		this.email = n.getEmail();
		this.phone = n.getPhone();
	}
	
	public UserInfo(NewEmployeeModel n, User u) {
		this.id = u.getId();
		this.firstname = n.getFirstname();
		this.lastname = n.getLastname();
		this.imgphoto = "";
		this.position = n.getPosition();
		this.email = n.getEmail();
		this.phone = n.getPhone();
		this.sex = n.getSex().equals("F") ? 0 : 1;
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", imgphoto="
				+ imgphoto + ", position=" + position + ", email=" + email + ", phone=" + phone + ", sex=" + sex + "]";
	}
}
