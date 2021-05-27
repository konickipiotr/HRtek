package com.hrtek.user.managingfile;

import java.math.BigDecimal;

public class WorkVal {

    private Long workerid;
    private int chosenHours;
    private String salaryform;
    private BigDecimal loan;
    private BigDecimal bonus;
    private BigDecimal salary;


    public WorkVal() {
    }

    public WorkVal(Long workerid, int chosenHours, String salaryform, BigDecimal loan, BigDecimal bonus, BigDecimal salary) {
        this.workerid = workerid;
        this.chosenHours = chosenHours;
        this.salaryform = salaryform;
        this.loan = loan;
        this.bonus = bonus;
        this.salary = salary;
    }

    public Long getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Long workerid) {
        this.workerid = workerid;
    }

    public int getChosenHours() {
        return chosenHours;
    }

    public void setChosenHours(int chosenHours) {
        this.chosenHours = chosenHours;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
