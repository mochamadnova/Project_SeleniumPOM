package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import pages.LoginPage;
import utils.Config;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Login berhasil dengan kredensial valid")
    void loginSuccess() {
        String baseUrl = Config.baseUrl();

        LoginPage login = new LoginPage(driver)
                .open(baseUrl)
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .submitValid();

        // Assertion: pastikan dashboard atau elemen tertentu muncul setelah login
        assertTrue(login.isDashboardVisible(), "Dashboard tidak muncul setelah login");
    }

}