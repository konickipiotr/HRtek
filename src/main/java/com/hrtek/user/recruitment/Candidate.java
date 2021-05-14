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
	private Long recruiter;
	private String note;
	
	public Candidate() {
	}

	public Candidate(String firstname, String lastname, String sex, @Email String email, String phone,
			Long recruiter, String note) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.recruiter = recruiter;
		this.note = note;
	}

	public String getName() {
		return  lastname + " " + firstname;
	}

	@Override
	public String toString() {
		return "[firstname=" + firstname + ", lastname=" + lastname + ", sex=" + sex + ", email=" + email
				+ ", phone=" + phone + ", recruiter=" + recruiter + "]";
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

	public Long getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Long recruiter) {
		this.recruiter = recruiter;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	
}
