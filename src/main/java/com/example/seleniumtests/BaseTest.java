package com.example.seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("140.0.7339.80").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

