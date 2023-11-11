package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String pwd;
    private String username;
    private String email;

    public Password(String pwd, String username, String email) {
        this.pwd = pwd;
        this.username = username;
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean isValidPassword() {
        return isLengthValid() && hasRequiredCharacters() && doesNotContainUsernameOrEmail();
    }

    private boolean isLengthValid() {
        return pwd.length() >= 8;
    }

    private boolean hasRequiredCharacters() {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

    private boolean doesNotContainUsernameOrEmail() {
        String lowerCasePwd = pwd.toLowerCase();
        String lowerCaseUsername = username.toLowerCase();
        String lowerCaseEmail = email.toLowerCase();

        return !lowerCasePwd.contains(lowerCaseUsername) && !lowerCasePwd.contains(lowerCaseEmail);
    }
}