package com.hrtek.user.display.filters.dismiss;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.DismissedFilters;
import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.views.DismissedView;

public class TextDismissedOperation extends TextFilterOperaton<DismissedView, DismissedFilters> {

	private DismissedFilters wf;
	
	@Override
	public void setFilter(DismissedFilters v) {
		this.wf = v;
		
	}

	@Override
	public List<DismissedView> textprocess(List<DismissedView> list) {
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
	public List<DismissedView> textEmpty(List<DismissedView> list) {
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case STATEMENT: if(bv.getStatement() == null || bv.getStatement().isBlank()) newlist.add(bv); break;
			case PERMIT: if(bv.getPermit() == null || bv.getPermit().isBlank()) newlist.add(bv); break;
			case OTHER: if(bv.getOther() == null || bv.getOther().isBlank()) newlist.add(bv); break;
			case COMPANY: if(bv.getCompany() == null || bv.getCompany().isBlank()) newlist.add(bv); break;
			case FACTORY: if(bv.getFactory() == null || bv.getFactory().isBlank()) newlist.add(bv); break;
			case RECRUITER: if(bv.getRecruiter() == null || bv.getRecruiter().isBlank()) newlist.add(bv); break;
			case CITIZENSHIP: if(bv.getCitizenship() == null || bv.getCitizenship().isBlank()) newlist.add(bv); break;
			case PESEL: if(bv.getPesel() == null || bv.getPesel().isBlank()) newlist.add(bv); break;
			case PASZPORT: if(bv.getPassport() == null || bv.getPassport().isBlank()) newlist.add(bv); break;
			case BIOPASZPORT: if(bv.getBiopassport() == null || bv.getBiopassport().isBlank()) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DismissedView> texteauals(List<DismissedView> list) {
		String text = wf.getTexttosearch().trim().toLowerCase();
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(equals( bv.getStatement(), text)) newlist.add(bv); break;
			case PERMIT: if(equals(bv.getPermit(), text)) newlist.add(bv); break;
			case OTHER: if(equals(bv.getOther(), text)) newlist.add(bv); break;
			case COMPANY: if(equals(bv.getCompany(), text)) newlist.add(bv); break;
			case FACTORY: if(equals(bv.getFactory(), text)) newlist.add(bv); break;
			case RECRUITER: if(equals(bv.getRecruiter(), text)) newlist.add(bv); break;
			case CITIZENSHIP: if(equals(bv.getCitizenship(), text)) newlist.add(bv); break;
			case PESEL: if(equals(bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(bv.getPassport(), text)) newlist.add(bv); break;
			case BIOPASZPORT: if(equals(bv.getBiopassport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DismissedView> textContains(List<DismissedView> list) {
		String text = wf.getTexttosearch().trim().toLowerCase();
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(contains(bv.getStatement(), text)) newlist.add(bv); break;
			case PERMIT: if(contains(bv.getPermit(), text)) newlist.add(bv); break;
			case OTHER: if(contains( bv.getOther(), text)) newlist.add(bv); break;
			case COMPANY: if(contains(bv.getCompany(), text)) newlist.add(bv); break;
			case FACTORY: if(contains(bv.getFactory(), text)) newlist.add(bv); break;
			case RECRUITER: if(contains(bv.getRecruiter(), text)) newlist.add(bv); break;
			case CITIZENSHIP: if(contains(bv.getCitizenship(), text)) newlist.add(bv); break;
			case PESEL: if(contains(bv.getPesel(), text)) newlist.add(bv); break;
			case PASZPORT: if(contains(bv.getPassport(), text)) newlist.add(bv); break;
			case BIOPASZPORT: if(contains(bv.getBiopassport(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<DismissedView> textFirstLetters(List<DismissedView> list) {
		String text = prepareTextLen(wf.getTexttosearch());
		List<DismissedView> newlist = new ArrayList<DismissedView>();
		for(DismissedView bv : list) {
		switch (wf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case STATEMENT: if(equals(prepareTextLen(bv.getStatement()), text)) newlist.add(bv); break;
			case PERMIT: if(equals(prepareTextLen(bv.getPermit()), text)) newlist.add(bv); break;
			case OTHER: if(equals(prepareTextLen(bv.getOther()), text)) newlist.add(bv); break;
			case COMPANY: if(equals(prepareTextLen(bv.getCompany()), text)) newlist.add(bv); break;
			case FACTORY: if(equals(prepareTextLen(bv.getFactory()), text)) newlist.add(bv); break;
			case RECRUITER: if(equals(prepareTextLen(bv.getRecruiter()), text)) newlist.add(bv); break;
			case CITIZENSHIP: if(equals(prepareTextLen(bv.getCitizenship()), text)) newlist.add(bv); break;
			case PESEL: if(equals(prepareTextLen(bv.getPesel()), text)) newlist.add(bv); break;
			case PASZPORT: if(equals(prepareTextLen(bv.getPassport()), text)) newlist.add(bv); break;
			case BIOPASZPORT: if(equals(prepareTextLen(bv.getBiopassport()), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

}
