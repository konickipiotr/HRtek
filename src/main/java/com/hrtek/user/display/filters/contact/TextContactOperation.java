package com.hrtek.user.display.filters.contact;

import java.util.ArrayList;
import java.util.List;

import com.hrtek.user.display.filters.ContactFilters;
import com.hrtek.user.display.filters.TextFilterOperaton;
import com.hrtek.user.display.views.ContactViewDis;

public class TextContactOperation extends TextFilterOperaton<ContactViewDis, ContactFilters>{

	private ContactFilters bf;
	
	@Override
	public void setFilter(ContactFilters v) {
		this.bf = v;		
	}

	@Override
	public List<ContactViewDis> textprocess(List<ContactViewDis> list) {
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
	public List<ContactViewDis> textEmpty(List<ContactViewDis> list) {
		List<ContactViewDis> newlist = new ArrayList<ContactViewDis>();
		for(ContactViewDis bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(bv.getFirstname() == null || bv.getFirstname().isBlank()) newlist.add(bv); break;
			case LASTNAME: if(bv.getLastname() == null || bv.getLastname().isBlank()) newlist.add(bv); break;
			case NAME: if((bv.getFirstname() + " " + bv.getLastname()) == null || (bv.getFirstname() + " " + bv.getLastname()).isBlank()) newlist.add(bv); break;
			case PHONE: if(bv.getPhone() == null || bv.getPhone().isBlank()) newlist.add(bv); break;
			case EMAIL: if(bv.getEmail() == null || bv.getEmail().isBlank()) newlist.add(bv); break;
			case PLADDRESS: if(bv.getPladdress() == null || bv.getPladdress().isBlank()) newlist.add(bv); break;
			case PLPOSTCODE: if(bv.getPlpostcode() == null || bv.getPlpostcode().isBlank()) newlist.add(bv); break;
			case PLCITY: if(bv.getPlcity() == null || bv.getPlcity().isBlank()) newlist.add(bv); break;
			case ADDRESS: if(bv.getAddress() == null || bv.getAddress().isBlank()) newlist.add(bv); break;
			case POSTCODE: if(bv.getPostcode() == null || bv.getPostcode().isBlank()) newlist.add(bv); break;
			case CITY: if(bv.getCity() == null || bv.getCity().isBlank()) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ContactViewDis> texteauals(List<ContactViewDis> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<ContactViewDis> newlist = new ArrayList<ContactViewDis>();
		for(ContactViewDis bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(equals( (bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PHONE: if(equals(bv.getPhone(), text)) newlist.add(bv); break;
			case EMAIL: if(equals(bv.getEmail(), text)) newlist.add(bv); break;
			case PLADDRESS: if(equals(bv.getPladdress(), text)) newlist.add(bv); break;
			case PLPOSTCODE: if(equals(bv.getPlpostcode(), text)) newlist.add(bv); break;
			case PLCITY: if(equals(bv.getPlcity(), text)) newlist.add(bv); break;
			case ADDRESS: if(equals(bv.getAddress(), text)) newlist.add(bv); break;
			case POSTCODE: if(equals(bv.getPostcode(), text)) newlist.add(bv); break;
			case CITY: if(equals(bv.getCity(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ContactViewDis> textContains(List<ContactViewDis> list) {
		String text = bf.getTexttosearch().trim().toLowerCase();
		List<ContactViewDis> newlist = new ArrayList<ContactViewDis>();
		for(ContactViewDis bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(contains( bv.getFirstname(), text)) newlist.add(bv); break;
			case LASTNAME: if(contains(bv.getLastname(), text)) newlist.add(bv); break;
			case NAME: if(contains((bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PHONE: if(contains( bv.getPhone(), text)) newlist.add(bv); break;
			case EMAIL: if(contains( bv.getEmail(), text)) newlist.add(bv); break;
			case PLADDRESS: if(contains( bv.getPladdress(), text)) newlist.add(bv); break;
			case PLPOSTCODE: if(contains( bv.getPlpostcode(), text)) newlist.add(bv); break;
			case PLCITY: if(contains( bv.getPlcity(), text)) newlist.add(bv); break;
			case ADDRESS: if(contains( bv.getAddress(), text)) newlist.add(bv); break;
			case POSTCODE: if(contains( bv.getPostcode(), text)) newlist.add(bv); break;
			case CITY: if(contains( bv.getCity(), text)) newlist.add(bv); break;
			default:
				break;
			}
		}
		return newlist;
	}

	@Override
	public List<ContactViewDis> textFirstLetters(List<ContactViewDis> list) {
		String text = prepareTextLen(bf.getTexttosearch());
		List<ContactViewDis> newlist = new ArrayList<ContactViewDis>();
		for(ContactViewDis bv : list) {
		switch (bf.getSearchbyfield()) {
			case FIRSTNAME: if(equals(prepareTextLen(bv.getFirstname()), text)) newlist.add(bv); break;
			case LASTNAME: if(equals(prepareTextLen(bv.getLastname()), text)) newlist.add(bv); break;
			case NAME: if(equals(prepareTextLen(bv.getFirstname() + " " + bv.getLastname()), text)) newlist.add(bv); break;
			case PHONE: if(equals(prepareTextLen(bv.getPhone()), text)) newlist.add(bv); break;
			case EMAIL: if(equals(prepareTextLen(bv.getEmail()), text)) newlist.add(bv); break;
			case PLADDRESS: if(equals(prepareTextLen(bv.getPladdress()), text)) newlist.add(bv); break;
			case PLPOSTCODE: if(equals(prepareTextLen(bv.getPlpostcode()), text)) newlist.add(bv); break;
			case PLCITY: if(equals(prepareTextLen(bv.getPlcity()), text)) newlist.add(bv); break;
			case ADDRESS: if(equals(prepareTextLen(bv.getAddress()), text)) newlist.add(bv); break;
			case POSTCODE: if(equals(prepareTextLen(bv.getPostcode()), text)) newlist.add(bv); break;
			case CITY: if(equals(prepareTextLen(bv.getCity()), text)) newlist.add(bv); break;		
			
			default:
				break;
			}
		}
		return newlist;
	}

}
