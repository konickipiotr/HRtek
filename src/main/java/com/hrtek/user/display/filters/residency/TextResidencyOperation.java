package com.hrtek.user.display.filters.residency;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.ResidencyFilter;
import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.views.ResidencyView;

public class TextResidencyOperation extends TextFilterOperaton<ResidencyView, ResidencyFilter> {

	private ResidencyFilter bf;
	
	@Override
	public void setFilter(ResidencyFilter v) {
		this.bf = v;
		
	}

	@Override
	public List<ResidencyView> textprocess(List<ResidencyView> list) {
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
	public List<ResidencyView> textEmpty(List<ResidencyView> list) {
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case VISA: if(bv.getVisa() == null || bv.getVisa().isBlank()) newlist.add(bv); break;
			case PASZPORT: if((bv.getPaszport() == null || bv.getPaszport().isBlank()) || (bv.getBiopaszport() == null || bv.getBiopaszport().isBlank())) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ResidencyView> texteauals(List<ResidencyView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(contains(bv.getVisa(), text)) newlist.add(bv); break;
			case PASZPORT: if(contains(bv.getPaszport(), text) || contains(bv.getBiopaszport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ResidencyView> textContains(List<ResidencyView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(contains(bv.getVisa(), text)) newlist.add(bv); break;
			case PASZPORT: if(contains(bv.getPaszport(), text) || contains(bv.getBiopaszport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ResidencyView> textFirstLetters(List<ResidencyView> list) {
		String text = prepareTextLen(bf.getTexttosearch());
		List<ResidencyView> newlist = new ArrayList<ResidencyView>();
		for(ResidencyView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(equals(prepareTextLen(bv.getVisa()), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(prepareTextLen(bv.getPaszport()), text) || equals(prepareTextLen(bv.getBiopaszport()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}



}
