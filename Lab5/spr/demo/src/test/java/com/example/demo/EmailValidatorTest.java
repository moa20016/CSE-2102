package com.example.demo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    @Test
    public void validEmail_ShouldReturnTrue() {
        assertTrue(EmailValidator.isValidEmail("john.doe@example.com"));
    }

    @Test
    public void validEmail_WithUpperCase_ShouldReturnTrue() {
        assertTrue(EmailValidator.isValidEmail("John.Doe@example.com"));
    }

    @Test
    public void validEmail_WithNumbersAndSymbols_ShouldReturnTrue() {
        assertTrue(EmailValidator.isValidEmail("user123@example.co"));
    }

    @Test
    public void invalidEmail_Null_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }

    @Test
    public void invalidEmail_EmptyString_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void invalidEmail_InvalidFormat_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("invalidEmail"));
    }

    @Test
    public void invalidEmail_MissingAtSymbol_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("userexample.com"));
    }

    @Test
    public void invalidEmail_MissingDomain_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("user@.com"));
    }

    @Test
    public void invalidEmail_TooShortDomain_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("user@example.c"));
    }

    @Test
    public void invalidEmail_InvalidCharactersInDomain_ShouldReturnFalse() {
        assertFalse(EmailValidator.isValidEmail("user@example#.com"));
    }
}