package com.hrtek.user.display.filters.work;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.filters.WorkFilters;
import com.hrtek.user.display.views.WorkersView;

public class OtherWorkOperation extends OtherFilterOperation<WorkersView, WorkFilters> {

	private WorkFilters bf;
	
	@Override
	public void setFilter(WorkFilters v) {
		this.bf = v;
	}

	@Override
	public List<WorkersView> filterother(List<WorkersView> list) {
		list = byCompany(list);
		list = byFactory(list);
		list = byStatus(list);
		list = byRecruiter(list);
		list = byStatementType(list);
		return list;
	}
	
	private List<WorkersView> byRecruiter(List<WorkersView> list) {
		if(bf.getByRecruiter() == null || bf.getByRecruiter().isBlank()) return list;
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(b.getRecruiter().equals(bf.getByRecruiter()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<WorkersView> byStatementType(List<WorkersView> list) {
		if(bf.getByStatementType() == null || bf.getByStatementType().isBlank()) return list;
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(b.getStatementType().equals(bf.getByStatementType()))
				newList.add(b);
		}
		return newList;
	}
	
	
	private List<WorkersView> byStatus(List<WorkersView> list) {
		if(bf.getByStatus() == null || bf.getByStatus().equals("ALL")) return list;
		List<WorkersView> newList = new ArrayList<WorkersView>();
		long intStatus = Long.valueOf(bf.getByStatus());
		for(WorkersView b : list) {
			if(b.getStatus() == intStatus)
				newList.add(b);
		}
		return newList;
	}

	private List<WorkersView> byFactory(List<WorkersView> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

	private List<WorkersView> byCompany(List<WorkersView> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}
}
