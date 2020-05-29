package com.hrtek.user.display.filters.data;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DataFilters;
import com.hrtek.user.display.filters.DateFilterOperation;
import com.hrtek.user.display.views.DataView;

public class DateDataOperation extends DateFilterOperation<DataView, DataFilters> {
	
	private DataFilters bf;
	
	@Override
	public void setFilter(DataFilters v) {
		this.bf = v;	
	}

	@Override
	public List<DataView> datefilter(List<DataView> list) {
		if(bf.isBydateofbirth()) 
			list = dateofBirth(list);
		if(bf.isByStartMedicalFrom())
			list = dateStartMedical(list);
		if(bf.isByStartMedicalTo())
			list = dateEndMedical(list);
		if(bf.isByAddToSystem())
			list = addToSystem(list);
		return list;
	}
	
	private List<DataView> addToSystem(List<DataView> list) {
		switch (bf.getAddToSystemMethod()) {
		case EQUAL: return equalAddToSystem(list);
		case RANGE: return rangeAddToSystem(list); 
		default:
			return list;
		}
	}

	private List<DataView> dateEndMedical(List<DataView> list) {
		switch (bf.getStartMedicalFromMethod()) {
		case EQUAL: return equalEndMedical(list);
		case RANGE: return rangeEndMedical(list); 
		default:
			return list;
		}
	}

	private List<DataView> dateStartMedical(List<DataView> list) {
		switch (bf.getStartMedicalFromMethod()) {
		case EQUAL: return equalStartMedical(list);
		case RANGE: return rangeStartMedical(list); 
		default:
			return list;
		}
	}
	


	private List<DataView> dateofBirth(List<DataView> list) {
		switch (bf.getDateofbirthMethod()) {
		case EQUAL: return equalDateOfBirth(list);
		case RANGE: return rangeDateofBirth(list);
		case LESS26: return less26DateofBirth(list);
		default:
			return list;
		}
	}
	


	/*  add to system  */
	private List<DataView> rangeAddToSystem(List<DataView> list) {
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkEqual(bf.getAddToSystemFrom(), b.getAddToSystem())) {
				newlist.add(b);
			}
		}
		return newlist;
	}

	private List<DataView> equalAddToSystem(List<DataView> list) {
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkRange(bf.getAddToSystemFrom(), bf.getAddToSystemTo(), b.getAddToSystem()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  end medical  */
	private List<DataView> rangeEndMedical(List<DataView> list) {
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkEqual(bf.getEndMedicalFrom(), b.getEndMedicalExams())) {
				newlist.add(b);
			}
		}
		return newlist;
	}

	private List<DataView> equalEndMedical(List<DataView> list) {
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkRange(bf.getEndMedicalFrom(), bf.getEndMedicalTo(), b.getEndMedicalExams()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  start medical  */
	private List<DataView> rangeStartMedical(List<DataView> list) {
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkEqual(bf.getStartMedicalFromFrom(), b.getStartMedicalExams())) {
				newlist.add(b);
			}
		}
		return newlist;
	}

	private List<DataView> equalStartMedical(List<DataView> list) {
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkRange(bf.getStartMedicalFromFrom(), bf.getStartMedicalFromTo(), b.getStartMedicalExams()))
				newList.add(b);
		}
		return newList;
	}
	
	/*  date of birth  */
	List<DataView> equalDateOfBirth(List<DataView> list) {
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkEqual(bf.getDateofbirth(), b.getDateofbirth())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<DataView> rangeDateofBirth(List<DataView> list) {
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(checkRange(bf.getDateofbirth(), bf.getDateofbirthTo(), b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<DataView> less26DateofBirth(List<DataView> list) {
		List<DataView> newList = new ArrayList<DataView>();
		for(DataView b : list) {
			if(isLessThan26(b.getDateofbirth()))
				newList.add(b);
		}
		return newList;
	}
}
