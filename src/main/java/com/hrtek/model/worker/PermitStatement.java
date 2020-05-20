package com.hrtek.model.worker;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.user.recruitment.WorkerAll;

import lombok.Data;

@Entity
@Data
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
}
