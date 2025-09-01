package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title")
    WebElement title_product;

    


    
    public boolean productsTitle() {
            try {
                return title_product.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
        }
    }


}
