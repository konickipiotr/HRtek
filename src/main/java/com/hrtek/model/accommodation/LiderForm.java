package com.hrtek.model.accommodation;

public class LiderForm {
	private Long id;
	private Long liderid;
	private String lidername;
	private double liderbonus;
	
	public LiderForm() {
	}

	public LiderForm(Long id, Long liderid, String lidername, double liderbonus) {
		this.id = id;
		this.liderid = liderid;
		this.lidername = lidername;
		this.liderbonus = liderbonus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "LiderForm [id=" + id + ", liderid=" + liderid + ", lidername=" + lidername + ", liderbonus="
				+ liderbonus + "]";
	}	
}
