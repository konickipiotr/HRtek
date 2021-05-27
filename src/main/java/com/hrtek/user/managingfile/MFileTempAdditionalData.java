package com.hrtek.user.managingfile;

import com.hrtek.settings.GlobalSettings;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
public class MFileTempAdditionalData {

    @Id
    @GeneratedValue
    private Long id;
    private int year;
    private int month;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creationdate;

    private Long workerid;
    private int hours;
    private BigDecimal salary;
    private String salaryform;

    private BigDecimal loan;
    private BigDecimal bonus;

    public MFileTempAdditionalData() {
    }

    public MFileTempAdditionalData(int year, int month, Long workerid, int hours, BigDecimal salary, String salaryform, BigDecimal loan, BigDecimal bonus) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.creationdate = LocalDate.now(GlobalSettings.zid);
        this.workerid = workerid;
        this.hours = hours;
        this.salary = salary;
        this.salaryform = salaryform;
        this.loan = loan;
        this.bonus = bonus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    public Long getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Long workerid) {
        this.workerid = workerid;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSalaryform() {
        return salaryform;
    }

    public void setSalaryform(String salaryform) {
        this.salaryform = salaryform;
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
}
