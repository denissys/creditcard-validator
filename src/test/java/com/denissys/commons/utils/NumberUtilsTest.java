/**
 * Copyright (c) Elastic Path Software Inc., 2007
 */
package com.denissys.commons.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.denissys.commons.utils.NumberUtils;

public class NumberUtilsTest {

	@Test
	public void extractNumber_StringNumberSpace_ShouldReturn777String() {
		String data = "777 777 777";
		String dataResult = "777777777";
		assertEquals(dataResult, NumberUtils.extractNumber(data, String.class));
	}

	@Test
	public void extractNumber_StringNumberDot_ShouldReturn777String() {
		String data = "777.777.777";
		String dataResult = "777777777";
		assertEquals(dataResult, NumberUtils.extractNumber(data, String.class));
	}

	@Test
	public void extractNumber_StringNumberHyphen_ShouldReturn777String() {
		String data = "777-777-777";
		String dataResult = "777777777";
		assertEquals(dataResult, NumberUtils.extractNumber(data, String.class));
	}

	@Test
	public void extractNumber_StringNumberText_ShouldReturn777String() {
		String data = "777x777x777";
		String dataResult = "777777777";
		assertEquals(dataResult, NumberUtils.extractNumber(data, String.class));
	}

	@Test
	public void extractNumber_StringNumberText_ShouldReturn777Integer() {
		String data = "777x777x777";
		Integer dataResult = 777777777;
		Integer result = (Integer) NumberUtils.extractNumber(data, Integer.class);
		assertEquals(dataResult, result);
	}

	@Test
	public void extractNumber_StringNumberText_ShouldReturn777Long() {
		String data = "777x777x777";
		Long dataResult = 777777777l;
		Long result = (Long) NumberUtils.extractNumber(data, Long.class);
		assertEquals(dataResult, result);
	}

	@Test
	public void isNumeric_StringNumberValid_ShouldReturnTrue() {
		String data = "777777777";
		assertTrue(NumberUtils.isNumeric(data));
	}

	@Test
	public void isNumeric_StringNumberInvalid_ShouldReturnFalse() {
		String data = "777777777x";
		assertFalse(NumberUtils.isNumeric(data));
	}
}
