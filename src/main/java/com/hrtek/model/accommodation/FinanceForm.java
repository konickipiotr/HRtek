package com.hrtek.model.accommodation;


public class FinanceForm {
	private Long id;
	private double rent;
	private double deposit;
	private double media;
	private double perperson;
	private CostType costType;
	
	public FinanceForm() {
	}

	public FinanceForm(Long id, double rent, double deposit, double media, double perperson, CostType costType) {
		this.id = id;
		this.rent = rent;
		this.deposit = deposit;
		this.media = media;
		this.perperson = perperson;
		this.costType = costType;
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

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}
	
}
