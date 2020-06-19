package modelo.ValidarContrasenia;

import modelo.FuncionesUtiles.Utils;

public class ValidarUnNumeroUnaLetra implements ValidarContrasenia {

    /**
     * Valida que la constrasenia tenga al menos undigito y una clave
     * @param contrasenia
     */
    @Override
    public void validar(String contrasenia) {
        Utils utils = new Utils();

        if( !utils.validarEr(contrasenia,"^(?:[0-9]+[a-zA-Z0-9]|[a-zA-Z]+[0-9])[a-zA-Z0-9]*$") ){
            throw new ValidarContraseniaException("La clave debe tener al menos un número y una letra");
        }

    }
}
