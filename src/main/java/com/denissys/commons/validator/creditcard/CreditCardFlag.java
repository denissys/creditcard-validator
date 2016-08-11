package com.denissys.commons.validator.creditcard;

/**
 * Enum with all flag code.
 */
public enum CreditCardFlag {
	AMEX(1L, CreditCardConstants.AMEX, new AmexValidator(), 4),
	VISA(2L, CreditCardConstants.VISA, new VisaValidator(), 3),
	MASTERCARD(4L, CreditCardConstants.MASTERCARD, new MastercardValidator(), 3),
	DISCOVER(8L, CreditCardConstants.DISCOVER, new DiscoverValidator(), 3),
	DINERSCLUB(16L, CreditCardConstants.DINERSCLUB, new DinersclubValidator(), 3),
	ELO(64L, CreditCardConstants.ELO, new EloValidator(), 3),
	HIPERCARD(32L, CreditCardConstants.HIPERCARD, new HipercardValidator(), 3);

	private long code;
	private String flagName;
	private CreditCardCheck validator;

	private int sizeCVV;

	private CreditCardFlag(final long code, final String flagName, final CreditCardCheck validator, final int sizeCVV) {
		this.code = code;
		this.flagName = flagName;
		this.validator = validator;
		this.sizeCVV = sizeCVV;
	}

	/**
	 * @return the sizeCVV
	 */
	public int getSizeCVV() {
		return sizeCVV;
	}


	public long getCode() {
		return code;
	}
	
	public String getFlagName() {
		return flagName;
	}

	public CreditCardCheck getValidator() {
		return validator;
	}
	
	public static boolean containsFlag(final String flagName) {
		boolean contains = false;
		CreditCardFlag creditCardFlagCodeEnum = CreditCardFlag.getCreditCardFlagCodeEnumByFlagName(flagName);
		if (creditCardFlagCodeEnum != null) {
			return true;
		}
		return contains;
	}

	public static CreditCardFlag getCreditCardFlagCodeEnumByFlagName(final String flagName) {
		CreditCardFlag creditCardFlagCodeEnum = null;
		if (flagName != null) {
			for (CreditCardFlag _creditCardFlagCodeEnum : CreditCardFlag.values()) {
				if (_creditCardFlagCodeEnum.getFlagName().toLowerCase().equalsIgnoreCase(flagName.toLowerCase())) {
					creditCardFlagCodeEnum = _creditCardFlagCodeEnum;
					break;
				}
			}
		}
		return creditCardFlagCodeEnum;

	}
}
