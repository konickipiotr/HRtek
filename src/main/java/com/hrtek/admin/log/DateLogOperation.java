package com.hrtek.admin.log;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.model.Log;
import com.hrtek.user.display.filters.DateFilterOperation;

public class DateLogOperation  extends DateFilterOperation<Log, LogFilter>{
	private LogFilter bf;
	
	@Override
	public void setFilter(LogFilter v) {
		this.bf = v;
	}
	
	@Override
	public List<Log> datefilter(List<Log> list) {
		if(bf.isByTimestamp()) 
			list = dateTimestamp(list);		
		return list;
	}
	
	private List<Log> dateTimestamp(List<Log> list) {
		switch (bf.getTimestampMethod()) {
		case EQUAL: return equalTimestamp(list);
		case RANGE: return rangeDateofBirth(list); 
		default:
			return list;
		}
	}


	private List<Log> equalTimestamp(List<Log> list) {
		List<Log> newlist = new ArrayList<Log>();
		for(Log b : list) {
			if(checkEqual(bf.getTimestamp(), b.getTstamp())) {
				newlist.add(b);
			}
		}
		return newlist;
	}
	
	private List<Log> rangeDateofBirth(List<Log> list) {
		List<Log> newList = new ArrayList<Log>();
		for(Log b : list) {
			if(checkRange(bf.getTimestamp(), bf.getTimestampTo(), b.getTstamp()))
				newList.add(b);
		}
		return newList;
	}
}
