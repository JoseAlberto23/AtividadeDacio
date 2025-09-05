package com.example.seleniumtests;

import com.example.seleniumtests.pages.SauceDemoInventoryPage;
import com.example.seleniumtests.pages.SauceDemoLoginPage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceDemoTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");

        SauceDemoInventoryPage inventoryPage = new SauceDemoInventoryPage(driver);
        assertEquals("Products", inventoryPage.getProductsTitle());
    }

    @Test
    public void testInvalidLogin() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("invalid_user", "wrong_password");

        assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
}

