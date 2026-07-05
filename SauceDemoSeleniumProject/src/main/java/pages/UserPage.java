package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {

    WebDriver driver;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Botones principales
    By btnNuevoUsuario = By.xpath("//button[contains(.,'Nuevo Usuario')]");
    By btnCrearUsuario = By.xpath("//button[contains(.,'Crear Usuario')]");
    By btnEliminarConfirmacion = By.xpath("//button[contains(.,'Eliminar')]");
    By btnCancelarEliminar = By.xpath("//button[contains(text(),'Cancelar')]");

    // Inputs
    By txtNombre = By.xpath("//input[@placeholder='Nombre completo']");
    By txtEmail = By.xpath("//input[@placeholder='correo@ejemplo.com']");
    By txtPassword = By.xpath("(//input[@type='password'])[1]");

    // Modales
    By modalCrear = By.xpath("//h3[contains(text(),'Nuevo Usuario')]");
    By modalEliminar = By.xpath("//h3[contains(text(),'¿Eliminar usuario?')]");

    //================ MODAL CREAR ABIERTO =================
    public boolean modalCrearAbierto() {
        return driver.findElements(modalCrear).size() > 0;
    }

    //================ ABRIR MODAL CREAR =================
    public void abrirCrearUsuario(){
        if(!modalCrearAbierto()){
            wait.until(ExpectedConditions.elementToBeClickable(btnNuevoUsuario)) .click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(txtNombre));
        }
    }

    //================ LLENAR FORMULARIO =================
    public void llenarFormulario(String nombre,String email, String password){


        WebElement nombreInput = driver.findElement(txtNombre);
        nombreInput.clear();
        nombreInput.sendKeys(nombre);

        WebElement emailInput = driver.findElement(txtEmail);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(txtPassword);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    //================ GUARDAR =================
    public boolean guardarUsuario(){

        wait.until(ExpectedConditions.elementToBeClickable(btnCrearUsuario)) .click();

        try{
            Thread.sleep(500);
        }catch(Exception e){}

        return !modalCrearAbierto();
    }

    // ==================== CREAR ====================
    public boolean crearUsuario(String nombre, String email, String password) {
        abrirCrearUsuario();
        llenarFormulario( nombre, email, password );
        return guardarUsuario();
    }

    // ==================== ELIMINAR ====================
    public void eliminarUsuario(String email) {

        By btnEliminarFila = By.xpath( "//td[contains(text(),'" + email + "')]/following-sibling::td//button[@title='Eliminar']"
        );

        wait.until( ExpectedConditions.elementToBeClickable(btnEliminarFila)) .click();
        wait.until( ExpectedConditions.elementToBeClickable(btnEliminarConfirmacion)) .click();
    }

    private void abrirEliminar(String email){

        By btnEliminarFila = By.xpath("//td[contains(text(),'" + email +
                        "')]/following-sibling::td//button[@title='Eliminar']");

        wait.until( ExpectedConditions.elementToBeClickable(btnEliminarFila)).click();

        wait.until( ExpectedConditions.visibilityOfElementLocated(modalEliminar));
    }

    public boolean cancelarEliminarUsuario(String email){

        abrirEliminar(email);

        wait.until( ExpectedConditions.elementToBeClickable(btnCancelarEliminar)).click();

        try{
            Thread.sleep(1000);
        }catch(Exception e){}

        return driver.findElements(modalEliminar).isEmpty();

    }
}