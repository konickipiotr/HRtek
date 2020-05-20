package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkerFinance {

	@Id
	private Long id;
	private double hourlyrate;
	private double bonus;
	
	public WorkerFinance(Long id, double hourlyrate) {
		this.id = id;
		this.hourlyrate = hourlyrate;
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
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "WorkerFinance [id=" + id + ", hourlyrate=" + hourlyrate + ", bonus=" + bonus + "]";
	}
}
