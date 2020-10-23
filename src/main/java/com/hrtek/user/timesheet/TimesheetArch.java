package com.hrtek.user.timesheet;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import com.hrtek.model.worker.Worker;

import lombok.Data;

@Entity
@Data
public class TimesheetArch {
	@Id
	private Long workerid;
	private String factory;

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
	
	public TimesheetArch() {
		
	}
	
	public TimesheetArch(Timesheet t) {
			
			this.y2020 = t.getY2020();
			this.y2021 = t.getY2021();
			this.y2022 = t.getY2022();
			this.y2023 = t.getY2023();
			this.y2024 = t.getY2024();
			this.y2025 = t.getY2025();
			this.y2026 = t.getY2026();
			this.y2027 = t.getY2027();
			this.y2028 = t.getY2028();
			this.y2029 = t.getY2029();
			this.y2030 = t.getY2030();
			this.y2031 = t.getY2031();
			this.y2032 = t.getY2032();
			this.y2033 = t.getY2033();
			this.y2034 = t.getY2034();
//			this.y2035 = t.getY2035();
//			this.y2036 = t.getY2036();
//			this.y2037 = t.getY2037();
//			this.y2038 = t.getY2038();
//			this.y2039 = t.getY2039();
//			this.y2040 = t.getY2040();
	}
	
	public TimesheetArch(LocalDate now) {
		
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
