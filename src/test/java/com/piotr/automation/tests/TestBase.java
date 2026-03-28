package com.piotr.automation.tests;

import com.piotr.automation.factory.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    protected WebDriver driver;
    protected final String baseUrl = "https://www.saucedemo.com/";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        System.out.println("Setting up browser: " + browser);
        driver = BrowserManager.createDriver(browser);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tear down...===END TEST===");
        if (driver != null) {
            driver.quit();
        }
    }
}
