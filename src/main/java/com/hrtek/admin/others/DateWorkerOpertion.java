package com.hrtek.admin.others;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DateFilterOperation;

public class DateWorkerOpertion extends DateFilterOperation<WorkerView, WorkerFilters> {
	
	private WorkerFilters bf;
	

	@Override
	public void setFilter(WorkerFilters v) {
		this.bf = v;
	}
	
	@Override
	public List<WorkerView> datefilter(List<WorkerView> list) {
		if(bf.isBydateofbirth()) 
			list = dateofBirth(list);		
		return list;
	}
	

	List<WorkerView> dateofBirth(List<WorkerView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}

	
	/*  date of birth  */
	private List<WorkerView> equalDateOfBirth(List<WorkerView> list) {
		List<WorkerView> newlist = new ArrayList<WorkerView>();
		for(WorkerView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkerView> rangeDateofBirth(List<WorkerView> list) {
		List<WorkerView> newList = new ArrayList<WorkerView>();
		for(WorkerView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<WorkerView> less26DateofBirth(List<WorkerView> list) {
		List<WorkerView> newList = new ArrayList<WorkerView>();
		for(WorkerView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}

}
