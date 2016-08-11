package com.denissys.commons.validator.creditcard;

/**
 * Class Credit Card Amex (American Express)
 */
public class AmexValidator extends CreditCardCheck {

	private static final String PREFIX = "34,37,";

	private static final int SIZE_CREDIT_CARD = 15;

	public AmexValidator() {
		super(CreditCardConstants.AMEX);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX, card);
		return foundPrefix && card.length() == SIZE_CREDIT_CARD;
	}

}
