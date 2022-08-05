package co.com.choucair.proyecto.sura.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class DateUtils {
    private static final String MENSAJE_FALLO_GENERAL = "No se reconoce el numero para generar el mes: ";
    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());


    public static int obtenerYearActualMenos18() {
        LocalDate current_date = LocalDate.now();
        int yearActualMenos18 = current_date.getYear() - Constant.YEAR_A_RESTAR;
        int year = faker.number().numberBetween(Constant.YEAR_INICIAL, yearActualMenos18);
        return year;
    }

    public static String obtenerMes(String monthNum) {
        String MES;
        switch (monthNum) {
            case "1":
                MES = Constant.ENERO;
                return MES;
            case "2":
                MES = Constant.FEBRERO;
                return MES;
            case "3":
                MES = Constant.MARZO;
                return MES;
            case "4":
                MES = Constant.ABRIL;
                return MES;
            case "5":
                MES = Constant.MAYO;
                return MES;
            case "6":
                MES = Constant.JUNIO;
                return MES;
            case "7":
                MES = Constant.JULIO;
                return MES;
            case "8":
                MES = Constant.AGOSTO;
                return MES;
            case "9":
                MES = Constant.SEPTIEMBRE;
                return MES;
            case "10":
                MES = Constant.OCTUBRE;
                return MES;
            case "11":
                MES = Constant.NOVIEMBRE;
                return MES;
            case "12":
                MES = Constant.DICIEMBRE;
                return MES;
            default:
                ManagerLog.imprimirFallo(MENSAJE_FALLO_GENERAL);
                return null;
        }

    }

    public static String formatearFecha(LocalDate actualDate){
        String dia, mes;
        if(actualDate.getDayOfMonth()<10){
            dia = "0"+actualDate.getDayOfMonth();
        }else{
            dia = String.valueOf(actualDate.getDayOfMonth());
        }

        if(actualDate.getMonth().getValue()<10){
            mes = "0"+actualDate.getMonth().getValue();
        }else{
            mes = String.valueOf(actualDate.getMonth().getValue());
        }

        String fecha =  dia+"/"+mes+"/" +actualDate.getYear();
        return fecha;
    }

    public static String obtenerFechaActual(){
        Date fechaActual = new Date();
        LocalDate actualDate = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return formatearFecha(actualDate);
    }



}
