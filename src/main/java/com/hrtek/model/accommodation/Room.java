package com.hrtek.model.accommodation;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.hrtek.user.accommodation.BedView;

import lombok.Data;

@Entity
@Data
public class Room {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long houseid;
	private String roomname;
	private int capacity;
	private int occupied;
	@Column(columnDefinition = "text")
	private String remark;
	
	@OneToMany
	@JoinColumn(name = "roomid")
	private List<Bed> bedlist;
	
	@Transient
	private List<BedView> bedViewList;

	public Room() {
		this.occupied = 0;
	}
	
	public void addPerson() {
		this.occupied++;
	}
	
	public void removePerson() {
		this.occupied--;
	}	
	
	public void addBed() {
		this.capacity++;
	}
	
	public void removeBed() {
		this.capacity--;
	}
}
