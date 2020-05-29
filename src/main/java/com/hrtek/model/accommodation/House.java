package com.hrtek.model.accommodation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
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
	private CostType costType;
	private String address;
	private String postcode;
	private String city;
	@Lob
	private String remark;
	private int periodofnotice;
	
	public House() {
	}
	
	public void removeRoom(Room r) {
		this.occupied -= r.getOccupied();
		this.capacity -= r.getCapacity();
		this.noofrooms--;
		calculateCostPerPerson();
	}
	
	public void addRoom(Room r) {
		this.capacity += r.getCapacity();
		this.noofrooms++;
		calculateCostPerPerson();
	}
	
	public void addPerson() {
		this.occupied++;
	}
	
	public void removePerson() {
		this.occupied--;
	}
	
	public void addBed() {
		this.capacity++;
		calculateCostPerPerson();	
	}
	
	public void removeBed() {
		this.capacity--;
		calculateCostPerPerson();
	}
	
	private void calculateCostPerPerson() {
		if(costType.equals(CostType.RENT))
			this.perperson = rent/capacity;
		else if(costType.equals(CostType.MEDIARENT))
			this.perperson = (rent + media)/capacity;
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
		this.costType = ff.getCostType();
	}

}
