package com.hrtek.user.display.filters.data;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DataFilters;
import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.views.DataView;

public class TextDataOperation extends TextFilterOperaton<DataView, DataFilters> {

	private DataFilters bf;
	
	@Override
	public void setFilter(DataFilters v) {
		this.bf = v;	
	}

	@Override
	public List<DataView> textprocess(List<DataView> list) {
		if(bf.isBytext()) {
			switch (bf.getSearchingMethod()) {
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
	public List<DataView> textEmpty(List<DataView> list) {
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DataView> texteauals(List<DataView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DataView> textContains(List<DataView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DataView> textFirstLetters(List<DataView> list) {
		String text = prepareTextLen(bf.getTexttosearch());
		List<DataView> newlist = new ArrayList<DataView>();
		for(DataView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}
}
