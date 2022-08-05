package co.com.choucair.proyecto.sura.businessControllerQuestions;

import co.com.choucair.proyecto.sura.helpers.AssertExceptions;
import co.com.choucair.proyecto.sura.helpers.Constant;
import co.com.choucair.proyecto.sura.helpers.ManagerLog;
import co.com.choucair.proyecto.sura.helpers.Time;
import co.com.choucair.proyecto.sura.page.PageHome;
import co.com.choucair.proyecto.sura.page.PagePreRegistro;
import co.com.choucair.proyecto.sura.page.PageRegistro;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BusinessControllerComparation extends UIInteractionSteps {

    private static final String LOG_CLASE = "BusinessControllerComparation -> ";
    private static final String MENSAJE_FALLO_GENERAL = "Ocurrió un error en el metodo de validacion: ";
    private static final String MENSAJE_VALIDACION_EXITOSO_GENERAL = "Se encontro el texto esperado: ";
    PageHome pageHome;
    PagePreRegistro pagePreRegistro;
    PageRegistro pageRegistro;

    @Step
    public void validarHomeUI() {
        final String METODO_VALIDACION = " -> validarHomeUI";
        try {
            Time.waiting(Constant.SHORT);
            String textoPagCargada = Constant.TEXTO_PAG_CARGADA;
            String validarPagCargada = pageHome.getTxt_home().getText();
            if (pageHome.getTxt_home().isDisplayed()){
                assertThat(textoPagCargada, containsString(validarPagCargada));
                ManagerLog.imprimirExito(MENSAJE_VALIDACION_EXITOSO_GENERAL + validarPagCargada + METODO_VALIDACION);
            }
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO_VALIDACION + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void validartextoCrearCuentaUI() {
        final String METODO_VALIDACION = " -> validartextoCrearCuentaUI";
        try {
            Time.waiting(Constant.SHORT);
            String textoCrearCuenta = Constant.TEXTO_PAG_CREAR_CUENTA;
            String validarPagCargada = pagePreRegistro.getText_crear_cuenta().getText();
            if (pagePreRegistro.getText_crear_cuenta().isDisplayed()){
                assertThat(textoCrearCuenta, containsString(validarPagCargada));
                ManagerLog.imprimirExito(MENSAJE_VALIDACION_EXITOSO_GENERAL + validarPagCargada + METODO_VALIDACION);
            }
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO_VALIDACION + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void validartextoCrearRegistroUI() {
        final String METODO_VALIDACION = " -> validartextoCrearRegistroUI";
        try {
            Time.waiting(Constant.MIDDLE);
            String textoCrearRegistro = Constant.TEXTO_PAG_REGISTRO;
            String validarPagCargada = pageRegistro.getText_informacion_personal().getText();
            if (pageRegistro.getText_informacion_personal().isDisplayed()){
                assertThat(textoCrearRegistro, containsString(validarPagCargada));
                ManagerLog.imprimirExito(MENSAJE_VALIDACION_EXITOSO_GENERAL + validarPagCargada + METODO_VALIDACION);
            }
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO_VALIDACION + AssertExceptions.getErrorStackTrace(e));
        }
    }

    @Step
    public void validarCuentaCreadaConExitoUI() {
        final String METODO_VALIDACION = " -> validarHomeUI";
        try {
            Time.waiting(Constant.SHORT);
            String textoPagCargada = Constant.TEXTO_CUENTA_CREADA_EXITOSA;
            String validarCuentaCreadaExitosa = pageHome.getTxt_cuenta_creada_exitosa().getText();
            if (pageHome.getTxt_cuenta_creada_exitosa().isDisplayed()){
                assertThat(textoPagCargada, containsString(validarCuentaCreadaExitosa));
                ManagerLog.imprimirExito(MENSAJE_VALIDACION_EXITOSO_GENERAL + validarCuentaCreadaExitosa + METODO_VALIDACION);
            }
        } catch (Exception e) {
            ManagerLog.imprimirFallo(LOG_CLASE + MENSAJE_FALLO_GENERAL + METODO_VALIDACION + AssertExceptions.getErrorStackTrace(e));
        }
    }
}