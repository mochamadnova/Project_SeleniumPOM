package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pages.LoginPage;
import pages.SecureAreaPage;
import utils.Config;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Login berhasil dengan kredensial valid")
    void loginSuccess() {
        String baseUrl = Config.baseUrl();

        SecureAreaPage secure = new LoginPage(driver)
                .open(baseUrl)
                .setUsername("tomsmith")                // username valid
                .setPassword("SuperSecretPassword!")    // password valid
                .submitValid();                         // klik Login

        assertTrue(secure.isLoaded(), "Secure Area tidak terbuka");
        assertTrue(
            secure.flashText().contains("You logged into a secure area!"),
            "Pesan sukses tidak sesuai"
        );
    }

    @Test
    @DisplayName("Login gagal dengan password salah")
    void loginFailWrongPassword() {
        String baseUrl = Config.baseUrl();

        LoginPage login = new LoginPage(driver)
                .open(baseUrl)
                .setUsername("tomsmith")            // username valid
                .setPassword("WRONG_PASSWORD")      // password salah
                .submitInvalid();                   // klik Login

        String flash = login.getFlashMessage();
        assertTrue(
            flash.contains("Your password is invalid!"),
            "Pesan error tidak sesuai"
        );
        // Tetap di halaman login (URL /login)
        assertTrue(login.getCurrentUrl().contains("/login"), "Seharusnya tetap di halaman login");
    }
}
