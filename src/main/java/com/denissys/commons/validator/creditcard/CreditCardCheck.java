package com.denissys.commons.validator.creditcard;

public abstract class CreditCardCheck implements CreditCardType {

	private String creditCardType;

	protected CreditCardCheck(String creditCardType) {
		super();
		this.creditCardType = creditCardType;
	}

	public boolean luhnCheck(final String cardNumber) {
		int digits = cardNumber.length();
		int oddOrEven = digits & 1;
		long sum = 0L;
		for (int count = 0; count < digits; count++) {
			int digit = 0;
			try {
				digit = Integer.parseInt(cardNumber.charAt(count) + "");
			} catch (NumberFormatException e) {
				return false;
			}
			if ((count & 1 ^ oddOrEven) == 0) {
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}
			sum += digit;
		}
		return sum != 0L ? sum % 10L == 0L : false;
	}

	public String getCreditCardtype() {
		return creditCardType;
	}

	public boolean validatePrefixCreditCard(String PREFIX, String card) {
		boolean foundPrefix = false;

		if (PREFIX == null || card == null) {
			return false;
		}

		String prefixList[] = PREFIX.split(",");

		for (String _prefix : prefixList) {
			if (card.startsWith(_prefix)) {
				foundPrefix = true;
				break;
			}
		}
		return foundPrefix;
	}

}