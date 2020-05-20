package com.hrtek.model.accommodation;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	public Room() {
	}
	
	public void addPerson() {
		this.occupied++;
	}
	
	public void removePerson() {
		this.occupied--;
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", houseid=" + houseid + ", roomname=" + roomname + ", capacity=" + capacity
				+ ", occupied=" + occupied + ", remark=" + remark + ", bedlist=" + bedlist + "]";
	}
	
}
