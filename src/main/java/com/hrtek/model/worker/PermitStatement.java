package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.WorkerAll;


@Entity
public class PermitStatement {
	
	@Id
	private Long id;
	
	private String statementType;
	private String statement;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate statementValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate statementValidTo;
	
	private String permit;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate permitValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate permitValidTo;
	private String other;	
	
	public void update(WorkerAll w) {
		this.statementType = w.getStatementType();
		this.statement = w.getStatement();
		this.statementValidFrom = w.getStatementValidFrom();
		this.statementValidTo = w.getStatementValidTo();
		
		this.permit = w.getPermit();
		this.other = w.getOther();
		this.permitValidFrom = w.getPermitValidFrom();
		this.permitValidTo = w.getPermitValidTo();
	}
	
	public void updateStatement(WorkerAll w) {
		this.statementType = w.getStatementType();
		this.statement = w.getStatement();
		this.statementValidFrom = w.getStatementValidFrom();
		this.statementValidTo = w.getStatementValidTo();
	}
	
	public void updatePermit(WorkerAll w) {		
		this.permit = w.getPermit();
		this.other = w.getOther();
		this.permitValidFrom = w.getPermitValidFrom();
		this.permitValidTo = w.getPermitValidTo();
	}
	
	
	public PermitStatement() {

	}
	
	public PermitStatement(Worker w) {
		this.id = w.getId();
	}

	public PermitStatement(Worker worker, WorkerAll wall) {
		this.id = worker.getId();
		this.statementType = wall.getStatementType();
		this.statement = wall.getStatement();
		this.statementValidFrom = wall.getStatementValidFrom();
		this.statementValidTo = wall.getStatementValidTo();
		this.permit = wall.getPermit();
		this.permitValidFrom = wall.getPermitValidFrom();
		this.permitValidTo = wall.getPermitValidTo();
		this.other = wall.getOther();
	}

	@Override
	public String toString() {
		return " [statementType=" + statementType + ", statement=" + statement + ", statementValidFrom="
				+ statementValidFrom + ", statementValidTo=" + statementValidTo + ", permit=" + permit
				+ ", permitValidFrom=" + permitValidFrom + ", permitValidTo=" + permitValidTo + ", other=" + other
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatementType() {
		return statementType;
	}

	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public LocalDate getStatementValidFrom() {
		return statementValidFrom;
	}

	public void setStatementValidFrom(LocalDate statementValidFrom) {
		this.statementValidFrom = statementValidFrom;
	}

	public LocalDate getStatementValidTo() {
		return statementValidTo;
	}

	public void setStatementValidTo(LocalDate statementValidTo) {
		this.statementValidTo = statementValidTo;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public LocalDate getPermitValidFrom() {
		return permitValidFrom;
	}

	public void setPermitValidFrom(LocalDate permitValidFrom) {
		this.permitValidFrom = permitValidFrom;
	}

	public LocalDate getPermitValidTo() {
		return permitValidTo;
	}

	public void setPermitValidTo(LocalDate permitValidTo) {
		this.permitValidTo = permitValidTo;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}	
}
