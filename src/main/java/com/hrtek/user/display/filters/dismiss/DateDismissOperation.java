package com.hrtek.user.display.filters.dismiss;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.filters.DismissedFilters;
import com.hrtek.user.display.views.DismissedView;

public class DateDismissOperation extends DateFilterOperation<DismissedView, DismissedFilters> {

	private DismissedFilters bf;
	
	@Override
	public void setFilter(DismissedFilters v) {
		this.bf = v;
		
	}

	@Override
	public List<DismissedView> datefilter(List<DismissedView> list) {
		if(bf.isBydateofbirth()) 
			list = dateofBirth(list);
		if(bf.isByStartWork()) 
			list = dateStartWork(list);
		if(bf.isByStartZus())
			list = dateStartZus(list);
		if(bf.isByEndWork())
			list = dateEndWork(list);
		if(bf.isByEndZus())
			list = dateEndZus(list);
		return list;
	}

	private List<DismissedView> dateEndZus(List<DismissedView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndZus(list);
		case RANGE: return rangeEndZus(list); 
		default:
			return list;
		}
	}

	private List<DismissedView> dateEndWork(List<DismissedView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndWork(list);
		case RANGE: return rangeEndWork(list); 
		default:
			return list;
		}
	}

	private List<DismissedView> dateStartZus(List<DismissedView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalStartWork(list);
		case RANGE: return rangeStartZus(list); 
		default:
			return list;
		}
	}

	private List<DismissedView> dateStartWork(List<DismissedView> list) {
		switch (bf.getStartWorkMethod()) {
		case EQUAL: return equalStartWork(list);
		case RANGE: return rangeStartWork(list); 
		default:
			return list;
		}
	}

	List<DismissedView> dateofBirth(List<DismissedView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}
	
	/*  date of birth  */
	List<DismissedView> equalDateOfBirth(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DismissedView> rangeDateofBirth(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<DismissedView> less26DateofBirth(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}

	/*  start work  */
	List<DismissedView> equalStartWork(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkEqual(bf.getStartWork(), b.getStartWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DismissedView> rangeStartWork(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkRange(bf.getStartWork(), bf.getStartWorkTo(), b.getStartWork()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  start zus  */
	List<DismissedView> equalStartZus(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkEqual(bf.getStartZus(), b.getStartZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DismissedView> rangeStartZus(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkRange(bf.getStartZus(), bf.getStartZusTo(), b.getStartZus()))
				newList.add(b);
		}
		return newList;
	}
	
	
	/*  end zus  */
	List<DismissedView> equalEndZus(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkEqual(bf.getEndZus(), b.getEndZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DismissedView> rangeEndZus(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkRange(bf.getEndZus(), bf.getEndZusTo(), b.getEndZus()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  end work  */
	List<DismissedView> equalEndWork(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkEqual(bf.getEndWork(), b.getEndWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DismissedView> rangeEndWork(List<DismissedView> list) {
		List<DismissedView> newList = new ArrayList<DismissedView>();
		for(DismissedView b : list) {
			if(checkRange(bf.getEndWork(), bf.getEndWorkTo(), b.getEndWork()))
				newList.add(b);
		}
		return newList;
	}
}
