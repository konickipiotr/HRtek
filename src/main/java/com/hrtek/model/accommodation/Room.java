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


@Entity
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHouseid() {
		return houseid;
	}

	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Bed> getBedlist() {
		return bedlist;
	}

	public void setBedlist(List<Bed> bedlist) {
		this.bedlist = bedlist;
	}

	public List<BedView> getBedViewList() {
		return bedViewList;
	}

	public void setBedViewList(List<BedView> bedViewList) {
		this.bedViewList = bedViewList;
	}
}
