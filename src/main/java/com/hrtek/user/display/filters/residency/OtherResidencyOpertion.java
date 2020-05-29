package com.hrtek.user.display.filters.residency;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.filters.ResidencyFilter;
import com.hrtek.user.display.views.ResidencyView;

public class OtherResidencyOpertion extends OtherFilterOperation<ResidencyView, ResidencyFilter> {

	private ResidencyFilter bf;
	
	@Override
	public void setFilter(ResidencyFilter v) {
		this.bf = v;
		
	}

	@Override
	public List<ResidencyView> filterother(List<ResidencyView> list) {
		list = byCompany(list);
		list = byFactory(list);
		list = byStatus(list);
		return list;
	}
	
	private List<ResidencyView> byFactory(List<ResidencyView> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

	private List<ResidencyView> byCompany(List<ResidencyView> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		for(ResidencyView b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<ResidencyView> byStatus(List<ResidencyView> list) {
		if(bf.getByStatus() == null || bf.getByStatus().equals("ALL")) return list;
		List<ResidencyView> newList = new ArrayList<ResidencyView>();
		long intStatus = Long.valueOf(bf.getByStatus());
		for(ResidencyView b : list) {
			if(b.getStatus() == intStatus)
				newList.add(b);
		}
		return newList;
	}

}
