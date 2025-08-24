package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
    private final By header = By.cssSelector("div.example h2"); // "Secure Area"
    private final By flash  = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        // Simple check: header muncul dan URL mengandung /secure
        return getCurrentUrl().contains("/secure") && !driver.findElements(header).isEmpty();
    }

    public String flashText() {
        return getText(flash).trim();
    }
}
