package com.hrtek.utils;

public class CurrencyUtils {
	
	public String valueToText(double val) {
		String sval = String.valueOf(val);
		int front;
		int back;
		String sfront = "";
		String sback = "";
		if(sval.contains(",")) {
			String[] arr = sval.split(",");
			front = Integer.parseInt(arr[0]);
			back = Integer.parseInt(arr[1]);
			sback = build(back);
		}else {
			front = (int) val;
		}
		
		sfront = build(front);
		
		
		String resutl = "";
		if(!sfront.equals("")) {
			resutl = sfront + " złotych";
		}
		if(!sback.equals("")) {
			resutl += " " + sback + " groszy";
		}
			
		return resutl;
	}
	
	private String build(int val) {
		if(val < 10) {
			return toStringUnity(val);
		}else if(val < 20) {
			return toStrdozen(val);
		}else if(val < 100) {
			return strAboveNineteen(val);
		}
		return "";
	}

	private String toStringUnity(int v) {
		switch (v) {
		case 1: return "jeden";
		case 2: return "dwa";
		case 3: return "trzy";
		case 4: return "cztery";
		case 5: return "pięć";
		case 6: return "sześć";
		case 7: return "siedem";
		case 8: return "osiem";
		case 9: return "dziewięć";
		default:
			return "";
		}
	}
	
	private String toStrdozen(int v) {
		switch (v) {
		case 1: return "jedynaście";
		case 2: return "dwanaście";
		case 3: return "trzynaście";
		case 4: return "czternaście";
		case 5: return "piętnaście";
		case 6: return "szesnaście";
		case 7: return "siedemnaście";
		case 8: return "osiemnascie";
		case 9: return "dziewiętnaście";
		default:
			return "zero";
		}
	}
	
	private String strAboveNineteen(int val) {
		
		int x = val/10;
		int z = val%10;
		
		String front = "";
		switch (x) {
		case 1: front = "jedynaście"; break;
		case 2: front = "dwanaście"; break;
		case 3: front = "trzynaście"; break;
		case 4: front = "czternaście"; break;
		case 5: front = "piętnaście"; break;
		case 6: front = "szesnaście"; break;
		case 7: front = "siedemnaście"; break;
		case 8: front = "osiemnascie"; break;
		default:
			front = "dziewiętnaście"; break;

		}
		return front + " " + toStringUnity(z);
	}
}
