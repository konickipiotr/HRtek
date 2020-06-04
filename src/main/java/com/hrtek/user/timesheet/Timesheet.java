package com.hrtek.user.timesheet;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.hrtek.model.worker.Worker;

import lombok.Data;

@Entity
@Data
public class Timesheet {

	@Id
	private Long workerid;
	private Long factoryid;

	@Length(max = 1000)
	private String y2020;
	@Length(max = 1000)
	private String y2021;
	@Length(max = 1000)
	private String y2022;
	@Length(max = 1000)
	private String y2023;
	@Length(max = 1000)
	private String y2024;
	@Length(max = 1000)
	private String y2025;
	@Length(max = 1000)
	private String y2026;
	@Length(max = 1000)
	private String y2027;
	@Length(max = 1000)
	private String y2028;
	@Length(max = 1000)
	private String y2029;
	@Length(max = 1000)
	private String y2030;
	@Length(max = 1000)
	private String y2031;
	@Length(max = 1000)
	private String y2032;
	@Length(max = 1000)
	private String y2033;
	@Length(max = 1000)
	private String y2034;
//	@Length(max = 1000)
//	private String y2035;
//	@Length(max = 1000)
//	private String y2036;
//	@Length(max = 1000)
//	private String y2037;
//	@Length(max = 1000)
//	private String y2038;
//	@Length(max = 1000)
//	private String y2039;
//	@Length(max = 1000)
//	private String y2040;
	
	
	public Timesheet() {
		
		String value = "";
		StringBuilder sb = new StringBuilder();
		for(int day = 0; day < 366; day++) {
				sb.append("12");
		}
			
		value = sb.toString();

		y2020 = value;
		y2021 = value;
		y2022 = value;
		y2023 = value;
		y2024 = value;
		y2025 = value;
		y2026 = value;
		y2027 = value;
		y2028 = value;
		y2029 = value;
		y2030 = value;
		y2031 = value;
		y2032 = value;
		y2033 = value;
		y2034 = value;
//		y2035 = value;
//		y2036 = value;
//		y2037 = value;
//		y2038 = value;
//		y2039 = value;
//		y2040 = value;
	}
	
	public Timesheet(Worker w) {
		this();
		this.factoryid = w.getFactoryid();
		this.workerid = w.getId();
	}

	
	public String getCurrentYear(String syear) {
		
		switch(syear) {
		case "y2020": return this.getY2020();
		case "y2021": return this.getY2021();
		case "y2022": return this.getY2022();
		case "y2023": return this.getY2023();
		case "y2024": return this.getY2024();
		case "y2025": return this.getY2025();
		case "y2026": return this.getY2026();
		case "y2027": return this.getY2027();
		case "y2028": return this.getY2028();
		case "y2029": return this.getY2029();
		case "y2030": return this.getY2030();
		case "y2031": return this.getY2031();
		case "y2032": return this.getY2032();
		case "y2033": return this.getY2033();
		case "y2034": return this.getY2034();
//		case "y2035": return this.getY2035();
//		case "y2036": return this.getY2036();
//		case "y2037": return this.getY2037();
//		case "y2038": return this.getY2038();
//		case "y2039": return this.getY2039();
//		case "y2040": return this.getY2040();
		}
		return "";
	}
	
	public void setCurrentYear(String syear, String value) {
		
		switch(syear) {
		case "y2020": this.setY2020(value);
		case "y2021": this.setY2021(value);
		case "y2022": this.setY2022(value);
		case "y2023": this.setY2023(value);
		case "y2024": this.setY2024(value);
		case "y2025": this.setY2025(value);
		case "y2026": this.setY2026(value);
		case "y2027": this.setY2027(value);
		case "y2028": this.setY2028(value);
		case "y2029": this.setY2029(value);
		case "y2030": this.setY2030(value);
		case "y2031": this.setY2031(value);
		case "y2032": this.setY2032(value);
		case "y2033": this.setY2033(value);
		case "y2034": this.setY2034(value);
//		case "y2035": this.setY2035(value);
//		case "y2036": this.setY2036(value);
//		case "y2037": this.setY2037(value);
//		case "y2038": this.setY2038(value);
//		case "y2039": this.setY2039(value);
//		case "y2040": this.setY2040(value);
		}
	}
}

