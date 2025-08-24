package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Config;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        // Siapkan driver Chrome otomatis
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if (Config.headless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1366,768");

        driver = new ChromeDriver(options);

        // (Opsional) implicit wait: 0..1 detik, karena kita pakai explicit wait di BasePage
        driver.manage().timeouts().implicitlyWait(Config.implicitWait());

        // (Opsional) page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
