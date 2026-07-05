package tests;

import metrics.MetricsManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;

public class ModuleUserTest {

    public static void main(String[] args)
            throws InterruptedException {

        // Se inicia una prueba
        MetricsManager.pruebasEjecutadas.inc();
        WebDriver driver = DriverFactory.createDriver();

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(
                    "asd@gmail.com",
                    "123123"
            );

            Thread.sleep(3000);
            UserPage userPage = new UserPage(driver);

            // CREAR
            userPage.crearUsuario(
                    "Paola Melani",
                    "paolamelani@gmail.com",
                    "123456"
            );

            Thread.sleep(3000);

            // ELIMINAR
            userPage.eliminarUsuario(
                    "paolamelani56@gmail.com"
            );



        } catch (Exception e) {



        } finally {

            driver.quit();

        }

        System.out.println("Abre http://localhost:9091/metrics");
        Thread.sleep(60000);

    }
}