package co.com.choucair.proyecto.sura.page;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePreRegistro extends PageObject {


    @FindBy(css = "#create-account_form > .page-subheading")
    private WebElement text_crear_cuenta;

    @FindBy(id = "email_create")
    private WebElement input_correo_electronico;

    @FindBy(id = "SubmitCreate")
    private WebElement button_crear_cuenta;


    public WebElement getText_crear_cuenta() {  return text_crear_cuenta;  }
    public WebElement getInput_correo_electronico() {  return input_correo_electronico;  }
    public WebElement getButton_crear_cuenta() {  return button_crear_cuenta;  }


}
