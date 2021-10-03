package com.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneValidatorTest {

    PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void validatePhoneNumber_ValidNumber() {
        String phoneNumber = "+37060000000";

        assertTrue(phoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_HasOtherChars() {
        String phoneNumber = "+3706A000000";

        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_StartsWith86() {
        String phoneNumber = "860000000";

        assertTrue(phoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_addingPrefixWorks() {
        String phoneNumber = "+12360000000";
        phoneValidator.addNumberPrefix("+123", 12); // prefix and length

        assertTrue(phoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    void validatePhoneNumber_TooShort() {
        String phoneNumber = "+370123";

        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber));
    }
}