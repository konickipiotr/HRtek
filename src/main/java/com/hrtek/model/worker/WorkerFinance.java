package com.hrtek.model.worker;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Entity
public class WorkerFinance {

	@Id
	private Long id;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal hourlyrate;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal wage;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal bonus;
	
	public WorkerFinance(Long id, BigDecimal hourlyrate, BigDecimal wage) {
		this.id = id;
		this.hourlyrate = hourlyrate;
		this.wage = wage;
		this.bonus = new BigDecimal("0");
	}
	
	public WorkerFinance() {
		this.bonus = new BigDecimal("0");
		this.wage = new BigDecimal("0");
		this.hourlyrate = new BigDecimal("0");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getHourlyrate() {
		return hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public void setHourlyrate(BigDecimal hourlyrate) {
		this.hourlyrate = hourlyrate.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getWage() {
		return wage.setScale(2, RoundingMode.HALF_UP);
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage.setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getBonus() {
		return bonus.setScale(2, RoundingMode.HALF_UP);
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus.setScale(2, RoundingMode.HALF_UP);
	}
}
