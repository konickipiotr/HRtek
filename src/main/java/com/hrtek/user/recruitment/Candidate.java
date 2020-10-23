package com.hrtek.user.recruitment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
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
	
	
}
