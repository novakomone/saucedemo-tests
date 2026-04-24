package com.piotr.automation.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    public static WebDriver createDriver(String browserName) {
        WebDriver driver;

//
//        if (browserName.equalsIgnoreCase("chrome")) {
//
//            ChromeOptions options = new ChromeOptions();
//
//            WebDriverManager.chromedriver().setup();
//
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("credentials_enable_service", false);
//            prefs.put("profile.password_manager_enabled", false);
//            prefs.put("profile.password_manager_leak_detection", false);
//
//            options.setExperimentalOption("prefs", prefs);
//            options.addArguments("--disable-notifications");
//            options.addArguments("--incognito");
//
//            driver = new ChromeDriver(options);
//
//        } else if (browserName.equalsIgnoreCase("edge")) {
//
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//
//        } else {
//            throw new IllegalArgumentException("Browser not supported: " + browserName);
//        }
//
//        driver.manage().window().maximize();
//        return driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;

            case "edge":
                driver = createEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChromeDriver() {

        ChromeOptions options = new ChromeOptions();

        WebDriverManager.chromedriver().setup();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeDriver() {

        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}