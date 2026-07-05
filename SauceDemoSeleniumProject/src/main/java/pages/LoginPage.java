package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    WebDriverWait wait;

    By txtEmail = By.cssSelector("input[type='email']");
    By txtPassword = By.cssSelector("input[type='password']");
    By btnLogin = By.cssSelector("button[type='submit']");

    By mensajeError = By.cssSelector("p.text-red-400");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void ingresarCorreo(String correo){
        driver.findElement(txtEmail).clear();
        driver.findElement(txtEmail).sendKeys(correo);
    }

    public void ingresarPassword(String password){
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void iniciarSesion(){
        driver.findElement(btnLogin).click();
    }

    public void login(String correo,String password){
        ingresarCorreo(correo);
        ingresarPassword(password);
        iniciarSesion();
    }

    public String obtenerMensajeError(){

        try{
            wait.until( ExpectedConditions.visibilityOfElementLocated(mensajeError));
            return driver.findElement(mensajeError).getText();

        }

        catch(Exception e){
            return "";

        }

    }

    public boolean loginExitoso(){

        wait.until(driver ->
                !driver.getCurrentUrl().contains("/login")
                        || obtenerMensajeError().length()>0
        );

        return !driver.getCurrentUrl().contains("/login");

    }
}