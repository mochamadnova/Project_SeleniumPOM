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

        Assertions.assertTrue(result, "Login gagal!");
    }
}
