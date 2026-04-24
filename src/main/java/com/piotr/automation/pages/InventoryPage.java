package com.piotr.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends AbstractPage {

    private final By pageTitle = By.cssSelector(".title");
    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By logoutLink = By.cssSelector("#logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryVisible() {
        return isVisible(pageTitle);
    }

    public void openMenu() {
        click(menuButton);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void logout() {
        openMenu();
        clickLogout();
    }
}