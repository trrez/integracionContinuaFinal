package StepDefinition;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
    WebDriver driver;

    @Given("Abrir Chrome")
    public void abrir_Chrome() {
        System.out.println("En este paso se abre google chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tatia\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8081/ReservaHora/");
    }

    @When("ingresar nombreUsuario {string} y password {string}")
    public void ingresar_nombreUsuario_y_password(String string, String string2) {
        System.out.println("En este paso se ingresan las credenciales del usuario");
        driver.findElement(By.id("nombreUsuario")).sendKeys(string);
        driver.findElement(By.id("password")).sendKeys(string2);
        
    }

    @Then("inicia sesion")
    public void inicia_sesion() {
        System.out.println("En este paso se inicia sesion con los datos ingresados desde el archivo MyTest.feature");
        driver.findElement(By.id("loginbtn")).click();
    }
    
    @And("ingresar a formulario")
    public void ingresar_formlario() {
    	System.out.println("En este paso se abre el formulario");
        driver.findElement(By.id("agendarHorabtn")).click();
    }

    @And("ingresa rut {string}, nombre {string}, apellido {string}, direccion {string}, correo {string}, telefono {int}, nombreMascota {string}")
    public void el_usuario_llena_el_formulario_de_informacion_de_la_mascota(String string, String string2, String string3, String string4, String string5, int int1, String string7) {
        System.out.println("En este paso se ingresan la informacion del dueño");
        driver.findElement(By.id("rut")).sendKeys(string);
        driver.findElement(By.id("nombre")).sendKeys(string2);
        driver.findElement(By.id("apellido")).sendKeys(string3);
        driver.findElement(By.id("direccion")).sendKeys(string4);
        driver.findElement(By.id("correo")).sendKeys(string5);
        driver.findElement(By.id("telefono")).sendKeys(String.valueOf(int1));
        driver.findElement(By.id("nombreMascota")).sendKeys(string7);

        driver.findElement(By.id("siguienterbtn")).click();
    }

    @And("ingresa tipoMascota {string}, edad {int}, nombreMascota {string}, rutDueño {string}")
    public void el_usuario_llena_el_formulario_de_seleccion_de_hora(String string, int int1, String string3, String string4) {
        System.out.println("En este paso se ingresan la informacion de la mascota");
        driver.findElement(By.id("tipoMascota")).sendKeys(string);
        driver.findElement(By.id("edad")).sendKeys(String.valueOf(int1));
        driver.findElement(By.id("nombreMascota")).sendKeys(string3);
        driver.findElement(By.id("rutDueño")).sendKeys(string4);
        driver.findElement(By.id("siguienterbtn")).click();
    }

    @And("ingresa nombreMascota {string}, rutDueño {string}, hora {string}, fecha {string}")
    public void el_usuario_confirma_la_cita_medica(String string, String string2, String string3, String string4) {
    	System.out.println("En este paso se ingresan la información de la hora y fecha");

        driver.findElement(By.id("nombreMascota")).sendKeys(string);
        driver.findElement(By.id("rutDueño")).sendKeys(string3);

        if (string3 != null && !string3.isEmpty()) {
            driver.findElement(By.id("hora")).sendKeys(string3);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
		try {
			fecha = dateFormat.parse(string4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Fecha: " + fecha);


        driver.findElement(By.id("fecha")).sendKeys(dateFormat.format(fecha));
    }
    
    @Then("se registra la hora médica exitosamente")
    public void se_registra_la_hora_medica_exitosamente() {
        driver.findElement(By.id("siguienterbtn")).click();
        System.out.println("En este paso se registra la hora médica exitosamente");
    }
}
