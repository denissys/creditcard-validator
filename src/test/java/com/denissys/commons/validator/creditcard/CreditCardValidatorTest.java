package com.denissys.commons.validator.creditcard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.denissys.commons.validator.creditcard.CreditCardConstants;
import com.denissys.commons.validator.creditcard.CreditCardFlag;
import com.denissys.commons.validator.creditcard.CreditCardValidator;

public class CreditCardValidatorTest {

	private static final String AMEX_NUMBER_VALID1 = "371449635398431";
	private static final String AMEX_NUMBER_VALID2 = "377726080567410";

	private static final String VISA_NUMBER_VALID_13DIGIT = "4556078446397";
	private static final String VISA_NUMBER_VALID1 = "4315071920926550";
	private static final String VISA_NUMBER_VALID2 = "4776856274822815";

	private static final String MASTERCARD_NUMBER_VALID_PREF52 = "5215043295673404";

	private static final String MASTERCARD_NUMBER_VALID_PREF53 = "5338154966945211";
	private static final String MASTERCARD_NUMBER_VALID_PREF54 = "5480451517153881";

	private static final String MASTERCARD_NUMBER_VALID_PREF55 = "5508405877948239";

	private static final String DINERSCLUB_NUMBER_VALID_PREF36 = "36490102462661";
	private static final String DINERSCLUB_NUMBER_VALID_PREF38 = "38969483528578";
	private static final String DINERSCLUB_NUMBER_VALID_PREF55 = "5500005555555559";
	private static final String DINERSCLUB_NUMBER_VALID_PREF300 = "30093596121813";
	private static final String DINERSCLUB_NUMBER_VALID_PREF301 = "30168885551076";
	private static final String DINERSCLUB_NUMBER_VALID_PREF302 = "30216988668758";
	private static final String DINERSCLUB_NUMBER_VALID_PREF303 = "30365229131496";
	

	private static final String DISCOVER_NUMBER_VALID = "6011000990139424";


	private static final String HIPERCARD_NUMBER_VALID = "6062828888666688";
	private static final String ELO_NUMBER_VALID = "6362970000457013";

	@Test
	public void isValid_amexCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(AMEX_NUMBER_VALID1, CreditCardFlag.AMEX));
		assertTrue(new CreditCardValidator().isValid(AMEX_NUMBER_VALID2, CreditCardFlag.AMEX));

	}

	@Test
	public void isValid_amexCardInvalid_shouldReturnsFalse() {
		final boolean isValid = new CreditCardValidator().isValid(
				MASTERCARD_NUMBER_VALID_PREF54,
				CreditCardFlag.AMEX);
		assertFalse(isValid);
	}

	@Test
	public void isValid_visaCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(VISA_NUMBER_VALID1, CreditCardFlag.VISA));
		assertTrue(new CreditCardValidator().isValid(VISA_NUMBER_VALID2, CreditCardFlag.VISA));
		assertTrue(new CreditCardValidator().isValid(VISA_NUMBER_VALID_13DIGIT, CreditCardFlag.VISA));

	}

	@Test
	public void isValid_visaCardInvalid_shouldReturnsFalse() {
		assertFalse(new CreditCardValidator().isValid(MASTERCARD_NUMBER_VALID_PREF54, CreditCardFlag.VISA));
	}

	@Test
	public void isValid_discoverCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(DISCOVER_NUMBER_VALID, CreditCardFlag.DISCOVER));
	}

	@Test
	public void isValid_discoverCardInvalid_shouldReturnsFalse() {
		assertFalse(new CreditCardValidator().isValid(VISA_NUMBER_VALID1, CreditCardFlag.DISCOVER));
	}

	@Test
	public void isValid_mastercardCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(MASTERCARD_NUMBER_VALID_PREF52, CreditCardFlag.MASTERCARD));
		assertTrue(new CreditCardValidator().isValid(MASTERCARD_NUMBER_VALID_PREF53, CreditCardFlag.MASTERCARD));
		assertTrue(new CreditCardValidator().isValid(MASTERCARD_NUMBER_VALID_PREF54, CreditCardFlag.MASTERCARD));
		assertTrue(new CreditCardValidator().isValid(MASTERCARD_NUMBER_VALID_PREF55, CreditCardFlag.MASTERCARD));
	}

	@Test
	public void isValid_mastercardCardInvalid_shouldReturnsFalse() {
		final boolean isValid = new CreditCardValidator().isValid(
				VISA_NUMBER_VALID1,
				CreditCardFlag.MASTERCARD);
		assertFalse(isValid);
	}

	@Test
	public void isValid_dinersclubCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF36, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF38, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF55, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF300, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF301, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF302, CreditCardFlag.DINERSCLUB));
		assertTrue(new CreditCardValidator().isValid(DINERSCLUB_NUMBER_VALID_PREF303, CreditCardFlag.DINERSCLUB));
	}

	@Test
	public void isValid_dinersclubCardInvalid_shouldReturnsFalse() {
		assertFalse(new CreditCardValidator().isValid(VISA_NUMBER_VALID1, CreditCardFlag.DINERSCLUB));
	}

	@Test
	public void isValid_hipercardCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(HIPERCARD_NUMBER_VALID, CreditCardFlag.HIPERCARD));
	}

	@Test
	public void isValid_hipercardCardInvalid_shouldReturnsFalse() {
		final boolean isValid = new CreditCardValidator().isValid(
				VISA_NUMBER_VALID1,
				CreditCardFlag.HIPERCARD);
		assertFalse(isValid);
	}

	@Test
	public void isValid_eloCardValid_shouldReturnsTrue() {
		assertTrue(new CreditCardValidator().isValid(ELO_NUMBER_VALID, CreditCardFlag.ELO));
	}

	@Test
	public void isValid_eloCardInvalid_shouldReturnsFalse() {
		final boolean isValid = new CreditCardValidator().isValid(
				HIPERCARD_NUMBER_VALID,
				CreditCardFlag.ELO);
		assertFalse(isValid);
	}

	@Test
	public void containsFlag_allFlagsValid_shouldReturnsTrue() {
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.AMEX));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.DINERSCLUB));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.DISCOVER));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.ELO));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.HIPERCARD));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.MASTERCARD));
		assertTrue(CreditCardFlag.containsFlag(CreditCardConstants.VISA));
	}

	@Test
	public void containsFlag_creditcardInvalid_shouldReturnsFalse() {
		assertFalse(CreditCardFlag.containsFlag("BomPratoCard"));
	}

	@Test
	public void containsFlag_flagNameNull_shouldReturnsFalse() {
		assertFalse(CreditCardFlag.containsFlag(null));
	}

	/**
	 * ---------------------------------------------- Tests CVV ----------------------------------------------
	 */

	@Test
	public void validateCVV_AMEXCardValid_ReturnTrue() {
		assertTrue(new CreditCardValidator().validateCVV("1234", CreditCardFlag.AMEX));
	}

	@Test
	public void validateCVV_AMEXCardInvalid_ReturnFalse() {
		assertFalse(new CreditCardValidator().validateCVV("123", CreditCardFlag.AMEX));
	}

	@Test
	public void validateCVV_AMEXCardTextInvalid_ReturnFalse() {
		assertFalse(new CreditCardValidator().validateCVV("123X", CreditCardFlag.AMEX));
	}

	/**
	 * ---------------------------------------------- Tests CreditCardFlag ----------------------------------------------
	 */

	@Test
	public void getFlagCodeEnumByValidCreditCard_AMEXCardValid_shouldReturnAMEX() {
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(AMEX_NUMBER_VALID1), CreditCardFlag.AMEX);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(AMEX_NUMBER_VALID2), CreditCardFlag.AMEX);
	}

	@Test
	public void getFlagCodeEnumByValidCreditCard_visaCardValid_shouldReturnVISA() {
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(VISA_NUMBER_VALID1), CreditCardFlag.VISA);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(VISA_NUMBER_VALID2), CreditCardFlag.VISA);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(VISA_NUMBER_VALID_13DIGIT), CreditCardFlag.VISA);
	}

	@Test
	public void getFlagCodeEnumByValidCreditCard_visaCardInvalid_shouldReturnOther() {
		assertNotEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(AMEX_NUMBER_VALID1), CreditCardFlag.VISA);
		assertNotEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(AMEX_NUMBER_VALID2), CreditCardFlag.VISA);

	}

	@Test
	public void getFlagCodeEnumByValidCreditCard_discoverCardValid_shouldReturnsDiscover() {
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(DISCOVER_NUMBER_VALID), CreditCardFlag.DISCOVER);
	}

	@Test
	public void getFlagCodeEnumByValidCreditCard_mastercardCardValid_shouldReturnsMasterCard() {
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(MASTERCARD_NUMBER_VALID_PREF52), CreditCardFlag.MASTERCARD);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(MASTERCARD_NUMBER_VALID_PREF53), CreditCardFlag.MASTERCARD);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(MASTERCARD_NUMBER_VALID_PREF54), CreditCardFlag.MASTERCARD);
		assertEquals(new CreditCardValidator().getFlagCodeEnumByValidCreditCard(MASTERCARD_NUMBER_VALID_PREF55), CreditCardFlag.MASTERCARD);
	}
}
