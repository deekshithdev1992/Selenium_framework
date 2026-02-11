package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginWithInvalidCredentials() {
        loginPage.performLogin("invalid@salesforce.com", "InvalidPass123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid credentials");
    }

    @Test(priority = 2)
    public void verifyLoginWithEmptyUsername() {
        loginPage.performLogin("", "Password123!");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty username");
    }

    @Test(priority = 3)
    public void verifyLoginWithEmptyPassword() {
        loginPage.performLogin("user@salesforce.com", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty password");
    }

    @Test(priority = 4)
    public void verifyLoginWithEmptyCredentials() {
        loginPage.performLogin("", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty credentials");
    }

    @Test(priority = 5)
    public void verifyLoginWithInvalidUsernameFormat() {
        loginPage.performLogin("invalidemail", "Password123!");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid username format");
    }

    @Test(priority = 6)
    public void verifyLoginWithSpecialCharacters() {
        loginPage.performLogin("test@#$%^&*.com", "Pass@#$%");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for special characters");
    }

    @Test(priority = 7)
    public void verifyLoginWithSQLInjection() {
        loginPage.performLogin("admin' OR '1'='1", "admin' OR '1'='1");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for SQL injection attempt");
    }
}
