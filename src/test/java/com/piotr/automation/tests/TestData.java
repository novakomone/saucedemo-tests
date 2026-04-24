package com.piotr.automation.tests;

public final class TestData {

    private TestData() {
    }
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "locked_out_user";
    public static final String VALID_PASSWORD = "secret_sauce";
    public static final String INVALID_USER = "wrong_user";
    public static final String INVALID_PASSWORD = "wrong_password";
    public static final String EMPTY_VALUE = "";

    public static final String ERROR_LOCKED_OUT =
            "Epic sadface: Sorry, this user has been locked out.";
    public static final String ERROR_USERNAME_REQUIRED =
            "Epic sadface: Username is required";
    public static final String ERROR_PASSWORD_REQUIRED =
            "Epic sadface: Password is required";
    public static final String ERROR_INVALID_CREDENTIALS =
            "Epic sadface: Username and password do not match any user in this service";
}
