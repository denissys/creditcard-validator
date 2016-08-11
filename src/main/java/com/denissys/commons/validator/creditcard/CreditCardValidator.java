package com.denissys.commons.validator.creditcard;

import java.util.ArrayList;
import java.util.Collection;

import com.denissys.commons.utils.NumberUtils;

/**
 * Validation Class Credit Card.
 */
public class CreditCardValidator {

	private Collection<CreditCardCheck> cardTypes;

	public CreditCardValidator() {
		cardTypes = new ArrayList<CreditCardCheck>();
		for (CreditCardFlag creditCardFlagCodeEnum : CreditCardFlag.values()) {
			cardTypes.add(creditCardFlagCodeEnum.getValidator());
		}
	}

	public boolean isValid(final String cardNumber, final CreditCardFlag cardType) {

		if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
			return false;
		}

		for (CreditCardCheck cc : cardTypes) {
			if (cc.getCreditCardtype().equalsIgnoreCase(cardType.getFlagName())) {
				return (cc.matches(cardNumber) && cc.luhnCheck(cardNumber));
			}
		}
		return false;
	}

	public boolean validateCVV(final String cvv, final CreditCardFlag flagCodeEnum) {
		boolean isOk = false;
		if (flagCodeEnum != null && cvv != null && NumberUtils.isNumeric(cvv)) {
			int lengthCvv = cvv.length();
			if (flagCodeEnum.getSizeCVV() == lengthCvv) {
				isOk = true;
			}
		}
		return isOk;
	}

	public CreditCardFlag getFlagCodeEnumByValidCreditCard(final String cardNumber) {
		CreditCardFlag flagEnum = null;

		for (CreditCardFlag flagObject : CreditCardFlag.values()) {
			boolean isOk = isValid(cardNumber, flagObject);
			if (isOk) {
				flagEnum = flagObject;
				break;
			}
		}
		return flagEnum;
	}
}

