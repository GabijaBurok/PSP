package Validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneValidatorShould 
{

	PhoneValidator _ph;
	
	@BeforeEach
	void setUp()
	{
		_ph = new PhoneValidator();
	}

	@Test
	void testIfNullWhenNull() {
		assertFalse(_ph.checkIfExists(null));
	}

	@Test
	void testIfNullWhenNotNull() {
		assertTrue(_ph.checkIfExists("+37068353981"));
	}
	
	@Test
	void testIfEmptyWhenEmpty() {
		assertFalse(_ph.checkIfExists(""));
	}
	
	@Test
	void testIfEmptyWhenNotEmpty() {
		assertTrue(_ph.checkIfExists("+37068353981"));
	}
	
	@Test
	void testifGoodNumberWhenGoodNumber() {
		assertTrue(_ph.checkForOtherSymbols("+37068353981"));
	}
	
	@Test
	void testIfGoodNumberWhenThereAreLetters() {
		assertFalse(_ph.checkForOtherSymbols("+370abc"));
	}
	
	@Test
	void testIfChangesWhenNeeded() {
		assertEquals("+370", _ph.changeNumberFormer("868353981"));
	}
	
	@Test
	void testIfChangesWhenNotNeeded() {
		assertEquals("+370", _ph.changeNumberFormer("+37068353981"));
	}
	
	@Test
	void testIfCorrectCountryValidationWhenCorrect() {
		assertTrue(_ph.checkForValidCountryNumber("+37168353981", "LV"));
	}
	
	@Test
	void testIfCorrectCountryValidationWhenWrong() {
		assertFalse(_ph.checkForValidCountryNumber("+37068353981", "LV"));
	}
}
