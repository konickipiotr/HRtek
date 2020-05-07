package com.hrtek.user.recruitment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Candidate {

	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	private String sex;
	@Email
	private String email;
	private String phone;
	private Long recruterid;
	private String note;
	
	public Candidate() {
	}

	public Candidate(String firstname, String lastname, String sex, @Email String email, String phone,
			Long recruterid, String note) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.recruterid = recruterid;
		this.note = note;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Long getRecruterid() {
		return recruterid;
	}

	public void setRecruterid(Long recruterid) {
		this.recruterid = recruterid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", sex=" + sex
				+ ", email=" + email + ", phone=" + phone + ", recruterid=" + recruterid + ", note=" + note + "]";
	}	
}
