package modelo.FuncionesUtiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Coleccion de funciones útiles
 */
public class Utils {

    /**
     * Valida si se aplica la expresionRegular en la palabra
     * @param palabra
     * @param expresionRegular
     * @return
     */
    public boolean validarEr(String palabra, String expresionRegular){

        return Pattern.matches(expresionRegular, palabra);
        /*
        Pattern pattern = compile(expresionRegular);
        Matcher matcher = pattern.matcher(palabra);
        return matcher.matches();
*/
    }
}
