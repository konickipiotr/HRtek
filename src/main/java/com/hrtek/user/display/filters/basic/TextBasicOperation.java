package com.hrtek.user.display.filters.basic;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.views.BasicView;

public class TextBasicOperation extends TextFilterOperaton<BasicView, BasicFilters> {

	private BasicFilters bf;
	
	@Override
	public void setFilter(BasicFilters v) {
		this.bf = v;	
	}
	
	@Override
	public List<BasicView> textprocess(List<BasicView> list) {
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
	public List<BasicView> textEmpty(List<BasicView> list) {
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case PESEL: if(bv.getPesel() == null || bv.getPesel().isBlank()) newlist.add(bv); break;
			case PASZPORT: if((bv.getPaszport() == null || bv.getPaszport().isBlank()) || (bv.getBiopaszport() == null || bv.getBiopaszport().isBlank())) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public	List<BasicView> texteauals(List<BasicView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(equals( bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(bv.getPaszport(), text) || equals(bv.getBiopaszport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public	List<BasicView> textContains(List<BasicView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(contains(bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(contains(bv.getPaszport(), text) || contains(bv.getBiopaszport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}


	@Override
	public	List<BasicView> textFirstLetters(List<BasicView> list) {
		String text = prepareTextLen(bf.getTexttosearch());
		List<BasicView> newlist = new ArrayList<BasicView>();
		for(BasicView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(equals(prepareTextLen(bv.getPesel()), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(prepareTextLen(bv.getPaszport()), text) || equals(prepareTextLen(bv.getBiopaszport()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}
}
