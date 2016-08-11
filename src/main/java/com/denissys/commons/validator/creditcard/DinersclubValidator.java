package com.denissys.commons.validator.creditcard;


public class DinersclubValidator extends CreditCardCheck {

	private static final String PREFIX_ALL = "36,38,54,55,300,301,302,303,304,305,";

	private static final int SIZE_CREDIT_CARD = 16;
	private static final int SIZE_CREDIT_CARD_OLD = 14;


	public DinersclubValidator() {
		super(CreditCardConstants.DINERSCLUB);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX_ALL, card);
		return foundPrefix && (card.length() == SIZE_CREDIT_CARD || card.length() == SIZE_CREDIT_CARD_OLD);
	}

}
