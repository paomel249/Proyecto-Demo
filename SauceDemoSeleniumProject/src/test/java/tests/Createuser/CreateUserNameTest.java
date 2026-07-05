package tests.Createuser;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import pages.ValidationUserPage;
import utils.DriverFactory;

public class CreateUserNameTest {

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
                    "",
                    "nombrevacio@gmail.com",
                    "123456"
            );

            ValidationUserPage validation = new ValidationUserPage(driver);

            boolean correcto = !validation.obtenerErrorNombre().isEmpty();
            long fin = System.currentTimeMillis();
            double tiempo = (fin - inicio) / 1000.0;

            MetricsRecorder.registrarResultado(
                    "Create User",
                    "Empty Name",
                    correcto ? "SUCCESS" : "FAILED",
                    tiempo
            );

            if(correcto){
                System.out.println("✓ Validación Nombre vacío correcta");

            }else{

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
