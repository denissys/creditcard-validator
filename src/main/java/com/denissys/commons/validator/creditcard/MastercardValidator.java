package com.denissys.commons.validator.creditcard;


public class MastercardValidator extends CreditCardCheck {

	private static final String PREFIX = "51,52,53,54,55,";

	private static final int SIZE_CREDIT_CARD = 16;

	public MastercardValidator() {
		super(CreditCardConstants.MASTERCARD);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX, card);
		return foundPrefix && card.length() == SIZE_CREDIT_CARD;
	}

}
