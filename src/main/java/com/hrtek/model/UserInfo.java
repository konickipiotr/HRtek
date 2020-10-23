package com.hrtek.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.hrtek.admin.employee.NewEmployeeModel;

import lombok.Data;

@Entity
@Data
public class UserInfo {
	
	@Id
	private Long id;
	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;
	private int position;
	@Email
	private String email;
	private String phone;
	private int sex;
	
	public UserInfo() {
	}

	public UserInfo(Long id, @NotBlank String firstname, @NotBlank String lastname, int position,
			@Email String email, String phone, int sex) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
	}
	
	public void update(UserInfo n) {
		this.firstname = n.getFirstname();
		this.lastname = n.getLastname();
		this.position = n.getPosition();
		this.email = n.getEmail();
		this.phone = n.getPhone();
	}
	
	public UserInfo(NewEmployeeModel n, User u) {
		this.id = u.getId();
		this.firstname = n.getFirstname();
		this.lastname = n.getLastname();
		this.position = n.getPosition();
		this.email = n.getEmail();
		this.phone = n.getPhone();
		this.sex = n.getSex().equals("F") ? 0 : 1;
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}

	@Override
	public String toString() {
		return "[firstname=" + firstname + ", lastname=" + lastname + ", position=" + position
				+ ", email=" + email + ", phone=" + phone + ", sex=" + sex + "]";
	}
	
	
}
