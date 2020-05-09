package com.hrtek.model.accommodation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class House {
	
	@Id
	@GeneratedValue
	private Long id;
	private int capacity;
	private int noofrooms;
	private int occupied;
	private Long liderid;
	private String lidername;
	private double liderbonus;
	private double rent;
	private double deposit;
	private double media;
	private double perperson;
	private String typecost;
	private String address;
	private String postcode;
	private String city;
	@Lob
	private String remark;
	private int periodofnotice;
	
	public House() {
	}
	
	public void changeAddress(AddressForm af) {
		this.address = af.getAddress();
		this.postcode = af.getPostcode();
		this.city = af.getCity();
	}
	
	public void changeFinance(FinanceForm ff) {
		this.rent = ff.getRent();
		this.media = ff.getMedia();
		this.deposit = ff.getDeposit();
		this.perperson = ff.getPerperson();
		this.typecost = ff.getTypecost();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public Long getLiderid() {
		return liderid;
	}

	public void setLiderid(Long liderid) {
		this.liderid = liderid;
	}

	public String getLidername() {
		return lidername;
	}

	public void setLidername(String lidername) {
		this.lidername = lidername;
	}

	public double getLiderbonus() {
		return liderbonus;
	}

	public void setLiderbonus(double liderbonus) {
		this.liderbonus = liderbonus;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getPerperson() {
		return perperson;
	}

	public void setPerperson(double perperson) {
		this.perperson = perperson;
	}

	public String getTypecost() {
		return typecost;
	}

	public void setTypecost(String typecost) {
		this.typecost = typecost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getPeriodofnotice() {
		return periodofnotice;
	}

	public void setPeriodofnotice(int periodofnotice) {
		this.periodofnotice = periodofnotice;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", capacity=" + capacity + ", noofrooms=" + noofrooms + ", occupied=" + occupied
				+ ", liderid=" + liderid + ", lidername=" + lidername + ", liderbonus=" + liderbonus + ", rent=" + rent
				+ ", deposit=" + deposit + ", media=" + media + ", perperson=" + perperson + ", typecost=" + typecost
				+ ", address=" + address + ", postcode=" + postcode + ", city=" + city + ", remark=" + remark
				+ ", periodofnotice=" + periodofnotice + "]\n";
	}
	
	

}
