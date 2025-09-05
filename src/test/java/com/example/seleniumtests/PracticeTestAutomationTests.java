package com.example.seleniumtests;

import com.example.seleniumtests.pages.PracticeTestAutomationLoginPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PracticeTestAutomationTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        PracticeTestAutomationLoginPage loginPage = new PracticeTestAutomationLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("student", "Password123");
        assertTrue(loginPage.getSuccessMessage().contains("Logged In Successfully"));
    }

    @Test
    public void testInvalidUsername() {
        PracticeTestAutomationLoginPage loginPage = new PracticeTestAutomationLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("incorrectUser", "Password123");
        assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"));
    }

    @Test
    public void testInvalidPassword() {
        PracticeTestAutomationLoginPage loginPage = new PracticeTestAutomationLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("student", "incorrectPassword");
        assertTrue(loginPage.getErrorMessage().contains("Your password is invalid!"));
    }
}

