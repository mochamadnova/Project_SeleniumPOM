import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import com.aventstack.extentreports.Status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    @Order(1)
    @Test
    public void LOG01() {
        test = extent.createTest("LOG01 - Login dengan kredensial valid",
                "Verifikasi user bisa login dengan akun standard_user");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("standard_user");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("secret_sauce");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Verifikasi halaman Products muncul");
        boolean result = productPage.productsTitle();

        if (result) {
            test.log(Status.PASS, "Login berhasil, halaman Products tampil");
        } else {
            test.log(Status.FAIL, "Login gagal, halaman Products tidak ditemukan");
        }

        Assertions.assertTrue(result);
    }

    @Order(2)
    @Test
    public void LOG02() {
        test = extent.createTest("LOG02 - Login dengan kredensial tidak valid",
                "Verifikasi user tidak bisa login dengan akun yang salah");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("invalid_user");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("wrong_password");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Verifikasi halaman Products tidak muncul");
        boolean result = productPage.productsTitle();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);
        
        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan, halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil - halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }

    @Order(3)
    @Test
    public void LOG03() {
        test = extent.createTest("LOG03 - Login dengan username kosong",
                "Verifikasi user tidak bisa login tanpa memasukkan username");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        test.log(Status.INFO, "Step 1: Biarkan username kosong");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("secret_sauce");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Verifikasi halaman Products tidak muncul");
        boolean result = productPage.productsTitle();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);

        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan, halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil, halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }

    @Order(4)
    @Test
    public void LOG04() {
        test = extent.createTest("LOG04 - Login dengan password kosong",
                "Verifikasi user tidak bisa login tanpa memasukkan password");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("standard_user");

        test.log(Status.INFO, "Step 2: Biarkan password kosong");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Step 4: Verifikasi halaman Products tidak muncul");
        boolean result = productPage.productsTitle();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);

        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan, halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil, halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }

    @Order(5)
    @Test
    public void LOG05() {
        test = extent.createTest("LOG05 - Logout",
                "Verifikasi user  bisa logout dari aplikasi");

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        test.log(Status.INFO, "Step 1: Login berhasil");
        loginPage.login("standard_user", "secret_sauce");

        test.log(Status.INFO, "Step 2: Klik burger menu");
        productPage.clickBurgerMenu();

        test.log(Status.INFO, "Step 3: Klik Logout");
        productPage.clickLogout();

        test.log(Status.INFO, "Verifikasi halaman Login muncul");
        boolean result = loginPage.loginlogo();

        if (result) {
            test.log(Status.PASS, "Logout berhasil, halaman Login tampil");
        } else {
            test.log(Status.FAIL, "Logout gagal, halaman Login tidak ditemukan");
        }

        Assertions.assertTrue(result);
    }

}
