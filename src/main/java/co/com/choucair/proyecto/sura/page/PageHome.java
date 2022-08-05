package co.com.choucair.proyecto.sura.page;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends PageObject {

    @FindBy(xpath = "//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[contains(text(),'Women')]")
    private WebElement txt_home;

    @FindBy(xpath = "//*[@class='login']")
    private WebElement input_login;

    @FindBy(xpath = "//*[@id='center_column']/p")
    private WebElement txt_cuenta_creada_exitosa;

    public WebElement getTxt_home() {  return txt_home;  }
    public WebElement getInput_login() {  return input_login;  }
    public WebElement getTxt_cuenta_creada_exitosa() {  return txt_cuenta_creada_exitosa;  }

}
