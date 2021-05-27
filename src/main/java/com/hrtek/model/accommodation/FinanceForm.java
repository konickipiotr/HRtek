package com.hrtek.model.accommodation;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceForm {
	private Long id;
	private BigDecimal rent;
	private BigDecimal deposit;
	private BigDecimal media;
	private BigDecimal perperson;
	private CostType costType;
	
	public FinanceForm() {
		this.rent = new BigDecimal("0");
		this.deposit = new BigDecimal("0");
		this.media = new BigDecimal("0");
		this.perperson = new BigDecimal("0");
	}

	public FinanceForm(Long id, BigDecimal rent, BigDecimal deposit, BigDecimal media, BigDecimal perperson, CostType costType) {
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

	public BigDecimal getRent() {
		return rent.setScale(2, RoundingMode.HALF_UP);
	}

	public void setRent(BigDecimal rent) {
		this.rent = rent.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getDeposit() {
		return deposit.setScale(2, RoundingMode.HALF_UP);
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getMedia() {
		return media.setScale(2, RoundingMode.HALF_UP);
	}

	public void setMedia(BigDecimal media) {
		this.media = media.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getPerperson() {
		return perperson.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPerperson(BigDecimal perperson) {
		this.perperson = perperson.setScale(2, RoundingMode.HALF_UP);
	}

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}
	
}
