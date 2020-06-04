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

import lombok.Data;

@Entity
@Data
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
}
