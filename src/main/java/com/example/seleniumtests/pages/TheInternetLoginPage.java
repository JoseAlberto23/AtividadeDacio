package com.example.seleniumtests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TheInternetLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button[type=\'submit\']");
    private By successMessage = By.cssSelector("#flash.success");
    private By errorMessage = By.cssSelector("#flash.error");

    public TheInternetLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}

