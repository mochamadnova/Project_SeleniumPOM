// ...existing code...
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By inventoryContainer = By.id("inventory_container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage setUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage submitValid() {
        driver.findElement(loginButton).click();
        return this;
    }

    // Tambahkan method ini — mengembalikan true jika elemen dashboard muncul
    public boolean isDashboardVisible() {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
