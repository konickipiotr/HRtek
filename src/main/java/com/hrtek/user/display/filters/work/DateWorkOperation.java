package com.hrtek.user.display.filters.work;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.filters.WorkFilters;
import com.hrtek.user.display.views.WorkersView;

public class DateWorkOperation extends DateFilterOperation<WorkersView, WorkFilters> {

	private WorkFilters bf;
	
	@Override
	public void setFilter(WorkFilters v) {
		this.bf = v;
		
	}

	@Override
	public List<WorkersView> datefilter(List<WorkersView> list) {
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
		if(bf.isByStatementFrom())
			list = dateStatementFrom(list);
		if(bf.isByStatementTo())
			list = dateStatementTo(list);
		if(bf.isByPermiFrom())
			list = datePermitFrom(list);
		if(bf.isByPermiTo())
			list = datePermitTo(list);
		
		return list;
	}
	
	private List<WorkersView> datePermitTo(List<WorkersView> list) {
		switch (bf.getPermitValidToMethod()) {
		case EQUAL: return equalPermitValidTo(list);
		case RANGE: return rangePermitValidTo(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> datePermitFrom(List<WorkersView> list) {
		switch (bf.getPermitValidFromoMethod()) {
		case EQUAL: return equalPermitValidFrom(list);
		case RANGE: return rangePermitValidFrom(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateStatementTo(List<WorkersView> list) {
		switch (bf.getStatementValidToMethod()) {
		case EQUAL: return equalStatementValidTo(list);
		case RANGE: return rangeStatementValidTo(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateStatementFrom(List<WorkersView> list) {
		switch (bf.getStatementValidFromMethod()) {
		case EQUAL: return equalStatementValidFrom(list);
		case RANGE: return rangeStatementValidFrom(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateEndZus(List<WorkersView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndZus(list);
		case RANGE: return rangeEndZus(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateEndWork(List<WorkersView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalEndWork(list);
		case RANGE: return rangeEndWork(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateStartZus(List<WorkersView> list) {
		switch (bf.getStartZusMethod()) {
		case EQUAL: return equalStartWork(list);
		case RANGE: return rangeStartZus(list); 
		default:
			return list;
		}
	}

	private List<WorkersView> dateStartWork(List<WorkersView> list) {
		switch (bf.getStartWorkMethod()) {
		case EQUAL: return equalStartWork(list);
		case RANGE: return rangeStartWork(list); 
		default:
			return list;
		}
	}

	List<WorkersView> dateofBirth(List<WorkersView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list); 
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}

	
	
	/*  date of birth  */
	List<WorkersView> equalDateOfBirth(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeDateofBirth(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<WorkersView> less26DateofBirth(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}

	/*  start work  */
	List<WorkersView> equalStartWork(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getStartWork(), b.getStartWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeStartWork(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getStartWork(), bf.getStartWorkTo(), b.getStartWork()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  start zus  */
	List<WorkersView> equalStartZus(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getStartZus(), b.getStartZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeStartZus(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getStartZus(), bf.getStartZusTo(), b.getStartZus()))
				newList.add(b);
		}
		return newList;
	}
	
	
	/*  end zus  */
	List<WorkersView> equalEndZus(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getEndZus(), b.getEndZus())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeEndZus(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getEndZus(), bf.getEndZusTo(), b.getEndZus()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  end work  */
	List<WorkersView> equalEndWork(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getEndWork(), b.getEndWork())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeEndWork(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getEndWork(), bf.getEndWorkTo(), b.getEndWork()))
				newList.add(b);
		}
		return newList;
	}
	

	/*  StatementValidFrom */
	List<WorkersView> equalStatementValidFrom(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getStatementValidFromFrom(), b.getStatementValidFrom())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeStatementValidFrom(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getStatementValidFromFrom(), bf.getStatementValidFromTo(), b.getStatementValidFrom()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  StatementValidTo */
	List<WorkersView> equalStatementValidTo(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getStatementValidToFrom(), b.getStatementValidTo())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangeStatementValidTo(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getStatementValidToFrom(), bf.getStatementValidToTo(), b.getStatementValidTo()))
				newList.add(b);
		}
		return newList;
	}
	
	
	/*  equalPermitValidFrom */
	List<WorkersView> equalPermitValidFrom(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getPermitValidFromFrom(), b.getPermitValidFrom())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangePermitValidFrom(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getPermitValidFromFrom(), bf.getPermitValidFromTo(), b.getPermitValidFrom()))
				newList.add(b);
		}
		return newList;
	}
	

	
	/*  equalPermitValidTo */
	List<WorkersView> equalPermitValidTo(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkEqual(bf.getPermitValidToFrom(), b.getPermitValidTo())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<WorkersView> rangePermitValidTo(List<WorkersView> list) {
		List<WorkersView> newList = new ArrayList<WorkersView>();
		for(WorkersView b : list) {
			if(checkRange(bf.getPermitValidToFrom(), bf.getPermitValidToTo(), b.getPermitValidTo()))
				newList.add(b);
		}
		return newList;
	}
}
