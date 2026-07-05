package tests.Login;

import metrics.MetricsRecorder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginCorreoIncorrectoTest {

    public static void main(String[] args)
            throws InterruptedException {

        long inicio = System.currentTimeMillis();
        WebDriver driver = DriverFactory.createDriver();

        try{

            LoginPage login = new LoginPage(driver);
            login.login(
                    "correo_incorrecto@gmail.com",
                    "123456"
            );

            double tiempo = (System.currentTimeMillis()-inicio)/1000.0;
            String mensaje = login.obtenerMensajeError();

            if(mensaje.equals("Las credenciales no son correctas.")){

                MetricsRecorder.registrarResultado(
                        "login",
                        "correo_incorrecto",
                        "success",
                        tiempo
                );

            }else{

                MetricsRecorder.registrarResultado(
                        "login",
                        "correo_incorrecto",
                        "failed",
                        tiempo
                );
            }
        }

        finally{
            Thread.sleep(500000);
            driver.quit();
        }
    }
}