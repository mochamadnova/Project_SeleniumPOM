package utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Optional;

public class AllureTestWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object testInstance = context.getRequiredTestInstance();
        try {
            WebDriver driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
            if (driver != null) {
                byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failure screenshot", new ByteArrayInputStream(shot));
            }
        } catch (Exception ignored) { }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.step("Test passed: " + context.getDisplayName());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Allure.step("Test disabled: " + context.getDisplayName() + ", reason: " + reason.orElse("n/a"));
    }
}