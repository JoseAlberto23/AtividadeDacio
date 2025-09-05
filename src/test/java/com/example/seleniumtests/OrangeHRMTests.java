package com.example.seleniumtests;

import com.example.seleniumtests.pages.OrangeHRMHomePage;
import com.example.seleniumtests.pages.OrangeHRMLoginPage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrangeHRMTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("Admin", "admin123");

        OrangeHRMHomePage homePage = new OrangeHRMHomePage(driver);
        assertEquals("Dashboard", homePage.getDashboardHeader());
    }

    @Test
    public void testInvalidLogin() {
        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("invalid", "password");
        assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
    }
}

