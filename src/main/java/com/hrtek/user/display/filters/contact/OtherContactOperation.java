package com.hrtek.user.display.filters.contact;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.model.accommodation.House;
import com.hrtek.user.display.filters.ContactFilters;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.views.ContactViewDis;

public class OtherContactOperation extends OtherFilterOperation<ContactViewDis, ContactFilters> {

	private ContactFilters bf;

	@Override
	public void setFilter(ContactFilters v) {
		this.bf = v;	
		
	}

	@Override
	public List<ContactViewDis> filterother(List<ContactViewDis> list) {
		list = byCompany(list);
		list = byFactory(list);
		list = byHouse(list);
		return list;
	}
	

	private List<ContactViewDis> byHouse(List<ContactViewDis> list){
		if(bf.getByHouse() == null) return list;
		List<ContactViewDis> newList = new ArrayList<ContactViewDis>();
		if(bf.getByHouse().equals(-1l)) {
			for(ContactViewDis b : list) {
				if(b.getHouseid() == null && (b.getPladdress() != null && !b.getPladdress().isBlank()))
						newList.add(b);
			}
		}else {
			for(ContactViewDis b : list) {
				if(bf.getByHouse().equals(b.getHouseid()))
					newList.add(b);
			}
		}
		return newList;
	}
	
	private List<ContactViewDis> byCompany(List<ContactViewDis> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<ContactViewDis> newList = new ArrayList<ContactViewDis>();
		for(ContactViewDis b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<ContactViewDis> byFactory(List<ContactViewDis> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<ContactViewDis> newList = new ArrayList<ContactViewDis>();
		for(ContactViewDis b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

}
