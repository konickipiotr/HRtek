package com.hrtek.model.accommodation;

import lombok.Data;

@Data
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

}
