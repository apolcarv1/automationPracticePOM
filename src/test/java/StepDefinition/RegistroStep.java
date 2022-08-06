package StepDefinition;

import co.com.choucair.proyecto.sura.businessControllerQuestions.BusinessControllerComparation;
import co.com.choucair.proyecto.sura.businessControllerWeb.BusinessControllerWeb;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegistroStep {

    @Steps
    BusinessControllerWeb businessControllerWeb;
    BusinessControllerComparation businessControllerComparation;

    @Given("que el usuario ingresa a la pagina automation practice para la creacion de una cuenta")
    public void queElUsuarioIngresaALaPaginaAutomationPracticeParaLaCreacionDeUnaCuenta() {
        businessControllerWeb.abrirNavegadorURL();
        businessControllerComparation.validarHomeUI();
    }


    @When("^ingresa el modulo de registro y llena todo el formulario de datos personas y direccion$")
    public void ingresaElModuloDeRegistroYLlenaTodoElFormularioDeDatosPersonasYDireccion() {
        businessControllerWeb.abrirModuloRegistrarse();
        businessControllerComparation.validartextoCrearCuentaUI();
        businessControllerWeb.ingresarCorreoElectronico();
        businessControllerComparation.validartextoCrearRegistroUI();
        businessControllerWeb.llenarFormularioInformacionPersonal();
        businessControllerWeb.llenarFormularioDireccion();
        businessControllerWeb.crearCuenta();
    }

    @Then("^el usuario crea su cuenta automationpractice con exito$")
    public void elUsuarioCreaSuCuentaAutomationpracticeConExito() {
     businessControllerComparation.validarCuentaCreadaConExitoUI();
    }

    @After
    public void finalizar() {
        businessControllerWeb.cerrarNavegador();
    }

}
