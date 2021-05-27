package com.hrtek.user.report.views;


import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;

public class ReportAccommodation implements Comparable<ReportAccommodation> {
	
	private String address;
	private int capacity;
	private int free;
	
	public ReportAccommodation() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public static boolean isup = false;
	public static ViewFields field = ViewFields.ADDRESS;

	@Override
	public int compareTo(ReportAccommodation o) {
		switch (field) {
			case ADDRESS: return FieldsComparator.compareText(this.address, o.getAddress(), isup);
			case NUMOFBEDS: return FieldsComparator.compareNumber(this.capacity, o.getCapacity(), isup);
			case FREEBEDS: return FieldsComparator.compareNumber(this.free, o.getFree(), isup);
			default:
				break;
		}
		return 0;
	}
}
