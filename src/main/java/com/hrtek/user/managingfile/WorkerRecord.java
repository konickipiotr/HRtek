package com.hrtek.user.managingfile;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.hrtek.model.worker.Worker;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.display.views.ResidencyView;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class WorkerRecord implements Comparable<WorkerRecord>{

	private Long id;
	private String name;
	private String dateofbirth;
	private String age;
	private String pesel;
	private boolean belove26;
	
	private String startZus;
	private String startZusStyle;
	private String endZus;
	private String endZusStyle;

	private String documentType;
	private String validTo;
	private BigDecimal cz1;
	private BigDecimal cz2;
	private BigDecimal loan;
	private BigDecimal bonus;
	private BigDecimal result;
	
	private List<String> hourlList = new ArrayList<>();
	private int sumOfHours;
	private int chosenHours;
	private int superplus;
	private String salaryForm;
	private BigDecimal salary;
	private BigDecimal flatcost;



	
	public WorkerRecord(Worker worker) {
		this.id = worker.getId();
		this.name = worker.getRevName();
		this.startZusStyle = "#edf0f5";
		this.endZusStyle = "#edf0f5";
	}

	public void setStartZus(String startZus) {
		if(startZus.equals("IN PROGRESS"))
			this.setStartZusStyle("#a30a0a");
		this.startZus = startZus;
	}

	public void setStartZus(LocalDate startZus) {
		if(startZus == null) {
			this.startZus = "";
			return;
		}
		LocalDate now = LocalDate.now();

		if(now.getMonthValue() == startZus.getMonthValue()){
			this.setStartZusStyle(GlobalSettings.lightGreenCellColor);
		}
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		this.startZus = sf.format(Date.valueOf(startZus));
	}

	public void setEndZus(String endZus) {
		if(endZus.equals("IN PROGRESS"))
			this.setEndZusStyle("#a30a0a");

		this.endZus = endZus;
	}

	public void setEndZus(LocalDate endZus) {
		if(endZus == null) {
			this.endZus = "CURRENTLY";
			return;
		}

		LocalDate now = LocalDate.now();

		if(now.getMonthValue() == endZus.getMonthValue()){
			this.setEndZusStyle(GlobalSettings.lightRedCellColor);
		}
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		this.endZus = sf.format(Date.valueOf(endZus));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public boolean isBelove26() {
		return belove26;
	}

	public void setBelove26(boolean belove26) {
		this.belove26 = belove26;
	}

	public String getStartZus() {
		return startZus;
	}

	public String getStartZusStyle() {
		return startZusStyle;
	}

	public void setStartZusStyle(String startZusStyle) {
		this.startZusStyle = startZusStyle;
	}

	public String getEndZus() {
		return endZus;
	}

	public String getEndZusStyle() {
		return endZusStyle;
	}

	public void setEndZusStyle(String endZusStyle) {
		this.endZusStyle = endZusStyle;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public BigDecimal getCz2() {
		return cz2;
	}

	public void setCz2(BigDecimal cz2) {
		this.cz2 = cz2;
	}

	public BigDecimal getLoan() {
		return loan;
	}

	public void setLoan(BigDecimal loan) {
		this.loan = loan;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public List<String> getHourlList() {
		return hourlList;
	}

	public void setHourlList(List<String> hourlList) {
		this.hourlList = hourlList;
	}

	public int getSumOfHours() {
		return sumOfHours;
	}

	public void setSumOfHours(int sumOfHours) {
		this.sumOfHours = sumOfHours;
	}

	public int getChosenHours() {
		return chosenHours;
	}

	public void setChosenHours(int chosenHours) {
		this.chosenHours = chosenHours;
	}

	public int getSuperplus() {
		return superplus;
	}

	public void setSuperplus(int superplus) {
		this.superplus = superplus;
	}

	public String getSalaryForm() {
		return salaryForm;
	}

	public void setSalaryForm(String salaryForm) {
		this.salaryForm = salaryForm;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getFlatcost() {
		return flatcost;
	}

	public void setFlatcost(BigDecimal flatcost) {
		this.flatcost = flatcost;
	}

	public BigDecimal getCz1() {
		return cz1;
	}

	public void setCz1(BigDecimal cz1) {
		this.cz1 = cz1;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		WorkerRecord.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		WorkerRecord.field = field;
	}

	private int countSumOfX(){
		return (int)this.hourlList.stream().filter(i -> i.equals("XX")).count();
	}

	public static boolean isup = false;
	public static ViewFields field = ViewFields.NAME;


	@Override
	public int compareTo(WorkerRecord o) {
		switch (field) {
			case NAME: return FieldsComparator.compareText(this.name, o.getName(), isup);
			case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
			case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);

			case AGE: return FieldsComparator.compareNumber(this.age, o.getAge(), isup);
			case STARTZUS: return FieldsComparator.compareDate(this.startZus, o.getStartZus(), isup);
			case ENDZUS: return FieldsComparator.compareDate(this.endZus, o.getEndZus(), isup);

			case DOCTYPE: return FieldsComparator.compareText(this.documentType, o.getDocumentType(), isup);

			case VALIDTO: return FieldsComparator.compareDate(this.validTo, o.getValidTo(), isup);
			case FULLINMON: return FieldsComparator.compareNumber(this.sumOfHours, o.getSumOfHours(), isup);
			case SUPERPLUS: return FieldsComparator.compareNumber(this.superplus, o.getSuperplus(), isup);
			case SALARY: return isup ? this.salary.compareTo(o.getSalary()) : -this.salary.compareTo(o.getSalary());
			case STARTWORKTIMESHEET: return FieldsComparator.compareNumber(o.countSumOfX(), this.countSumOfX(), isup);
			case BELLOW26: return this.belove26 ? 1 : 0;

			default:
				break;
		}
		return 0;
	}
}
