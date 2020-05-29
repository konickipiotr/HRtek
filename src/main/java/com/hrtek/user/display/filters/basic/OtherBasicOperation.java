package com.hrtek.user.display.filters.basic;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.views.BasicView;

public class OtherBasicOperation extends OtherFilterOperation<BasicView, BasicFilters>{

	private BasicFilters bf;
	
	@Override
	public	void setFilter(BasicFilters v) {
		this.bf = v;		
	}

	@Override
	public List<BasicView> filterother(List<BasicView> list) {
		list = bySex(list);
		list = byCitizenship(list);
		list = byCompany(list);
		list = byFactory(list);
		list = byStatus(list);
		return list;
	}
	
	private List<BasicView> byStatus(List<BasicView> list) {
		if(bf.getByStatus() == null || bf.getByStatus().equals("ALL")) return list;
		List<BasicView> newList = new ArrayList<BasicView>();
		long intStatus = Long.valueOf(bf.getByStatus());
		for(BasicView b : list) {
			if(b.getStatus() == intStatus)
				newList.add(b);
		}
		return newList;
	}

	private List<BasicView> byFactory(List<BasicView> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

	private List<BasicView> byCompany(List<BasicView> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}

	private List<BasicView> byCitizenship(List<BasicView> list) {
		if(bf.getByCitizenship() == null || bf.getByCitizenship().isBlank()) return list;
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(b.getCitizenship().equals(bf.getByCitizenship()))
				newList.add(b);
		}
		return newList;
	}

	private List<BasicView> bySex(List<BasicView> list) {
		String sex = bf.getBysex();
		if(sex == null || sex.equals("all")) return list;
		
		List<BasicView> newList = new ArrayList<BasicView>();
		
		for(BasicView b : list) {
			if(b.getSex().equals(bf.getBysex()))
				newList.add(b);
		}
		return newList;
	}
	

}
