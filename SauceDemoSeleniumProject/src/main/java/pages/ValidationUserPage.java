package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationUserPage {

    WebDriver driver;

    public ValidationUserPage(WebDriver driver) {
        this.driver = driver;
    }

    // MENSAJES DE ERROR

    By mensajeNombre = By.xpath("//input[@placeholder='Nombre completo']/following::p[1]");

    By mensajeEmail = By.xpath("//input[@placeholder='correo@ejemplo.com']/following::p[1]");

    By mensajePassword = By.xpath("//input[@type='password']/following::p[1]");

    // MENSAJE GENERAL (SUCCESS)

    By mensajeExito = By.xpath("//div[contains(@class,'bg-green-50')]");

    // MODAL CREAR

    By modalCrear = By.xpath("//h3[contains(text(),'Nuevo Usuario')]");

    // EL MODAL SIGUE ABIERTO
    public boolean modalAbierto(){
        return driver.findElements(modalCrear).size()>0;
    }

    // USUARIO CREADO
    public boolean usuarioCreado(){
        return driver.findElements(mensajeExito).size()>0;
    }

    // ERROR NOMBRE
    public String obtenerErrorNombre(){

        if(driver.findElements(mensajeNombre).isEmpty())
            return "";

        return driver.findElement(mensajeNombre).getText();

    }

    // ERROR EMAIL
    public String obtenerErrorEmail(){

        if(driver.findElements(mensajeEmail).isEmpty())
            return "";

        return driver.findElement(mensajeEmail).getText();

    }

    // ERROR PASSWORD
    public String obtenerErrorPassword(){

        if(driver.findElements(mensajePassword).isEmpty())
            return "";

        return driver.findElement(mensajePassword).getText();

    }

    // EXISTE ERROR
    public boolean existeError(){

        return
                !obtenerErrorNombre().isEmpty()
                        ||
                        !obtenerErrorEmail().isEmpty()
                        ||
                        !obtenerErrorPassword().isEmpty();

    }

}