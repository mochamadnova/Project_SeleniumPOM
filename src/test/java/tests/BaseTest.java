package tests;

import driver.DriverFactory;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Config;
import utils.AllureTestWatcher;

@ExtendWith(AllureTestWatcher.class)
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    @Step("Start browser & navigate to baseUrl")
    void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get(Config.baseUrl());
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }

    protected byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}