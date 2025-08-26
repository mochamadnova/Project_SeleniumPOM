package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input username: {username}")
    public LoginPage setUsername(String username) {
        type(usernameField, username);
        return this;
    }

    @Step("Input password: ******")
    public LoginPage setPassword(String password) {
        type(passwordField, password);
        return this;
    }

    @Step("Click Login")
    public InventoryPage clickLoginSuccess() {
        click(loginButton);
        return new InventoryPage(driver);
    }

    @Step("Click Login expect error")
    public LoginPage clickLoginExpectError() {
        click(loginButton);
        return this;
    }

    public String getErrorText() {
        return waitVisible(errorMessage).getText();
    }
}