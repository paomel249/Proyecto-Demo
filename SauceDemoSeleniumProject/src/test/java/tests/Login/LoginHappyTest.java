package tests.Login;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginHappyTest {

    public static void main(String[] args)
            throws InterruptedException {

        long inicio = System.currentTimeMillis();
        WebDriver driver = DriverFactory.createDriver();

        try{

            LoginPage login = new LoginPage(driver);
            login.login(
                    "asd@gmail.com",
                    "123123"
            );

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;
            if(login.loginExitoso()){

                MetricsRecorder.registrarResultado(
                        "login",
                        "happy",
                        "success",
                        tiempo
                );

            }else{

                MetricsRecorder.registrarResultado(
                        "login",
                        "happy",
                        "failed",
                        tiempo
                );
            }
        }

        catch(Exception e){
            double tiempo =
                    (System.currentTimeMillis()-inicio)/1000.0;
                    MetricsRecorder.registrarResultado(
                    "login",
                    "happy",
                    "failed",
                    tiempo
            );
        }

        finally{
            Thread.sleep(500000);
            driver.quit();
        }
    }
}