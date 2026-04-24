package com.piotr.automation.tests;

import com.piotr.automation.pages.InventoryPage;
import com.piotr.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "Login with valid user and log out")
    public void validLoginAndLogoutTest() {


        LoginPage loginPage = new LoginPage(getDriver());


        loginPage.login(TestData.STANDARD_USER, TestData.VALID_PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        Assert.assertTrue(
                inventoryPage.isInventoryVisible(),
                "Inventory page should be visible after successful login"
        );


        inventoryPage.logout();
        LoginPage loginPageAfterLogout = new LoginPage(getDriver());


        Assert.assertTrue(
                loginPageAfterLogout.isLoginPageDisplayed(),
                "Login page should be visible after logout"
        );
    }

    @Test(description = "Login with locked out user")
    public void lockedOutUserLoginTest() {


        LoginPage loginPage = new LoginPage(getDriver());


        loginPage.login(TestData.LOCKED_OUT_USER, TestData.VALID_PASSWORD);


        Assert.assertEquals(
                loginPage.getErrorMessage(),
                TestData.ERROR_LOCKED_OUT
        );
    }

    @Test(description = "Login with empty username")
    public void emptyUsernameLoginTest() {


        LoginPage loginPage = new LoginPage(getDriver());


        loginPage.login(TestData.EMPTY_VALUE, TestData.VALID_PASSWORD);


        Assert.assertEquals(
                loginPage.getErrorMessage(),
                TestData.ERROR_USERNAME_REQUIRED
        );

    }

    @Test(description = "Login with empty password")
    public void emptyPasswordLoginTest() {

        LoginPage loginPage = new LoginPage(getDriver());


        loginPage.login(TestData.STANDARD_USER, TestData.EMPTY_VALUE);


        Assert.assertEquals(
                loginPage.getErrorMessage(),
                TestData.ERROR_PASSWORD_REQUIRED
        );
    }

    @Test(description = "Login with invalid credentials")
    public void invalidCredentialsLoginTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(TestData.INVALID_USER, TestData.INVALID_PASSWORD);


        Assert.assertEquals(
                loginPage.getErrorMessage(),
                TestData.ERROR_INVALID_CREDENTIALS
        );
    }
}