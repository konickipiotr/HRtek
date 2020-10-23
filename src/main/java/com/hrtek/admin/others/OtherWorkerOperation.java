package com.hrtek.admin.others;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.OtherFilterOperation;


public class OtherWorkerOperation extends OtherFilterOperation<WorkerView, WorkerFilters> {
	
	private WorkerFilters bf;
	
	@Override
	public	void setFilter(WorkerFilters v) {
		this.bf = v;		
	}

	@Override
	public List<WorkerView> filterother(List<WorkerView> list) {
		list = byCompany(list);
		list = byFactory(list);
		return list;
	}
	
	private List<WorkerView> byFactory(List<WorkerView> list) {
		if(bf.getByFactory() == null || bf.getByFactory().isBlank()) return list;
		List<WorkerView> newList = new ArrayList<WorkerView>();
		for(WorkerView b : list) {
			if(b.getFactory().equals(bf.getByFactory()))
				newList.add(b);
		}
		return newList;
	}

	private List<WorkerView> byCompany(List<WorkerView> list) {
		if(bf.getByCompany() == null || bf.getByCompany().isBlank()) return list;
		List<WorkerView> newList = new ArrayList<WorkerView>();
		for(WorkerView b : list) {
			if(b.getCompany().equals(bf.getByCompany()))
				newList.add(b);
		}
		return newList;
	}
}
