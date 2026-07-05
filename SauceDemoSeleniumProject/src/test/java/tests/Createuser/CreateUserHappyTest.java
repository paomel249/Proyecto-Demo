package tests.Createuser;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import pages.ValidationUserPage;
import utils.DriverFactory;

public class CreateUserHappyTest {

    public static void main(String[] args) throws InterruptedException {

        long inicio = System.currentTimeMillis();
        WebDriver driver = DriverFactory.createDriver();

        try{

            LoginPage login = new LoginPage(driver);

            login.login(
                    "asd@gmail.com",
                    "123123"
            );

            UserPage users = new UserPage(driver);

            users.crearUsuario(
                    "Usuario Selenium",
                    "usuario2486@gmail.com",
                    "123456"

            );

            ValidationUserPage validation =
                    new ValidationUserPage(driver);

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;

                System.out.println("Usuario creado.");
                MetricsRecorder.registrarResultado(
                        "Create User",
                        "Happy Path",
                        "SUCCESS",
                        tiempo
                );

            Thread.sleep(3000);
        }

        catch(Exception e){
            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;
            MetricsRecorder.registrarResultado(
                    "Create User",
                    "Happy Path",
                    "FAILED",
                    tiempo
            );

            e.printStackTrace();

        }
        finally{
            Thread.sleep(5000);
            driver.quit();
        }
    }
}