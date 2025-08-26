package starter.duckduckgo;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormActions extends PageObject {

    public void openHomePage() {
        getDriver().get("https://sebass.infinityfreeapp.com");
    }

    public void registerUser(String nombre, String apellido, String correo, String fechaNacimiento,
                             String departamento, String ciudad, String genero, String carrera) {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("nombre"))).sendKeys(nombre);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("apellido"))).sendKeys(apellido);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("correo"))).sendKeys(correo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fecha_nacimiento"))).sendKeys(fechaNacimiento);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("departamento"))).sendKeys(departamento);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ciudad"))).sendKeys(ciudad);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("genero"))).sendKeys(genero);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("carrera"))).sendKeys(carrera);

        if (driver.findElements(By.id("agregar")).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("agregar"))).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Agregar') or @value='Agregar']"))).click();
        }
    }

    public boolean pageContainsTextVisible(String texto) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.tagName("body"), texto
            ));
        } catch (Exception e) {
            System.out.println("No se encontró el texto: " + texto);
            System.out.println("Contenido actual de la página:");
            System.out.println(getDriver().getPageSource());
            return false;
        }
    }
}
