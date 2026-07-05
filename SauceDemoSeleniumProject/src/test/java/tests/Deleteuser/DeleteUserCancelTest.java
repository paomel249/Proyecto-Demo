package tests.Deleteuser;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;

public class DeleteUserCancelTest {

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

            boolean correcto = user.cancelarEliminarUsuario( "usuario2486@gmail.com" );

            long fin = System.currentTimeMillis();
            double tiempo = (fin - inicio) / 1000.0;

            MetricsRecorder.registrarResultado(
                    "Delete User",
                    "Cancel Delete",
                    correcto ? "SUCCESS" : "FAILED",
                    tiempo
            );

            if (correcto) {
                System.out.println("✓ Cancelación de eliminación correcta");
            } else {
                System.out.println("✗ La cancelación falló");

            }
            Thread.sleep(3000);

        }
        finally{
            Thread.sleep(5000);
            driver.quit();
        }
    }
}