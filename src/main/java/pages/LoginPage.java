package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".title")
    WebElement productsTitle;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String ErrorMessage() {
        loginButton.isDisplayed();
        return errorMessage.getText();
    }

    public boolean isLoginSuccessful() {
            try {
                return productsTitle.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
        }
    }
}
