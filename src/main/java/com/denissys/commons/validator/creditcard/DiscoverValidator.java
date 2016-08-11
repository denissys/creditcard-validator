package com.denissys.commons.validator.creditcard;


public class DiscoverValidator extends CreditCardCheck {

	private static final String PREFIX = "6011,644,645,646,647,648,649,65";

	private static final int SIZE_CREDIT_CARD = 16;

	public DiscoverValidator() {
		super(CreditCardConstants.DISCOVER);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX, card);
		return foundPrefix && card.length() == SIZE_CREDIT_CARD;
	}

}
