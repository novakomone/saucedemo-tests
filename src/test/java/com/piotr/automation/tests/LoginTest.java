package com.piotr.automation.tests;

import com.piotr.automation.pages.InventoryPage;
import com.piotr.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "Login with valid user and log out")
    public void validLoginAndLogoutTest() {

        // given
        LoginPage loginPage = new LoginPage(driver);

        // UC-1
        // when
        loginPage.login("standard_user", "secret_sauce");

        // then
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(
                inventoryPage.isInventoryVisible(),
                "Inventory page should be visible after successful login"
        );

        // when
        inventoryPage.logout();
        LoginPage loginPageAfterLogout = new LoginPage(driver);

        // then
        Assert.assertTrue(
                loginPageAfterLogout.isLoginPageDisplayed(),
                "Login page should be visible after logout"
        );
    }

    @Test(description = "Login with locked out user")
    public void lockedOutUserLoginTest() {

        // given
        LoginPage loginPage = new LoginPage(driver);

        // UC-2
        // when
        loginPage.login("locked_out_user", "secret_sauce");

        // then
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out."
        );
    }

    @Test(description = "Login with empty username")
    public void emptyUsernameLoginTest() {

        // given
        LoginPage loginPage = new LoginPage(driver);

        // UC-3
        // when
        loginPage.login("", "secret_sauce");

        // then
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required"
        );

    }

    @Test(description = "Login with empty password")
    public void emptyPasswordLoginTest() {

        // given
        LoginPage loginPage = new LoginPage(driver);

        // UC-4
        // when
        loginPage.login("standard_user", "");

        // then
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Password is required"
        );
    }

    @Test(description = "Login with invalid credentials")
    public void invalidCredentialsLoginTest() {

        // given
        LoginPage loginPage = new LoginPage(driver);

        // UC-5
        // when
        loginPage.login("wrong_user", "wrong_password");

        // then
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}