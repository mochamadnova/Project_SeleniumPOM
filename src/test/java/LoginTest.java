import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import com.aventstack.extentreports.Status;


public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        test = extent.createTest("Login dengan kredensial valid",
                "Verifikasi user bisa login dengan akun standard_user");

        LoginPage loginPage = new LoginPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("standard_user");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("secret_sauce");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Step 4: Verifikasi halaman Products muncul");
        boolean result = loginPage.isLoginSuccessful();

        if (result) {
            test.log(Status.PASS, "Login berhasil - halaman Products tampil");
        } else {
            test.log(Status.FAIL, "Login gagal - halaman Products tidak ditemukan");
        }

        Assertions.assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {
        test = extent.createTest("Login dengan kredensial tidak valid",
                "Verifikasi user tidak bisa login dengan akun yang salah");

        LoginPage loginPage = new LoginPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("invalid_user");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("wrong_password");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Step 4: Verifikasi halaman Products tidak muncul");
        boolean result = loginPage.isLoginSuccessful();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);
        
        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan - halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil - halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }

    @Test
    public void testEmptyUsername() {
        test = extent.createTest("Login dengan username kosong",
                "Verifikasi user tidak bisa login tanpa memasukkan username");

        LoginPage loginPage = new LoginPage(driver);

        test.log(Status.INFO, "Step 1: Biarkan username kosong");

        test.log(Status.INFO, "Step 2: Masukkan password");
        loginPage.enterPassword("secret_sauce");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Step 4: Verifikasi halaman Products tidak muncul");
        boolean result = loginPage.isLoginSuccessful();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);

        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan - halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil - halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {
        test = extent.createTest("Login dengan password kosong",
                "Verifikasi user tidak bisa login tanpa memasukkan password");

        LoginPage loginPage = new LoginPage(driver);

        test.log(Status.INFO, "Step 1: Masukkan username");
        loginPage.enterUsername("standard_user");

        test.log(Status.INFO, "Step 2: Biarkan password kosong");

        test.log(Status.INFO, "Step 3: Klik tombol login");
        loginPage.clickLogin();

        test.log(Status.INFO, "Step 4: Verifikasi halaman Products tidak muncul");
        boolean result = loginPage.isLoginSuccessful();

        String errorText = loginPage.ErrorMessage();
        test.log(Status.PASS, "Terdapat error message = " + errorText);

        if (!result) {
            test.log(Status.PASS, "Login gagal sesuai harapan - halaman Products tidak tampil");
        } else {
            test.log(Status.FAIL, "Login berhasil - halaman Products ditemukan padahal seharusnya gagal");
        }

        Assertions.assertFalse(result);
    }
}
