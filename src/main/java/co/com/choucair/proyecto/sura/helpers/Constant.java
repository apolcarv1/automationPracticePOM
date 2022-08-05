package co.com.choucair.proyecto.sura.helpers;

public class Constant {

    private Constant(){}


    /** CONFIGURACIONES_BASICAS */

    public static final String PAGINA_WEB_URL = "environments.default.webdriver.base.url";

    /** TIEMPOS_DE_ESPERAS */
    public static final int LONG = 60;
    public static final int MIDDLE = 10;
    public static final int SHORT = 5;

    /** TEXTO ESPERADOS A VALIDAR */
    public static final String TEXTO_PAG_CARGADA = "WOMEN";
    public static final String TEXTO_PAG_CREAR_CUENTA = "CREATE AN ACCOUNT";
    public static final String TEXTO_PAG_REGISTRO = "YOUR PERSONAL INFORMATION";
    public static final String TEXTO_CUENTA_CREADA_EXITOSA = "Welcome to your account. Here you can manage all of your personal information and orders.";


    /** DATE DIAS */
    public static final String LOCALIZADOR_DAY= "//*[@id='days']";
    public static final int DATO_DAY_INICIAL = 1;
    public static final int DATO_DAY_FINAL = 31;

    /** DATE MESES */
    public static final String LOCALIZADOR_MOUNTH= "//*[@id='months']";
    public static final int DATO_MOUNTH_INICIAL = 1;
    public static final int DATO_MOUNTH_FINAL = 12;
    public static final String ENERO = "January";
    public static final String FEBRERO = "February";
    public static final String MARZO = "March";
    public static final String ABRIL = "April";
    public static final String MAYO = "May";
    public static final String JUNIO = "June";
    public static final String JULIO = "July";
    public static final String AGOSTO = "August";
    public static final String SEPTIEMBRE = "September";
    public static final String OCTUBRE = "October";
    public static final String NOVIEMBRE = "November";
    public static final String DICIEMBRE = "December";

    /** DATE AÑOS  */
    public static final int YEAR_INICIAL = 1900;
    public static final int YEAR_A_RESTAR = 18;
    public static final String LOCALIZADOR_YEAR = "//*[@id='years']";

    /** FORMULARIO DATOS PERSONALES */
    public static final int DATO_MR = 1;
    public static final int DATO_MRS = 2;
    public static final String LOCALIZADOR_BOLETIN = "newsletter";
    public static final String LOCALIZADOR_OFERTA = "optin";

    /** FORMULARIO SU DIRECCION */
    public static final int DATO_ESTADO_INICIAL = 2;
    public static final int DATO_ESTADO_FINAL = 54;
    public static final String FRM_DIRECCIONES_AGREGAR_COMENTARIOS = "Hola soy el robot Apolcarv pero tambien me dicen Apolo, dejo este comentario como informacion adicional porque asi me programaron... SALUDOS, ";
    public static final String CODIGO_POSTAL = "00000";
    public static final String LOCALIZADOR_ESTADO = "id_state";
}
