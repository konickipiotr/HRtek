package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class WorkerFinance {

	@Id
	private Long id;
	private double hourlyrate;
	private double wage;
	private double bonus;
	
	public WorkerFinance(Long id, double hourlyrate, double wage) {
		this.id = id;
		this.hourlyrate = hourlyrate;
		this.wage = wage;
	}
	
	public WorkerFinance() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(double hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
