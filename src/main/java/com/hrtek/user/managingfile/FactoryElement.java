package com.hrtek.user.managingfile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.hrtek.model.Factory;
import com.hrtek.user.timesheet.DateTimesheetOperation;

public class FactoryElement {
	
	private Long factoryid;
	private String factoryName;
	private List<WorkerRecord> records;
	private MonHeader monHeader;

	private int allinmonth;
	private int	sumOfChosenH;
	private int	sumOfSurplus;
	private BigDecimal sumOfSalaries;
	private BigDecimal sumOfCz1;
	private BigDecimal sumOfCz2;
	private BigDecimal sumOfFlatsCost;
	private BigDecimal sumOfLoans;
	private BigDecimal sumOfBonuses;
	private BigDecimal sumOfResults;

	public FactoryElement() {
	}
	
	public FactoryElement(Factory factory, int monOffset) {
		this.factoryid = factory.getId();
		this.factoryName = factory.getShortname();
		DateTimesheetOperation dts = new DateTimesheetOperation(monOffset);
		this.monHeader = new MonHeader(dts.getSelected());
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public List<WorkerRecord> getRecords() {
		return records;
	}

	public void setRecords(List<WorkerRecord> records) {
		this.records = records;
	}

	public MonHeader getMonHeader() {
		return monHeader;
	}

	public void setMonHeader(MonHeader monHeader) {
		this.monHeader = monHeader;
	}

	public Long getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}

	public int getAllinmonth() {
		return allinmonth;
	}

	public void setAllinmonth(int allinmonth) {
		this.allinmonth = allinmonth;
	}

	public int getSumOfChosenH() {
		return sumOfChosenH;
	}

	public void setSumOfChosenH(int sumOfChosenH) {
		this.sumOfChosenH = sumOfChosenH;
	}

	public int getSumOfSurplus() {
		return sumOfSurplus;
	}

	public void setSumOfSurplus(int sumOfSurplus) {
		this.sumOfSurplus = sumOfSurplus;
	}

	public BigDecimal getSumOfSalaries() {
		return sumOfSalaries;
	}

	public void setSumOfSalaries(BigDecimal sumOfSalaries) {
		this.sumOfSalaries = sumOfSalaries;
	}

	public BigDecimal getSumOfCz1() {
		return sumOfCz1;
	}

	public void setSumOfCz1(BigDecimal sumOfCz1) {
		this.sumOfCz1 = sumOfCz1;
	}

	public BigDecimal getSumOfCz2() {
		return sumOfCz2;
	}

	public void setSumOfCz2(BigDecimal sumOfCz2) {
		this.sumOfCz2 = sumOfCz2;
	}

	public BigDecimal getSumOfFlatsCost() {
		return sumOfFlatsCost;
	}

	public void setSumOfFlatsCost(BigDecimal sumOfFlatsCost) {
		this.sumOfFlatsCost = sumOfFlatsCost;
	}

	public BigDecimal getSumOfLoans() {
		return sumOfLoans;
	}

	public void setSumOfLoans(BigDecimal sumOfLoans) {
		this.sumOfLoans = sumOfLoans;
	}

	public BigDecimal getSumOfBonuses() {
		return sumOfBonuses;
	}

	public void setSumOfBonuses(BigDecimal sumOfBonuses) {
		this.sumOfBonuses = sumOfBonuses;
	}

	public BigDecimal getSumOfResults() {
		return sumOfResults;
	}

	public void setSumOfResults(BigDecimal sumOfResults) {
		this.sumOfResults = sumOfResults;
	}
}
