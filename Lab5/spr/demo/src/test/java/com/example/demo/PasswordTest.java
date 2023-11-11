package com.example.demo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    public void validPassword_ShouldReturnTrue() {
        Password validPassword = new Password("StrongPwd123@", "john_doe", "john.doe@example.com");
        assertTrue(validPassword.isValidPassword());
    }

    @Test
    public void invalidPassword_TooShort_ShouldReturnFalse() {
        Password invalidLengthPassword = new Password("Short1@", "user123", "user@example.com");
        assertFalse(invalidLengthPassword.isValidPassword());
    }

    @Test
    public void invalidPassword_WeakCharacteristics_ShouldReturnFalse() {
        Password invalidCharacteristicsPassword = new Password("weakpassword", "testuser", "test@example.com");
        assertFalse(invalidCharacteristicsPassword.isValidPassword());
    }

    @Test
    public void invalidPassword_ContainsUsernameOrEmail_ShouldReturnFalse() {
        Password containsUsernameOrEmailPassword = new Password("user123@Weak", "user123", "user@example.com");
        assertFalse(containsUsernameOrEmailPassword.isValidPassword());
    }

    @Test
    public void validPassword_UsernameAndEmailUpperCase_ShouldReturnTrue() {
        Password validPassword = new Password("StrongPwd123@", "John_Doe", "John.Doe@example.com");
        assertTrue(validPassword.isValidPassword());
    }

    @Test
    public void invalidPassword_ContainsUsernameUpperCase_ShouldReturnFalse() {
        Password containsUsernamePassword = new Password("PasswordJohnDoe", "JohnDoe", "john@example.com");
        assertFalse(containsUsernamePassword.isValidPassword());
    }

    @Test
    public void invalidPassword_ContainsEmailUpperCase_ShouldReturnFalse() {
        Password containsEmailPassword = new Password("PasswordJohnDoe", "john_doe", "John.Doe@example.com");
        assertFalse(containsEmailPassword.isValidPassword());
    }
}