package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.Config;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Authentication")
@Feature("Login")
public class LoginTests extends BaseTest {

    @Test
    @Tag("smoke")
    @Story("Valid login with standard_user")
    @DisplayName("Login sukses menampilkan halaman Products")
    @Description("Sebagai user valid, ketika login maka akan diarahkan ke halaman Inventory/Products")
    void loginSuccess() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inv = login
                .setUsername(Config.username())
                .setPassword(Config.password())
                .clickLoginSuccess();

        assertTrue(inv.isLoaded(), "Inventory page should be loaded");
    }

    @Test
    @Tag("regression")
    @Story("Invalid login shows error message")
    @DisplayName("Login gagal menampilkan error")
    @Description("Sebagai user dengan kredensial salah, ketika login maka muncul pesan error")
    void loginFailInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login
                .setUsername("standard_user")
                .setPassword("wrong_password")
                .clickLoginExpectError();

        String err = login.getErrorText();
        assertTrue(err.toLowerCase().contains("epic sadface"),
                "Error banner should appear with 'Epic sadface' text");
    }
}