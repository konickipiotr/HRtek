package com.hrtek.user.display.filters.residency;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.filters.ResidencyFilter;
import com.hrtek.user.display.views.ContactViewDis;
import com.hrtek.user.display.views.ResidencyView;

public class DateResidencyOperation extends DateFilterOperation<ResidencyView, ResidencyFilter> {

	private ResidencyFilter bf;
	
	@Override
	public void setFilter(ResidencyFilter v) {
		this.bf = v;
		
	}

	@Override
	public List<ResidencyView> datefilter(List<ResidencyView> list) {
		if(bf.isBydateofbirth()) 
			list = dateofBirth(list);
		if(bf.isByvisafrom())
			list = visaFrom(list);
		if(bf.isByvisato())
			list = visaTo(list);
		return list;
	}

	private List<ResidencyView> visaTo(List<ResidencyView> list) {
		switch (bf.getVisaMethodTo()) {
		case EQUAL: return equalVisaTo(list);
		case RANGE: return rangeVisaTo(list); 
		default:
			return list;
		}
	}

	private List<ResidencyView> visaFrom(List<ResidencyView> list) {
		switch (bf.getVisaMethodFrom()) {
		case EQUAL: return equalVisaFrom(list);
		case RANGE: return rangeVisaFrom(list); 
		default:
			return list;
		}
	}

	private List<ResidencyView> dateofBirth(List<ResidencyView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}
	
	/*  date of birth  */
	List<ResidencyView> equalDateOfBirth(List<ResidencyView> list) {
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<ResidencyView> rangeDateofBirth(List<ResidencyView> list) {
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<ResidencyView> less26DateofBirth(List<ResidencyView> list) {
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
		
	/*  visa  */
	List<ResidencyView> equalVisaFrom(List<ResidencyView> list) {
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkEqual(bf.getVisaValidFromFrom(), b.getVisaValidFrom())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<ResidencyView> rangeVisaFrom(List<ResidencyView> list) {
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkRange(bf.getVisaValidFromFrom(), bf.getVisaValidFromTo(), b.getVisaValidFrom()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  visa  */
	List<ResidencyView> equalVisaTo(List<ResidencyView> list) {
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkEqual(bf.getVisaValidToFrom(), b.getVisaValidTo())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<ResidencyView> rangeVisaTo(List<ResidencyView> list) {
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(checkRange(bf.getVisaValidToFrom(), bf.getVisaValidToTo(), b.getVisaValidTo()))
				newList.add(b);
		}
		return newList;
	}

}
