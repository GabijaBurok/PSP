package Validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerShould 
{
	PasswordChecker _psw;
	
	@BeforeEach
	void setUp()
	{
		_psw = new PasswordChecker();
	}

	@Test
	void testIfNullWhenNotNull() {
		assertTrue(_psw.checkIfExists("Asd123"));
	}
	
	@Test
	void testIfNullWhenNull() {
		assertFalse(_psw.checkIfExists(null));
	}

	@Test
	void testIfEmptyWhenEmpty() {
		assertFalse(_psw.checkIfExists(""));
	}
	
	@Test
	void testIfEmptyWhenNotEmpty() {
		assertTrue(_psw.checkIfExists("Asd123"));
	}
	
	@Test
	void testIfCorrectLenghtWhenCorrectLenght() {
		assertTrue(_psw.checkLenght("Asdasd123!"));
	}
	//check if more than X symbols
	
	@Test
	void testIfCorrectLenghtWhenTooShort() {
		assertFalse(_psw.checkLenght("A1!"));
	}
	//check if less than X symbols
	
	@Test
	void testIfHasUppercaseWhenHasUpperCase() {
		assertTrue(_psw.checkUpperCase("Asdasd123!"));
	}
	
	@Test
	void testIfHasUppercaseWhenNoUpperCase() {
		assertFalse(_psw.checkUpperCase("asdasd123!"));
	}
	
	@Test
	void testIfHasSpecialSymbolWhenHasSpecialSymbol() {
		assertTrue(_psw.checkSpecialSymbol("Asdasd123!"));
	}
	
	@Test
	void testIfHasSpecialSymbolWhenNoSpecialSymbol() {
		assertFalse(_psw.checkSpecialSymbol("Asdasd123"));
	}
}
