package com.example.seleniumtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoInventoryPage {
    private WebDriver driver;

    // Locators
    private By productsTitle = By.cssSelector(".title");

    public SauceDemoInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }
}

