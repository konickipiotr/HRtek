package com.hrtek.user.recruitment;

public class CandidateView {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String sex;
	private String email;
	private String phone;
	private String recruiter;
	private String note;
	
	public CandidateView() {
	}
	
	public CandidateView(Long id, String firstname, String lastname, String sex, String email, String phone,
			String recruiter, String note) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.recruiter = recruiter;
		this.note = note;
	}

	public CandidateView(Candidate c) {
		this.id = c.getId();
		this.firstname = c.getFirstname();
		this.lastname = c.getLastname();
		this.sex = c.getSex();
		this.email = c.getEmail();
		this.phone = c.getPhone();
		this.note = c.getNote();
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

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "CandidateView [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", sex=" + sex
				+ ", email=" + email + ", phone=" + phone + ", recruiter=" + recruiter + ", note=" + note + "]";
	}
}
