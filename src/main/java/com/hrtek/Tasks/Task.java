package com.hrtek.Tasks;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	private Long employeeid;
	private String taskname;
	@Enumerated(EnumType.STRING)
	private TaskOwner owner;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	@Enumerated(EnumType.STRING)
	private TaskPriority priority;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate deadlinedate;
	@Lob
	private String description;	
	
	@Transient
	private String employeename;
	@Transient
	private String deadline;
	
	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public TaskOwner getOwner() {
		return owner;
	}

	public void setOwner(TaskOwner owner) {
		this.owner = owner;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public LocalDate getDeadlinedate() {
		return deadlinedate;
	}

	public void setDeadlinedate(LocalDate deadlinedate) {
		this.deadlinedate = deadlinedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}
