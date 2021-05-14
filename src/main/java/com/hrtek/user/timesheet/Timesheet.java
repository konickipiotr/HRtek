package com.hrtek.user.timesheet;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.hrtek.model.worker.Worker;


@Entity
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
		
	}
	
	public Timesheet(LocalDate now) {
		
		String value = "";
		StringBuilder sb = new StringBuilder();
		for(int day = 0; day < 366; day++) {
				sb.append("XX");
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
		
		int year = now.getYear();
		
		switch (year) {
		case 2020: y2020 = perpare(now, 2020);
		case 2021: y2021 = perpare(now, 2021);
		case 2022: y2022 = perpare(now, 2022);
		case 2023: y2023 = perpare(now, 2023);
		case 2024: y2024 = perpare(now, 2024);
		case 2025: y2025 = perpare(now, 2025);
		case 2026: y2026 = perpare(now, 2026);
		case 2027: y2027 = perpare(now, 2027);
		case 2028: y2028 = perpare(now, 2028);
		case 2029: y2029 = perpare(now, 2029);
		case 2030: y2030 = perpare(now, 2030);
		case 2031: y2031 = perpare(now, 2031);
		case 2032: y2032 = perpare(now, 2032);
		case 2033: y2033 = perpare(now, 2033);
		case 2034: y2034 = perpare(now, 2034);
		
//		case 2035: y2035 = perpare(now, 2035);
//		case 2036: y2036 = perpare(now, 2036);
//		case 2037: y2037 = perpare(now, 2037);
//		case 2038: y2038 = perpare(now, 2038);
//		case 2039: y2039 = perpare(now, 2039);
//		case 2040: y2040 = perpare(now, 2040);
		
		default:
			break;
		}

	}
	
	private String perpare(LocalDate now, int year) {
		int dayOfYear = 0;
		int currYear = now.getYear();
		if(currYear == year) {
			dayOfYear = (now.getDayOfYear() - 1) * 2;
		}
		
		String syear = "y" + year;
		StringBuilder currentYear = new StringBuilder(getCurrentYear(syear));
		for(int i = dayOfYear; i < currentYear.length(); i++) {
			currentYear.setCharAt(i, '0');			
		}
		return currentYear.toString();
	}
	
	public Timesheet(Worker w, LocalDate now) {
		this(now);
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

	public Long getWorkerid() {
		return workerid;
	}

	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}

	public Long getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(Long factoryid) {
		this.factoryid = factoryid;
	}

	public String getY2020() {
		return y2020;
	}

	public void setY2020(String y2020) {
		this.y2020 = y2020;
	}

	public String getY2021() {
		return y2021;
	}

	public void setY2021(String y2021) {
		this.y2021 = y2021;
	}

	public String getY2022() {
		return y2022;
	}

	public void setY2022(String y2022) {
		this.y2022 = y2022;
	}

	public String getY2023() {
		return y2023;
	}

	public void setY2023(String y2023) {
		this.y2023 = y2023;
	}

	public String getY2024() {
		return y2024;
	}

	public void setY2024(String y2024) {
		this.y2024 = y2024;
	}

	public String getY2025() {
		return y2025;
	}

	public void setY2025(String y2025) {
		this.y2025 = y2025;
	}

	public String getY2026() {
		return y2026;
	}

	public void setY2026(String y2026) {
		this.y2026 = y2026;
	}

	public String getY2027() {
		return y2027;
	}

	public void setY2027(String y2027) {
		this.y2027 = y2027;
	}

	public String getY2028() {
		return y2028;
	}

	public void setY2028(String y2028) {
		this.y2028 = y2028;
	}

	public String getY2029() {
		return y2029;
	}

	public void setY2029(String y2029) {
		this.y2029 = y2029;
	}

	public String getY2030() {
		return y2030;
	}

	public void setY2030(String y2030) {
		this.y2030 = y2030;
	}

	public String getY2031() {
		return y2031;
	}

	public void setY2031(String y2031) {
		this.y2031 = y2031;
	}

	public String getY2032() {
		return y2032;
	}

	public void setY2032(String y2032) {
		this.y2032 = y2032;
	}

	public String getY2033() {
		return y2033;
	}

	public void setY2033(String y2033) {
		this.y2033 = y2033;
	}

	public String getY2034() {
		return y2034;
	}

	public void setY2034(String y2034) {
		this.y2034 = y2034;
	}
}

