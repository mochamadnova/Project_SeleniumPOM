package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement field_username;

    @FindBy(id = "password")
    WebElement field_password;

    @FindBy(id = "login-button")
    WebElement button_login;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    @FindBy(className = "login_logo")
    WebElement logo_login;

    public void enterUsername(String username) {
        field_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        field_password.sendKeys(password);
    }

    public void clickLogin() {
        button_login.click();
    }

    public String ErrorMessage() {
        errorMessage.isDisplayed();
        return errorMessage.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean loginlogo() {
        try {
                return logo_login.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
        }
    }
}
