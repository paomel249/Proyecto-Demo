package tests.Login;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginPasswordTest {

    public static void main(String[] args)
            throws InterruptedException {

        long inicio = System.currentTimeMillis();
        WebDriver driver = DriverFactory.createDriver();

        try{

            LoginPage login = new LoginPage(driver);
            login.login(
                    "asd@gmail.com",
                    "123"
            );

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;
            String mensaje = login.obtenerMensajeError();

            if(mensaje.contains("6 caracteres")){

                MetricsRecorder.registrarResultado(
                        "login",
                        "password_corta",
                        "success",
                        tiempo
                );

            }else{

                MetricsRecorder.registrarResultado(
                        "login",
                        "password_corta",
                        "failed",
                        tiempo
                );
            }
        }

        finally{
            Thread.sleep(5000);
            driver.quit();
        }

    }
}