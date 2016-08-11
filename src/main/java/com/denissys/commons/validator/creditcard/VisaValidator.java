package com.denissys.commons.validator.creditcard;


public class VisaValidator extends CreditCardCheck {

	private static final String PREFIX = "4";

	private static final int SIZE_CREDIT_CARD_OLD = 13;

	private static final int SIZE_CREDIT_CARD = 16;

	public VisaValidator() {
		super(CreditCardConstants.VISA);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX, card);
		return foundPrefix && (card.length() == SIZE_CREDIT_CARD || card.length() == SIZE_CREDIT_CARD_OLD);
	}

}
