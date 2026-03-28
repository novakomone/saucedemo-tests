package com.piotr.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends AbstractPage {


    private By pageTitle = By.xpath("//span[@class='title']");
    private By menuButton = By.cssSelector("#react-burger-menu-btn");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryVisible() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public void logout() {
        clickMenuButton();
        clickLogoutLink();
    }
}
