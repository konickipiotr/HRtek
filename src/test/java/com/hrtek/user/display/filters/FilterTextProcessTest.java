package com.hrtek.user.display.filters;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.display.filters.basic.DateBasicOperation;
import com.hrtek.user.display.filters.basic.TextBasicOperation;
import com.hrtek.user.display.views.BasicView;


class FilterTextProcessTest {
	
	List<BasicView> list = new ArrayList<BasicView>();
	BasicFilters bf = new BasicFilters();
	FilterProcess<BasicView, BasicFilters> fprocess;

	@BeforeEach
	void setUp() throws Exception {
		list.add(new BasicView(1, 1l, "Jan", "Nowak", LocalDate.of(1990, 9, 20), "M", "ukraina", "111", "222", "333", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		list.add(new BasicView(0, 2l, "Alicja", "Hubuk", LocalDate.of(1985, 11, 5), "F", "białoruś", "", "p444", "", "ZXY", "Fab2",null, null,null, null));
		list.add(new BasicView(1, 3l, "Michał", "Zykfryd", LocalDate.of(1993, 2, 10), "M", "ukraina", "456", "", "bio888", "UWC", "Fab3",LocalDate.of(2020, 04, 20), LocalDate.of(2020, 04, 25),null, null));
		list.add(new BasicView(1, 4l, "Jan", "Kowalski", LocalDate.of(1990, 9, 20), "M", "ukraina", "111", "222", "321", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		bf.setBytext(true);
		fprocess = new FilterProcess<BasicView, BasicFilters>(bf)
							.setTextOpertation(new TextBasicOperation())
							.setDateOperation(new DateBasicOperation());
	}

	@Test
	void ifFieldByTextisNotcheckedreturnTheSameList() {
		
		bf.setBytext(false);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(list.size(), result.size());
		assertEquals(list.get(0).getFirstname(), list.get(0).getFirstname());
		assertEquals(list.get(2).getFirstname(), list.get(2).getFirstname());
	}
	
	@Test
	void filterByTextByEqualWithEmptyString() {

		bf.setSearchingMethod(SearchingMethod.EQUAL);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		bf.setTexttosearch("");
		
		List<BasicView> result =fprocess.filter(list);
		
		assertEquals(0, result.size());
	}
	
	@Test
	void filterByTextByEqual() {
		bf.setSearchingMethod(SearchingMethod.EQUAL);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		String text = "Alicja";
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals(text, result.get(0).getFirstname());
		
		
		bf.setSearchbyfield(SearchByField.LASTNAME);
		text = "Zykfryd";
		bf.setTexttosearch(text);
		
		result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals(text, result.get(0).getLastname());
		
		bf.setSearchbyfield(SearchByField.NAME);
		text = "Jan Kowalski";
		bf.setTexttosearch(text);
		
		result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals("Jan", result.get(0).getFirstname());
		assertEquals("Kowalski", result.get(0).getLastname());
		
		bf.setSearchbyfield(SearchByField.PESEL);
		text = "111";
		bf.setTexttosearch(text);
		
		result = fprocess.filter(list);
		
		assertEquals(2, result.size());
		assertEquals(text, result.get(0).getPesel());
		assertEquals(text, result.get(0).getPesel());
		
		//***************************
		
		bf.setSearchbyfield(SearchByField.PASZPORT);
		text = "p444";
		bf.setTexttosearch(text);
		
		result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals(text, result.get(0).getPaszport());
		
		//***************************
		
				bf.setSearchbyfield(SearchByField.PASZPORT);
				text = "333";
				bf.setTexttosearch(text);
				
				result = fprocess.filter(list);
				
				assertEquals(1, result.size());
				assertEquals(text, result.get(0).getBiopaszport());
	}
	
	@Test
	void findMoreThanOneRecord() {
		bf.setSearchingMethod(SearchingMethod.EQUAL);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		String text = "Jan";
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(2, result.size());
		assertEquals("Jan", result.get(0).getFirstname());
		assertEquals("Jan", result.get(1).getFirstname());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Kowalski", result.get(1).getLastname());
	}
	
	@Test
	void searchByTextByContains() {
		bf.setSearchingMethod(SearchingMethod.CONTAINS);
		bf.setSearchbyfield(SearchByField.LASTNAME);
		String text = "owa"; 
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(2, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Kowalski", result.get(1).getLastname());
	}
	
	void searchByTextByContainsEmpty() {
		bf.setSearchingMethod(SearchingMethod.CONTAINS);
		bf.setSearchbyfield(SearchByField.LASTNAME);
		String text = "";
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(3, result.size());
	}
	
	@Test
	void searchByTextByEmpty() {
		bf.setSearchingMethod(SearchingMethod.EMPTY);
		bf.setSearchbyfield(SearchByField.PESEL);
		String text = null;
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals("Alicja", result.get(0).getFirstname());
	}
	
	@Test
	void searchByTextByEmptyNotFound() {
		bf.setSearchingMethod(SearchingMethod.EMPTY);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(0, result.size());
	}
	
	@Test
	void searchByTextByNumLetters() {
		list.add(new BasicView(0, 5l, "Alina", "Kamień", LocalDate.of(1985, 11, 5), "F", "białoruś", "", "p444", "", "ZXY", "Fab2",null, null,null, null));
		list.add(new BasicView(0, 6l, "We", "Hubuk", LocalDate.of(1985, 11, 5), "F", "białoruś", "", "p444", "", "ZXY", "Fab2",null, null,null, null));

		bf.setSearchingMethod(SearchingMethod.FIRSTS);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		GlobalSettings.numoffirstletters = 3;
		String text = "ali";
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(2, result.size());
		assertEquals("Hubuk", result.get(0).getLastname());
		assertEquals("Kamień", result.get(1).getLastname());
		
	}
	
	@Test
	void searchByTextByNumLettersNameShorterThenRequire() {
		list.add(new BasicView(0, 6l, "We", "Hubuk", LocalDate.of(1985, 11, 5), "F", "białoruś", "", "p444", "", "ZXY", "Fab2",null, null,null, null));

		bf.setSearchingMethod(SearchingMethod.FIRSTS);
		bf.setSearchbyfield(SearchByField.FIRSTNAME);
		GlobalSettings.numoffirstletters = 3;
		String text = "ali";
		bf.setTexttosearch(text);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals("Hubuk", result.get(0).getLastname());
	}

}

