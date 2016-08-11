package com.denissys.commons.validator.creditcard;


public class EloValidator extends CreditCardCheck {

	private static final String PREFIX_ALL = "636368,438935,504175,451416,636297,627780,5067,4576,4011,";

	private static final int SIZE_CREDIT_CARD = 16;

	public EloValidator() {
		super(CreditCardConstants.ELO);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX_ALL, card);
		return foundPrefix && card.length() == SIZE_CREDIT_CARD;
	}

}
