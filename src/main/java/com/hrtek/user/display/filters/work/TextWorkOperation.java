package com.hrtek.user.display.filters.work;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.filters.WorkFilters;
import com.hrtek.user.display.views.WorkersView;

public class TextWorkOperation extends TextFilterOperaton<WorkersView, WorkFilters> {

	private WorkFilters wf;
	
	@Override
	public void setFilter(WorkFilters v) {
		this.wf = v;
		
	}

	@Override
	public List<WorkersView> textprocess(List<WorkersView> list) {
		if(wf.isBytext()) {
			switch (wf.getSearchingMethod()) {
			case EQUAL: return texteauals(list);
			case CONTAINS: return textContains(list);
			case EMPTY: return textEmpty(list);
			case FIRSTS: return textFirstLetters(list);
			default:
				return list;
			}
		}
		return list;
	}

	@Override
	public List<WorkersView> textEmpty(List<WorkersView> list) {
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case STATEMENT: if(bv.getStatement() == null || bv.getStatement().isBlank()) newlist.add(bv); break;
			case PERMIT: if(bv.getPermit() == null || bv.getPermit().isBlank()) newlist.add(bv); break;
			case OTHER: if(bv.getOther() == null || bv.getOther().isBlank()) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<WorkersView> texteauals(List<WorkersView> list) {
		String text = wf.getTexttosearch().trim().toLowerCase();
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(equals( bv.getStatement(), text)) newlist.add(bv); break;
			case PERMIT: if(equals(bv.getPermit(), text)) newlist.add(bv); break;
			case OTHER: if(equals(bv.getOther(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<WorkersView> textContains(List<WorkersView> list) {
		String text = wf.getTexttosearch().trim().toLowerCase();
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(contains(bv.getStatement(), text)) newlist.add(bv); break;
			case PERMIT: if(contains(bv.getPermit(), text)) newlist.add(bv); break;
			case OTHER: if(contains( bv.getOther(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<WorkersView> textFirstLetters(List<WorkersView> list) {
		String text = prepareTextLen(wf.getTexttosearch());
		List<WorkersView> newlist = new ArrayList<WorkersView>();
		for(WorkersView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(equals(prepareTextLen(bv.getStatement()), text)) newlist.add(bv); break;
			case PERMIT: if(equals(prepareTextLen(bv.getPermit()), text)) newlist.add(bv); break;
			case OTHER: if(equals(prepareTextLen(bv.getOther()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}
}
