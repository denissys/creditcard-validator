package com.denissys.commons.validator.creditcard;


public class HipercardValidator extends CreditCardCheck {

	private static final String PREFIX = "606282,637095";

	private static final int SIZE_CREDIT_CARD = 16;

	public HipercardValidator() {
		super(CreditCardConstants.HIPERCARD);
	}

	public boolean matches(String card) {
		boolean foundPrefix = validatePrefixCreditCard(PREFIX, card);
		return (card.length() == SIZE_CREDIT_CARD && foundPrefix);
	}


	public boolean luhnCheck(String cardNumber) throws NumberFormatException {

		if (cardNumber.length() == 16) {
			return true;
		}

		int dv = 0;

		for (int i = 0; i < 8; i++) {
			int n = Integer.parseInt(cardNumber.substring(i, i + 1));
			dv += n * (9 - i);
		}

		if (!checkDigit(dv, Integer.parseInt(cardNumber.substring(8, 9))))
			return false;

		dv = 0;

		for (int i = 0; i < 9; i++) {
			int n = Integer.parseInt(cardNumber.substring(i, i + 1));

			if (i == 0 || i == 8)
				dv += n * 2;
			else if (i <= 7)
				dv += n * (10 - i);
		}

		if (!checkDigit(dv, Integer.parseInt(cardNumber.substring(9, 10))))
			return false;

		dv = 0;

		for (int i = 0; i < 12; i++) {

			int n = Integer.parseInt(cardNumber.substring(i, i + 1));

			if (i == 0 || i == 10)
				dv += n * 3;
			else if (i == 1 || i == 11)
				dv += n * 2;
			else if (i != 8 && i != 9)
				dv += n * (11 - i);
		}

		if (!checkDigit(dv, Integer.parseInt(cardNumber.substring(12, 13))))
			return false;

		return true;
	}

	private boolean checkDigit(int dv, int cardDigit) {

		int r = dv % 11;

		dv = r <= 1 ? 0 : 11 - r;

		return (dv == cardDigit);

	}
}
