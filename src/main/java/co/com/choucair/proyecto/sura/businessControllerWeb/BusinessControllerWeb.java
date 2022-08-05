package co.com.choucair.proyecto.sura.businessControllerWeb;

import co.com.choucair.proyecto.sura.helpers.*;
import co.com.choucair.proyecto.sura.page.PageHome;
import co.com.choucair.proyecto.sura.page.PagePreRegistro;
import co.com.choucair.proyecto.sura.page.PageRegistro;
import com.github.javafaker.Faker;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.util.Locale;
import java.util.Random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BusinessControllerWeb extends UIInteractionSteps {

    private static final String LOG_CLASE = "BusinessControllerWeb -> ";
    private static final String OCURRIO_ERROR_NAVEGADOR_OPEN = " Ocurrió un error al abrir el navegador: ";
    private static final String OCURRIO_ERROR_NAVEGADOR_CLOSE = " Ocurrió un error al cerrar el navegador: ";
    private static final String MENSAJE_FALLO_GENERAL = "Ocurrió un error en el metodo: ";
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());
    private static Faker fakerUS = new Faker();
    private String correo;
    private EnvironmentVariables environmentVariables;
    PageHome pageHome;
    PagePreRegistro pagePreRegistro;
    PageRegistro pageRegistro;



    @Step
    public void abrirNavegadorURL() {
        final String METODO = " -> abrirNavegadorURL";
        try {
            String paginawebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constant.PAGINA_WEB_URL);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            getDriver().navigate().to(paginawebUrl);

            ManagerLog.imprimirExito("Se abrio el navegador web url");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + OCURRIO_ERROR_NAVEGADOR_OPEN + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void cerrarNavegador() {
        final String METODO = " -> cerrarNavegador";
        try {
            getDriver().close();
            ManagerLog.imprimirExito("Se cerro el navegador web");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + OCURRIO_ERROR_NAVEGADOR_CLOSE + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void abrirModuloRegistrarse() {
        final String METODO = " -> abrirModuloRegistrarse";
        try {
            Time.waiting(Constant.SHORT);
            pageHome.getInput_login().click();
            ManagerLog.imprimirExito("el usuario hace clic en el boton registrarse");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void ingresarCorreoElectronico() {
        final String METODO = " -> ingresarCorreoElectronico";
        try {
            Time.waiting(Constant.SHORT);
            correo = faker.internet().emailAddress().replace(" ", "_");
            pagePreRegistro.getInput_correo_electronico().sendKeys(correo);
            pagePreRegistro.getButton_crear_cuenta().click();
            Thread.sleep(7000);
            ManagerLog.imprimirExito("el usuario ingresa un correo valido");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void llenarFormularioInformacionPersonal() {
        final String METODO = " -> llenarFormularioInformacioPersonal";
        try {
            Actions actions = new Actions(getDriver());
            Time.waiting(Constant.SHORT);
            int num = faker.number().numberBetween(Constant.DATO_MR, Constant.DATO_MRS);
            pageRegistro.checkButton_Seleccione_Title(num).click();
            pageRegistro.getInput_Nombres().sendKeys(faker.name().firstName());
            pageRegistro.getInput_Apellidos().sendKeys(faker.name().lastName());
            actions.moveToElement(pageRegistro.getInput_email()).doubleClick();
            pageRegistro.getInput_email().click();
            String validarCorreo = pageRegistro.getInput_email().getText();
            assertThat(correo, containsString(validarCorreo));
            pageRegistro.getInput_pwd().sendKeys(faker.internet().password());
            selectYear();
            selectMonth();
            selectDay();
            seleccionaCheckBoxBoletinYOferta();
            ManagerLog.imprimirExito("el usuario llena de forma correcta y completa el formulario de datos personales");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    private void selectYear() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        try {
            int year = DateUtils.obtenerYearActualMenos18();
            String selectDownList_Year = Constant.LOCALIZADOR_YEAR;
            getDriver().findElement(By.xpath(selectDownList_Year)).click();
            pageRegistro.dateYear(year).click();
            ManagerLog.imprimirExito("el usuario selecciona el año de cumpleaños " + year);
        } catch (Exception e) {
            ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    private void selectMonth() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        try {
            String selectDownList_Month = Constant.LOCALIZADOR_MOUNTH;
            getDriver().findElement(By.xpath(selectDownList_Month)).click();
            int num = faker.number().numberBetween(Constant.DATO_MOUNTH_INICIAL, Constant.DATO_MOUNTH_FINAL);
            String numMounth = DateUtils.obtenerMes(String.valueOf(num));
            pageRegistro.dateMonth(numMounth).click();
            ManagerLog.imprimirExito("el usuario selecciona el mes de cumpleaños: " + numMounth);
        } catch (Exception e) {
            ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    private void selectDay() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        try {
            String selectDownList_Day = Constant.LOCALIZADOR_DAY;
            getDriver().findElement(By.xpath(selectDownList_Day)).click();
            int num = faker.number().numberBetween(Constant.DATO_DAY_INICIAL, Constant.DATO_DAY_FINAL);
            pageRegistro.dateDay(num).click();
            ManagerLog.imprimirExito("el usuario selecciona el dia de cumpleaños: " + num);
        } catch (Exception e) {
            ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    private void seleccionaCheckBoxBoletinYOferta() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        try {
            String checkBox_Boletin = Constant.LOCALIZADOR_BOLETIN;
            String checkBox_Oferta = Constant.LOCALIZADOR_OFERTA;
            getDriver().findElement(By.id(checkBox_Boletin)).click();
            getDriver().findElement(By.id(checkBox_Oferta)).click();
            ManagerLog.imprimirExito("el usuario selecciona los checBox de boletin y oferta");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }


    @Step
    public void llenarFormularioDireccion() {
        final String METODO = " -> llenarFormularioDireccion";
        try {
            pageRegistro.getInput_Empresa().sendKeys(faker.company().name());
            pageRegistro.getInput_Direccion_principal().sendKeys(faker.address().fullAddress());
            pageRegistro.getInput_Direccion_secundaria().sendKeys(faker.address().fullAddress());
            pageRegistro.getInput_ciudad().sendKeys(fakerUS.address().cityName());
            seleccionaEstadoUS();
            pageRegistro.getInput_comentarios().sendKeys(Constant.FRM_DIRECCIONES_AGREGAR_COMENTARIOS + DateUtils.obtenerFechaActual());
            pageRegistro.getInput_codigo_postal().sendKeys(Constant.CODIGO_POSTAL);
            pageRegistro.getInput_telefono().sendKeys(fakerUS.phoneNumber().cellPhone());
            pageRegistro.getInput_telefono_movil().sendKeys(fakerUS.phoneNumber().cellPhone());
            pageRegistro.getInput_alias_direccion().clear();
            pageRegistro.getInput_alias_direccion().sendKeys(faker.pokemon().name());
            ManagerLog.imprimirExito("el usuario llena de forma correcta y completa el formulario de sus direcciones");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    private void seleccionaEstadoUS() {
        final String METODO = LOG_CLASE + Thread.currentThread().getStackTrace()[1].getMethodName() + " -> ";
        try {
            String selectDownList_Estado = Constant.LOCALIZADOR_ESTADO;
            getDriver().findElement(By.id(selectDownList_Estado)).click();
            int numEstado = faker.number().numberBetween(Constant.DATO_ESTADO_INICIAL, Constant.DATO_ESTADO_FINAL);
            pageRegistro.selectDownOption_Estado(numEstado).click();
            ManagerLog.imprimirExito("el usuario selecciona algunos de los estados de US de forma correcta");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void crearCuenta() {
        final String METODO = " -> crearCuenta";
        try {
            pageRegistro.getButton_Registro().click();
            ManagerLog.imprimirExito("el usuario ciclea el boton crear cuenta");
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO + AssertExceptions.getErrorStackTrace(e));
        }
    }

}
