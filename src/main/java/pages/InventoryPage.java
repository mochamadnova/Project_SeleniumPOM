package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By productsTitle = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify on Inventory page")
    public boolean isLoaded() {
        return waitVisible(productsTitle).getText().equalsIgnoreCase("Products");
    }
}