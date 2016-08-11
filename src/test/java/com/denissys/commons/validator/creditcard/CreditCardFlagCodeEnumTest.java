/**
 * Copyright (c) Elastic Path Software Inc., 2007
 */
package com.denissys.commons.validator.creditcard;

import org.junit.Assert;
import org.junit.Test;

import com.denissys.commons.validator.creditcard.CreditCardConstants;
import com.denissys.commons.validator.creditcard.CreditCardFlag;

/**
 * Tests of CreditCardFlag
 */
public class CreditCardFlagCodeEnumTest {

	/**
	 * Test method for {@link com.denissys.commons.validator.creditcard.CreditCardFlag#getCreditCardFlagCodeEnumByFlagName(java.lang.String)}.
	 */
	@Test
	public void getCreditCardAmex_shouldReturnsNull() {
		CreditCardFlag creditCardFlagCodeEnum = CreditCardFlag.getCreditCardFlagCodeEnumByFlagName("Amex");
		Assert.assertNull(creditCardFlagCodeEnum);
	}

	/**
	 * Test method for {@link com.denissys.commons.validator.creditcard.CreditCardFlag#getCreditCardFlagCodeEnumByFlagName(java.lang.String)}
	 * .
	 */
	@Test
	public void getCreditCardAmex_shouldReturnsTrue() {
		CreditCardFlag creditCardFlagCodeEnum = CreditCardFlag.getCreditCardFlagCodeEnumByFlagName(CreditCardConstants.AMEX);
		Assert.assertTrue(CreditCardFlag.AMEX.equals(creditCardFlagCodeEnum));
	}

}
