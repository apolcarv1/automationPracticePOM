package co.com.choucair.proyecto.sura.page;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageRegistro extends PageObject {


    @FindBy(css= ".account_creation:nth-child(1) > .page-subheading")
    private WebElement text_informacion_personal;

    @FindBy(id =  "customer_firstname")
    private WebElement input_Nombres;

    @FindBy(id = "customer_lastname")
    private WebElement input_Apellidos;

    @FindBy(id = "email")
    private WebElement input_email;

    @FindBy(id = "passwd")
    private WebElement input_pwd;

    @FindBy(id = "newsletter")
    private WebElement checkButton_TyC_boletin;

    @FindBy(id = "optin")
    private WebElement checkButton_Ofert;

    public WebElement getText_informacion_personal() {  return text_informacion_personal;  }
    public WebElement getInput_Nombres() {  return input_Nombres;  }
    public WebElement getInput_Apellidos() {  return input_Apellidos;  }
    public WebElement getInput_email() {  return input_email;  }
    public WebElement getInput_pwd() {  return input_pwd;  }
    public WebElement getCheckButton_TyC_boletin() {  return checkButton_TyC_boletin;  }
    public WebElement getCheckButton_Ofert() {  return checkButton_Ofert;  }


    public WebElement checkButton_Seleccione_Title(int item) {
        String xpath = "//*[@id='uniform-id_gender"+item+"']";
        return  find(xpath);
    }

    public WebElement dateDay(int day) {
        String xpath = "//*[@id='days']//*[contains(text(),'"+day+"')]";
        return  find(xpath);
    }

    public WebElement dateMonth(String month) {
        String xpath = "//*[@id='months']//*[contains(text(),'"+month+"')]";
        return  find(xpath);
    }

    public WebElement dateYear(int year) {
        String xpath = "//*[@id='years']//*[contains(text(),'"+year+"')]";
        return  find(xpath);
    }

    /** Localizadores del formulario informacion Direccion */

    @FindBy(id = "company")
    private WebElement input_Empresa;

    @FindBy(id = "address1")
    private WebElement input_Direccion_principal;

    @FindBy(id = "address2")
    private WebElement input_Direccion_secundaria;

    @FindBy(id = "id_state")
    private WebElement selectDownList_Estado;

    @FindBy(id = "city")
    private WebElement input_ciudad;

    @FindBy(id = "postcode")
    private WebElement input_codigo_postal;

    @FindBy(xpath = "//*[@id='id_country']/option[2]")
    private WebElement selectDownOption_Pais;

    @FindBy(id = "other")
    private WebElement input_comentarios;

    @FindBy(id = "phone")
    private WebElement input_telefono;

    @FindBy(id = "phone_mobile")
    private WebElement input_telefono_movil;

    @FindBy(id = "alias")
    private WebElement input_alias_direccion;

    @FindBy(id = "submitAccount")
    private WebElement button_Registro;

    public WebElement getInput_Empresa() {  return input_Empresa;  }
    public WebElement getInput_Direccion_principal() {  return input_Direccion_principal;  }
    public WebElement getInput_Direccion_secundaria() {  return input_Direccion_secundaria;  }
    public WebElement getInput_ciudad() {  return input_ciudad;  }
    public WebElement getSelectDownList_Estado() {  return selectDownList_Estado;  }
    public WebElement getInput_codigo_postal() {  return input_codigo_postal;  }
    public WebElement getSelectDownOption_Pais() {  return selectDownOption_Pais;  }
    public WebElement getInput_comentarios() {  return input_comentarios;  }
    public WebElement getInput_telefono() {  return input_telefono;  }
    public WebElement getInput_telefono_movil() {  return input_telefono_movil;  }
    public WebElement getInput_alias_direccion() {  return input_alias_direccion;  }
    public WebElement getButton_Registro() {  return button_Registro;  }


    public WebElement selectDownOption_Estado(int estado) {
        String xpath = "//*[@id='id_state']/option["+estado+"]"; /** Desde el 2 hasta el 54 debe ir en el int estado* es la cantidad de estados a un pais que aparecen */
        return  find(xpath);
    }

}
