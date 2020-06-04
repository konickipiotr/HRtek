package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
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
}
