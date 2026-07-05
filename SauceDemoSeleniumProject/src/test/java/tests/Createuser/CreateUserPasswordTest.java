package tests.Createuser;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import pages.ValidationUserPage;
import utils.DriverFactory;

public class CreateUserPasswordTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver();
        long inicio = System.currentTimeMillis();

        try {

            LoginPage login = new LoginPage(driver);
            login.login(
                    "asd@gmail.com",
                    "123123"
            );

            UserPage user = new UserPage(driver);
            user.crearUsuario(
                    "Paola",
                    "passwordcorta@gmail.com",
                    "12"
            );

            ValidationUserPage validation = new ValidationUserPage(driver);

            boolean correcto = !validation.obtenerErrorPassword().isEmpty();
            long fin = System.currentTimeMillis();
            double tiempo = (fin - inicio) / 1000.0;

            MetricsRecorder.registrarResultado(
                    "Create User",
                    "Short Password",
                    correcto ? "SUCCESS" : "FAILED",
                    tiempo
            );

            if (correcto) {
                System.out.println("✓ Validación Password corta correcta");
            } else {
                System.out.println("✗ No apareció la validación");
            }
            Thread.sleep(3000);

        }
        finally{
            Thread.sleep(5000);
            driver.quit();
        }
    }
}