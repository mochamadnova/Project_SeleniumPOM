package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title")
    WebElement title_product;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burger_menu;

    @FindBy(id = "logout_sidebar_link")
    WebElement menu_logout;

    public boolean productsTitle() {
            try {
                return title_product.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
        }
    }

    public void clickBurgerMenu() {
        burger_menu.click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(menu_logout)).click();
        
    }
}
