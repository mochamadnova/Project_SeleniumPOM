package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // Lokator-field & tombol
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.cssSelector("button[type='submit']");
    private final By flashMessage  = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl + "/login");
        return this;
    }

    public LoginPage setUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public SecureAreaPage submitValid() {
        click(loginButton);
        // Bila valid, diarahkan ke /secure
        return new SecureAreaPage(driver);
    }

    public LoginPage submitInvalid() {
        click(loginButton);
        // Tetap di halaman login (flash error)
        return this;
    }

    public String getFlashMessage() {
        return getText(flashMessage).trim();
    }
}
