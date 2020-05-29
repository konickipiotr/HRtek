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

class FilterProcessOtherTest {

	List<BasicView> list = new ArrayList<BasicView>();
	BasicFilters bf;
	FilterProcess<BasicView, BasicFilters> fprocess;

	@BeforeEach
	void setUp() throws Exception {
		list.add(new BasicView(1, 1l, "Jan", "Nowak", LocalDate.of(1990, 9, 20), "M", "ukraińskie", "111", "222", "333", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		list.add(new BasicView(0, 2l, "Alicja", "Hubuk", LocalDate.of(1985, 11, 5), "F", "białoruskie", "", "p444", "", "ZXY", "Fab2",null, null,null, null));
		list.add(new BasicView(1, 3l, "Michał", "Zykfryd", LocalDate.of(1993, 2, 10), "M", "polskie", "456", "", "bio888", "UWC", "Fab3",LocalDate.of(2020, 04, 20), LocalDate.of(2020, 04, 25),null, null));
		list.add(new BasicView(1, 4l, "Jan", "Kowalski", LocalDate.of(1990, 9, 20), "M", "ukraińskie", "111", "222", "321", "UWC", "DonYang", LocalDate.of(2020, 05, 01), LocalDate.of(2020, 05, 02), LocalDate.of(2020, 10, 01), LocalDate.of(2020, 05, 11)));
		bf = new BasicFilters();	
		
		fprocess = new FilterProcess<BasicView, BasicFilters>(bf)
						.setTextOpertation(new TextBasicOperation())
						.setDateOperation(new DateBasicOperation())
						.setOtherFiletrOperation(new OtherBasicOperation());
	}

	@Test
	void test_filterBySex() {
		bf.setBysex("all");
		List<BasicView> result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setBysex("M");
		result = fprocess.filter(list);
		assertEquals(3, result.size());
		
		bf.setBysex("F");
		result = fprocess.filter(list);
		assertEquals(1, result.size());
	}
	
	@Test
	void filterByCitizenship() {
		bf.setByCitizenship("");
		List<BasicView> result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByCitizenship(null);
		result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByCitizenship("ukraińskie");
		result = fprocess.filter(list);
		assertEquals(2, result.size());
		
		bf.setByCitizenship("polskie");
		result = fprocess.filter(list);
		assertEquals(1, result.size());
	}
	
	@Test
	void filterByCompany() {
		bf.setByCompany(null);
		List<BasicView> result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByCompany("");
		result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByCompany("UWC");
		result = fprocess.filter(list);
		assertEquals(3, result.size());
		
		bf.setByCompany("ZXY");
		result = fprocess.filter(list);
		assertEquals(1, result.size());
	}
	
	@Test
	void filterByFactory() {
		bf.setByFactory(null);
		List<BasicView> result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByFactory("");
		result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByFactory("DonYang");
		result = fprocess.filter(list);
		assertEquals(2, result.size());
		
		bf.setByFactory("Fab3");
		result = fprocess.filter(list);
		assertEquals(1, result.size());
	}
	
	@Test
	void filterByStatus() {
		bf.setByStatus("ALL");
		List<BasicView> result = fprocess.filter(list);
		assertEquals(4, result.size());
		
		bf.setByStatus("1");
		result = fprocess.filter(list);
		assertEquals(3, result.size());
		
		bf.setByStatus("0");
		result = fprocess.filter(list);
		assertEquals(1, result.size());

	}


}
