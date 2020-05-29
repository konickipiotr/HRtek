package com.hrtek.user.display.filters.data;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DataFilters;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.views.DataView;

public class OtherDataOperation extends OtherFilterOperation<DataView, DataFilters>{
	
	private DataFilters bf;
	
	@Override
	public void setFilter(DataFilters v) {
		this.bf = v;	
	}

	@Override
	public List<DataView> filterother(List<DataView> list) {
		list = byCompany(list);
		list = byFactory(list);
		list = byStatus(list);
		list = byRecruiter(list);
		return list;
	}
	
	private List<DataView> byStatus(List<DataView> list) {
		if(bf.getByStatus() == null || bf.getByStatus().equals("ALL")) return list;
		List<DataView> newList = new ArrayList<DataView>();
		long intStatus = Long.valueOf(bf.getByStatus());
		for(DataView b : list) {
			if(b.getStatus() == intStatus)
				newList.add(b);
		}
		return newList;
	}

	private List<DataView> byFactory(List<DataView> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

	private List<DataView> byCompany(List<DataView> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<DataView> byRecruiter(List<DataView> list) {
		if(bf.getByRecruiter() == null || bf.getByRecruiter().isBlank()) return list;
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(b.getRecruiter().equals(bf.getByRecruiter()))
				newList.add(b);
		}
		return newList;
	}
}
