package com.hrtek.admin.log;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.model.Log;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.views.BasicView;

public class OtherLogOperation extends  OtherFilterOperation<Log, LogFilter>{

	private LogFilter bf;
	
	@Override
	public	void setFilter(LogFilter v) {
		this.bf = v;		
	}

	@Override
	public List<Log> filterother(List<Log> list) {
		list = byPerson(list);
		list = byType(list);
		return list;
	}
	
	private List<Log> byPerson(List<Log> list) {
		if(bf.getByPerson() == null || bf.getByPerson().isBlank()) return list;
		List<Log> newList = new ArrayList<Log>();
		for(Log b : list) {
			if(b.getWho().equalsIgnoreCase(bf.getByPerson()))
				newList.add(b);
		}
		return newList;
	}
	
	private List<Log> byType(List<Log> list) {
		String type = bf.getByType();
		if(type == null || type.equals("ALL")) return list;
		
		List<Log> newList = new ArrayList<Log>();
		
		for(Log b : list) {
			if(b.getLogtype().toString().equals(bf.getByType()))
				newList.add(b);
		}
		return newList;
	}

}
