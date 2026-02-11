package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLoginPageElementsDisplayed() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field not displayed");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field not displayed");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button not displayed");
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot password link not displayed");
        Assert.assertTrue(loginPage.isRememberCheckboxDisplayed(), "Remember me checkbox not displayed");
    }

    @Test(priority = 2)
    public void verifyValidLoginWithRememberMe() {
        loginPage.enterUsername("validuser@salesforce.com");
        loginPage.enterPassword("ValidPassword123!");
        loginPage.clickRememberMe();
        loginPage.clickLogin();
        Assert.assertFalse(loginPage.isErrorMessageDisplayed(), "Error message displayed for valid credentials");
    }

    @Test(priority = 3)
    public void verifyValidLoginWithoutRememberMe() {
        loginPage.performLogin("validuser@salesforce.com", "ValidPassword123!");
        Assert.assertFalse(loginPage.isErrorMessageDisplayed(), "Error message displayed for valid credentials");
    }
}
