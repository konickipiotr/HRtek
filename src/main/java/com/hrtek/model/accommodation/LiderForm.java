package com.hrtek.model.accommodation;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LiderForm {
	private Long id;
	private Long liderid;
	private String lidername;
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal liderbonus;
	
	public LiderForm() {
		this.liderbonus = new BigDecimal("0");
	}

	public LiderForm(Long id, Long liderid, String lidername, BigDecimal liderbonus) {
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

	public BigDecimal getLiderbonus() {
		return liderbonus.setScale(2, RoundingMode.HALF_UP);
	}

	public void setLiderbonus(BigDecimal liderbonus) {
		this.liderbonus = liderbonus.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "LiderForm [id=" + id + ", liderid=" + liderid + ", lidername=" + lidername + ", liderbonus="
				+ liderbonus + "]";
	}	
}
