package com.hrtek.admin.log;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.model.Log;
import com.hrtek.user.display.filters.TextFilterOperaton;

public class TextLogOperation extends TextFilterOperaton<Log, LogFilter>{

	private LogFilter bf;
	
	@Override
	public void setFilter(LogFilter v) {
		this.bf = v;	
	}
	
	@Override
	public List<Log> textprocess(List<Log> list) {
		if(bf.isBytext()) {
			String text = bf.getTexttosearch().trim().toLowerCase();
			List<Log> newlist = new ArrayList<Log>();
			for(Log bv : list) {
				if(contains( bv.getMessage(), text)) newlist.add(bv);
			}
			list = newlist;
		}
		return list;
	}

	@Override
	public List<Log> textEmpty(List<Log> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> texteauals(List<Log> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> textContains(List<Log> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> textFirstLetters(List<Log> list) {
		// TODO Auto-generated method stub
		return null;
	}
}
