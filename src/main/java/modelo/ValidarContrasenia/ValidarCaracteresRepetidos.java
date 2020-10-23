package modelo.ValidarContrasenia;

import modelo.FuncionesUtiles.Utils;

public class ValidarCaracteresRepetidos implements ValidarContrasenia {

    /**
     * Valida que la contraseia no tenga mas de dos caracteres repetidos
     * @param contrasenia
     */
    @Override
    public void validar(String contrasenia) {
        Utils utils = new Utils();

        if(  utils.validarEr(contrasenia,"^[a-zA-Z0-9\\.]*([a-zA-Z0-9\\.])\\1{2,}[a-zA-Z0-9\\.]*$") ){
            throw new ValidarContraseniaException("La clave: "+contrasenia+" no debe repetir mas de dos letras o números de forma consecutiva");
        }

    }
}
