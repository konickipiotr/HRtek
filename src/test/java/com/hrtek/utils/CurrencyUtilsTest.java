package com.hrtek.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurrencyUtilsTest {

	CurrencyUtils util = new CurrencyUtils();
	
	@Test
	void forSingleNumber() {
		double val = 1.0;
		
		String resutl = util.valueToText(val);
		
		assertEquals("jeden złotych", resutl);
	}

}
