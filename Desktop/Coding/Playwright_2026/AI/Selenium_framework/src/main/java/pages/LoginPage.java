package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberCheckbox;

    @FindBy(xpath = "//a[contains(text(),'Forgot Your Password')]")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void performLoginWithRememberMe(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickRememberMe();
        clickLogin();
    }

    public void clickRememberMe() {
        wait.until(ExpectedConditions.elementToBeClickable(rememberCheckbox));
        if (!rememberCheckbox.isSelected()) {
            rememberCheckbox.click();
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isUsernameFieldDisplayed() {
        return usernameField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isRememberCheckboxDisplayed() {
        return rememberCheckbox.isDisplayed();
    }
}
