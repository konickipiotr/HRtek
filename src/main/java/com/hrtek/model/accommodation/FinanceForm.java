package com.hrtek.model.accommodation;

public class FinanceForm {
	private Long id;
	private double rent;
	private double deposit;
	private double media;
	private double perperson;
	private String typecost;
	
	public FinanceForm() {
	}

	public FinanceForm(Long id, double rent, double deposit, double media, double perperson, String typecost) {
		this.id = id;
		this.rent = rent;
		this.deposit = deposit;
		this.media = media;
		this.perperson = perperson;
		this.typecost = typecost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getPerperson() {
		return perperson;
	}

	public void setPerperson(double perperson) {
		this.perperson = perperson;
	}

	public String getTypecost() {
		return typecost;
	}

	public void setTypecost(String typecost) {
		this.typecost = typecost;
	}

	@Override
	public String toString() {
		return "FinanceForm [id=" + id + ", rent=" + rent + ", deposit=" + deposit + ", media=" + media + ", perperson="
				+ perperson + ", typecost=" + typecost + "]";
	}	
}
