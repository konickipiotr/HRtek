package com.hrtek.model.accommodation;

public class AddressForm {
	private Long id;
	private String address;
	private String postcode;
	private String city;
	
	public AddressForm() {
	}
	public AddressForm(Long id, String address, String postcode, String city) {
		this.id = id;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "AddressForm [id=" + id + ", address=" + address + ", postcode=" + postcode + ", city=" + city + "]";
	}
}
