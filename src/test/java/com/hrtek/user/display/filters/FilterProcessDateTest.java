package com.hrtek.user.display.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hrtek.user.display.filters.basic.DateBasicOperation;
import com.hrtek.user.display.filters.basic.OtherBasicOperation;
import com.hrtek.user.display.filters.basic.TextBasicOperation;
import com.hrtek.user.display.views.BasicView;

class FilterProcessDateTest {

	List<BasicView> list = new ArrayList<BasicView>();
	BasicFilters bf;
	FilterProcess<BasicView, BasicFilters> fprocess;

	@BeforeEach
	void setUp() throws Exception {
		list.add(new BasicView(1, 1l, "Jan", "Nowak", LocalDate.of(1990, 9, 20), "M", "ukraina", "111", "222", "333", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		list.add(new BasicView(0, 2l, "Alicja", "Hubuk", LocalDate.of(1985, 11, 5), "F", "białoruś", "", "p444", "", "ZXY", "Fab2",null, null,null, null));
		list.add(new BasicView(1, 3l, "Michał", "Zykfryd", LocalDate.of(1993, 2, 10), "M", "ukraina", "456", "", "bio888", "UWC", "Fab3",LocalDate.of(2020, 04, 20), LocalDate.of(2020, 04, 25),null, null));
		list.add(new BasicView(1, 4l, "Jan", "Kowalski", LocalDate.of(1990, 9, 20), "M", "ukraina", "111", "222", "321", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		bf = new BasicFilters();
		bf.setBytext(false);
		
		fprocess = new FilterProcess<BasicView, BasicFilters>(bf)
						.setTextOpertation(new TextBasicOperation())
						.setDateOperation(new DateBasicOperation())
						.setOtherFiletrOperation(new OtherBasicOperation());
	}

	@Test
	void whenDataOfBirthCheckboxisNotChecked() {
		bf.setBydateofbirth(false);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(4, result.size());
	}
	
	@Test
	void whenDateofBirthIsNullDoNothing() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.EQUAL);
		bf.setDateofbirth(null);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(0, result.size());
	}
	
	@Test
	void whenDateofBirthIsapropriateProper() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.EQUAL);
		bf.setDateofbirth(LocalDate.of(1993, 2, 10));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals("Zykfryd", result.get(0).getLastname());
	}
	
	@Test
	void whenDateofBirthIsapropriateProperAndReturnMoreThanOneRecord() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.EQUAL);
		bf.setDateofbirth(LocalDate.of(1990, 9, 20));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(2, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Kowalski", result.get(1).getLastname());
	}
	
	@Test
	void dateofbirthEqula_() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.EQUAL);
		bf.setDateofbirth(LocalDate.of(1960, 9, 20));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(0, result.size());
	}
	
	@Test
	void dateofbirthRange_appropriateValues() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.RANGE);
		bf.setDateofbirth(LocalDate.of(1990, 9, 19));
		bf.setDateofbirthTo(LocalDate.of(1993, 2, 11));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(3, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Zykfryd", result.get(1).getLastname());
		assertEquals("Kowalski", result.get(2).getLastname());
	}
	
	@Test
	void dateofbirthRange_minusPluseOneDay() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.RANGE);
		bf.setDateofbirth(LocalDate.of(1990, 9, 20));
		bf.setDateofbirthTo(LocalDate.of(1993, 2, 10));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(0, result.size());
	}

	@Test
	void dateofbirthRange_whenDateFromIsNull() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.RANGE);
		bf.setDateofbirth(null);
		bf.setDateofbirthTo(LocalDate.of(1992, 05, 10));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(3, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Hubuk", result.get(1).getLastname());
		assertEquals("Kowalski", result.get(2).getLastname());
	}
	
	@Test
	void dateofbirthRange_whenDateToIsNull() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.RANGE);
		bf.setDateofbirth(LocalDate.of(1986, 05, 10));
		bf.setDateofbirthTo(null);
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(3, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
		assertEquals("Zykfryd", result.get(1).getLastname());
		assertEquals("Kowalski", result.get(2).getLastname());
	}
	
	@Test
	void dateofbirthLess26_whenDateOfBirthIsInRange() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.LESS26);
		bf.setDateofbirthTo(null);
		
		list.clear();
		list.add(new BasicView(1, 1l, "Jan", "Nowak", LocalDate.of(2000, 9, 20), "M", "ukraina", "111", "222", "333", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(1, result.size());
		assertEquals("Nowak", result.get(0).getLastname());
	}
	
	@Test
	void dateofbirthLess26_whenDateOfBirthOutOfRange() {
		bf.setBydateofbirth(true);
		bf.setDateofbirthMethod(SearchingMethod.LESS26);
		bf.setDateofbirthTo(null);
		
		list.clear();
		list.add(new BasicView(1, 1l, "Jan", "Nowak", LocalDate.of(1980, 9, 20), "M", "ukraina", "111", "222", "333", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		
		List<BasicView> result = fprocess.filter(list);
		
		assertEquals(0, result.size());
	}

}
