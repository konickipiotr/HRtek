package com.hrtek.user.display.filters.contact;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.ContactFilters;
import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.views.BasicView;
import com.hrtek.user.display.views.ContactViewDis;
import com.hrtek.user.display.views.DataView;

public class DateContactOperation extends DateFilterOperation<ContactViewDis, ContactFilters> {

	private ContactFilters bf;
	
	@Override
	public void setFilter(ContactFilters v) {
		this.bf = v;	
		
	}

	@Override
	public List<ContactViewDis> datefilter(List<ContactViewDis> list) {
		if(bf.isBydateofbirth()) 
			list = dateofBirth(list);
		return list;
	}
	
	List<ContactViewDis> dateofBirth(List<ContactViewDis> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}
	

	/*  date of birth  */
	List<ContactViewDis> equalDateOfBirth(List<ContactViewDis> list) {
		List<ContactViewDis> newlist = new ArrayList<ContactViewDis>();
		for(ContactViewDis b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<ContactViewDis> rangeDateofBirth(List<ContactViewDis> list) {
		List<ContactViewDis> newList = new ArrayList<ContactViewDis>();
		for(ContactViewDis b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<ContactViewDis> less26DateofBirth(List<ContactViewDis> list) {
		List<ContactViewDis> newList = new ArrayList<ContactViewDis>();
		for(ContactViewDis b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}


}
