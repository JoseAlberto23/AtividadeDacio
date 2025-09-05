package com.example.seleniumtests;

import com.example.seleniumtests.pages.TheInternetLoginPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TheInternetTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        TheInternetLoginPage loginPage = new TheInternetLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("tomsmith", "SuperSecretPassword!");
        assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void testInvalidLogin() {
        TheInternetLoginPage loginPage = new TheInternetLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("invalid", "password");
        assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
    }
}

