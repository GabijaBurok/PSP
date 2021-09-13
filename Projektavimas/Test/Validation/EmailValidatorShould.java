package Validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailValidatorShould 
{

	EmailValidator _em;
	
	@BeforeEach
	void setUp()
	{
		_em = new EmailValidator();
	}

	@Test
	void testIfNullWhenNull() {
		assertFalse(_em.checkIfExists(null));
	}

	@Test
	void testIfNullWhenNotNull() {
		assertTrue(_em.checkIfExists("john.smith@gmail.com"));
	}
	
	@Test
	void testIfEmptyWhenEmpty() {
		assertFalse(_em.checkIfExists(""));
	}
	
	@Test
	void testIfEmptyWhenNotEmpty() {
		assertTrue(_em.checkIfExists("john.smith@gmail.com"));
	}
	
	@Test
	void testIfAtSignExistsWhenExists() {
		assertTrue(_em.checkAtSign("john.smith@gmail.com"));
	}
	@Test
	void testIfAtSignExistsWhenMissing() {
		assertFalse(_em.checkAtSign("john.smith#gmail.com"));
	}
	
	@Test
	void testIfHasIllegalSymbols() {
		assertFalse(_em.checkIllegalSymbols("džon.smith@gmail.com"));
	}
	
	@Test
	void testIfHasGoodDomainWhenGoodDomain() {
		assertTrue(_em.checkDomain("marketingas@mif.vusa.lt"));
	}
	
	@Test
	void testIfHasGoodDomainWhenBadDomain() {
		assertFalse(_em.checkDomain("marketingas@zodis.lt"));
	}
	
	@Test
	void testIfHasGoodTLDWhenGoodTLD() {
		assertTrue(_em.checkDomain("marketingas@mif.vusa.lt"));
	}
	
	@Test
	void testIfHasGoodTLDWhenBadTLD() {
		assertFalse(_em.checkDomain("marketingas@mifsa.asd"));
	}
}
