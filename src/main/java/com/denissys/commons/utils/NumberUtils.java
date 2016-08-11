/**
 * Copyright (c) Elastic Path Software Inc., 2007
 */
package com.denissys.commons.utils;

import java.math.BigDecimal;

/**
 * Class with all methods to parse and convert numbers/String to:
 * - Numbers format string.
 * - Numbers
 * 
 */
public class NumberUtils {

	public static <T> Object extractNumber(String data, Class<?> clazz) {
		try{
			if (data != null) {
				data = data.replaceAll("\\D+", "");
				return normalize(data, clazz);
			}
			return data;
			
		} catch (ClassCastException e) {
			return null;
		}

	}

	private static <T> Object normalize(String data, Class<?> clazz) {
		if (clazz.equals(String.class)) {
			return data;
		} else if (clazz.equals(Byte.class)) {
			return (Byte) (isHexNumber(data) ? Byte.decode(data) : Byte.valueOf(data));
		} else if (clazz.equals(Short.class)) {
			return (Short) (isHexNumber(data) ? Short.decode(data) : Short.valueOf(data));
		} else if (clazz.equals(Integer.class)) {
			return (Integer) (isHexNumber(data) ? Integer.decode(data) : Integer.valueOf(data));
		} else if (clazz.equals(Long.class)) {
			return (Long) (isHexNumber(data) ? Long.decode(data) : Long.valueOf(data));
		 } else
		if (clazz.equals(Float.class)) {
			return (Float) Float.valueOf(data);
		} else if (clazz.equals(Double.class)) {
			return (Double) Double.valueOf(data);
		} else if (clazz.equals(BigDecimal.class) || clazz.equals(Number.class)) {
			return (BigDecimal) new BigDecimal(data);
		} else {
			throw new IllegalArgumentException("Cannot convert String [" + data + "] to target class [" + clazz.getName() + "]");
		}
	}

	private static boolean isHexNumber(String value) {
		int index = (value.startsWith("-") ? 1 : 0);
		return (value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith("#", index));
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
