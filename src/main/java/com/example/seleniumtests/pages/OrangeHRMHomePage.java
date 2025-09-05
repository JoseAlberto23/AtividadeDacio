package com.example.seleniumtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrangeHRMHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By dashboardHeader = By.xpath("//h6[text()=\"Dashboard\"]");

    public OrangeHRMHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getDashboardHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        return driver.findElement(dashboardHeader).getText();
    }
}

