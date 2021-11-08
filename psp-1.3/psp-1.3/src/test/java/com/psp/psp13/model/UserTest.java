package com.psp.psp13.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest
{
    @Test
    void userFields_AreSetGetCorrectly_FielsShouldBeEqual()
    {
        User u = new User("Vardas", "Pavarde", "861111111", "email@email.com", "Didlaukio g. 47", "Passw0rd!");
        assertAll(
                () -> assertEquals("Vardas", u.getName()),
                () -> assertEquals("Pavarde", u.getSurname()),
                () -> assertEquals("861111111", u.getPhoneNumber()),
                () -> assertEquals("email@email.com", u.getEmail()),
                () -> assertEquals("Didlaukio g. 47", u.getAddress()),
                () -> assertEquals("Passw0rd!", u.getPassword())
        );
    }
    @Test
    void compareUsers_UsersShouldBeEqual()
    {
        User u1 = new User("Vardas", "Pavarde", "861111111", "email@email.com", "Didlaukio g. 47", "Passw0rd!");
        User u2 = new User("Vardas", "Pavarde", "861111111", "email@email.com", "Didlaukio g. 47", "Passw0rd!");

        assertEquals(0, u1.compareTo(u2));
    }

    @Test
    void phoneNumberValid_ShouldBeTrue()
    {
        User u = new User();
        assertTrue(u.isPhoneNumberValid("861111111"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"8aaaaaaaa", "861", "86111111111"})
    void phoneNumberValid_Tests_ShouldBeFalse(String number)
    {
        User u = new User();
        assertFalse(u.isPhoneNumberValid(number));
    }

    @Test
    void emailValid_ShouldBeTrue()
    {
        User u = new User();
        assertTrue(u.isEmailValid("email@email.com"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "email@email.123"})
    void emailValid_Tests_ShouldBeFalse(String email)
    {
        User u = new User();
        assertFalse(u.isEmailValid(email));
    }

    @Test
    void passwordValid_ShouldBeTrue()
    {
        User u = new User();
        assertTrue(u.isPasswordValid("Password!"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"pass", "", "Password"})
    void passwordValid_Tests(String password)
    {
        User u = new User();
        assertFalse(u.isPasswordValid(password));
    }
}
