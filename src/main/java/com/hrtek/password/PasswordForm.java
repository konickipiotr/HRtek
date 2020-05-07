package com.hrtek.password;

public class PasswordForm {

	private String oldpassword;
	private String newpassword1;
	private String newpassword2;
	
	public PasswordForm() {
	}

	public PasswordForm(String oldpassword, String newpassword1, String newpassword2) {
		this.oldpassword = oldpassword;
		this.newpassword1 = newpassword1;
		this.newpassword2 = newpassword2;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword1() {
		return newpassword1;
	}

	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}

	public String getNewpassword2() {
		return newpassword2;
	}

	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}

	@Override
	public String toString() {
		return "PasswordForm [oldpassword=" + oldpassword + ", newpassword1=" + newpassword1 + ", newpassword2="
				+ newpassword2 + "]";
	}
}
