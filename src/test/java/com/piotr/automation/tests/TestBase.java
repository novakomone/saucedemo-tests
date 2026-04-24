package com.piotr.automation.tests;

import com.piotr.automation.factory.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected final String baseUrl = "https://www.saucedemo.com/";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver.set(BrowserManager.createDriver(browser));
        getDriver().get(baseUrl);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}