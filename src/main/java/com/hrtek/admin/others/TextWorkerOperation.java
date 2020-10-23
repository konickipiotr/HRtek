package com.hrtek.admin.others;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.TextFilterOperaton;


public class TextWorkerOperation extends TextFilterOperaton<WorkerView, WorkerFilters> {

	private WorkerFilters bf;
	
	@Override
	public void setFilter(WorkerFilters v) {
		this.bf = v;	
	}
	
	@Override
	public List<WorkerView> textprocess(List<WorkerView> list) {
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
	public List<WorkerView> textEmpty(List<WorkerView> list) {
		List<WorkerView> newlist = new ArrayList<WorkerView>();
		for(WorkerView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case PESEL: if(bv.getPesel() == null || bv.getPesel().isBlank()) newlist.add(bv); break;
			case PASZPORT: if((bv.getPassport() == null || bv.getPassport().isBlank()) || (bv.getPassport() == null || bv.getPassport().isBlank())) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public	List<WorkerView> texteauals(List<WorkerView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<WorkerView> newlist = new ArrayList<WorkerView>();
		for(WorkerView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(equals( bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(bv.getPassport(), text) || equals(bv.getPassport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public	List<WorkerView> textContains(List<WorkerView> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<WorkerView> newlist = new ArrayList<WorkerView>();
		for(WorkerView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(contains(bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(contains(bv.getPassport(), text) || contains(bv.getPassport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}


	@Override
	public	List<WorkerView> textFirstLetters(List<WorkerView> list) {
		String text = prepareTextLen(bf.getTexttosearch());
		List<WorkerView> newlist = new ArrayList<WorkerView>();
		for(WorkerView bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PESEL: if(equals(prepareTextLen(bv.getPesel()), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(prepareTextLen(bv.getPassport()), text) || equals(prepareTextLen(bv.getPassport()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}
}
