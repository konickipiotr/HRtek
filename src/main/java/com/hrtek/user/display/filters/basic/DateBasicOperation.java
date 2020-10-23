package com.hrtek.user.display.filters.basic;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.views.BasicView;

public class DateBasicOperation extends DateFilterOperation<BasicView, BasicFilters> {
	
	private BasicFilters bf;
	
	@Override
	public void setFilter(BasicFilters v) {
		this.bf = v;
	}
	
	@Override
	public List<BasicView> datefilter(List<BasicView> list) {
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
	
	private List<BasicView> dateEndZus(List<BasicView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndZus(list);
		case RANGE: return rangeEndZus(list); 
		default:
			return list;
		}
	}

	private List<BasicView> dateEndWork(List<BasicView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndWork(list);
		case RANGE: return rangeEndWork(list); 
		default:
			return list;
		}
	}

	private List<BasicView> dateStartZus(List<BasicView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalStartZus(list);
		case RANGE: return rangeStartZus(list); 
		default:
			return list;
		}
	}

	private List<BasicView> dateStartWork(List<BasicView> list) {
		switch (bf.getStartWorkMethod()) {
		case EQUAL: return equalStartWork(list);
		case RANGE: return rangeStartWork(list); 
		default:
			return list;
		}
	}

	List<BasicView> dateofBirth(List<BasicView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}

	
	
	/*  date of birth  */
	private List<BasicView> equalDateOfBirth(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<BasicView> rangeDateofBirth(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<BasicView> less26DateofBirth(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}

	/*  start work  */
	private List<BasicView> equalStartWork(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkEqual(bf.getStartWork(), b.getStartWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<BasicView> rangeStartWork(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkRange(bf.getStartWork(), bf.getStartWorkTo(), b.getStartWork()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  start zus  */
	private List<BasicView> equalStartZus(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkEqual(bf.getStartZus(), b.getStartZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<BasicView> rangeStartZus(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkRange(bf.getStartZus(), bf.getStartZusTo(), b.getStartZus()))
				newList.add(b);
		}
		return newList;
	}
	
	
	/*  end zus  */
	private List<BasicView> equalEndZus(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkEqual(bf.getEndZus(), b.getEndZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<BasicView> rangeEndZus(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkRange(bf.getEndZus(), bf.getEndZusTo(), b.getEndZus()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  end work  */
	private List<BasicView> equalEndWork(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkEqual(bf.getEndWork(), b.getEndWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<BasicView> rangeEndWork(List<BasicView> list) {
		List<BasicView> newList = new ArrayList<BasicView>();
		for(BasicView b : list) {
			if(checkRange(bf.getEndWork(), bf.getEndWorkTo(), b.getEndWork()))
				newList.add(b);
		}
		return newList;
	}
}
