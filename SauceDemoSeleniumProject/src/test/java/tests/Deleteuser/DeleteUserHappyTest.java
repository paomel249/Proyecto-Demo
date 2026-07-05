package tests.Deleteuser;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.UserPage;
import utils.DriverFactory;

public class DeleteUserHappyTest {

    public static void main(String[] args) throws InterruptedException {

        long inicio = System.currentTimeMillis();
        WebDriver driver = DriverFactory.createDriver();

        try{

            LoginPage login = new LoginPage(driver);

            login.login(
                    "asd@gmail.com",
                    "123123"
            );

            UserPage user = new UserPage(driver);

            user.eliminarUsuario(
                    "usuario@gmail.com"
            );

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;

                System.out.println("Usuario eliminado.");

                MetricsRecorder.registrarResultado(
                        "Delete User",
                        "Happy Path",
                        "SUCCESS",
                        tiempo
                );

            Thread.sleep(3000);
        }

        catch(Exception e){

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;
            MetricsRecorder.registrarResultado(
                    "Delete User",
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