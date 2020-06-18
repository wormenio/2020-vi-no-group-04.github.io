package modelo.ValidarContrasenia;

public class ValidarLongitudMinima implements ValidarContrasenia{

    @Override
    public void validar(String contrasenia) {

        if (contrasenia.length() < 8 ){
            throw new ValidarContraseniaException("La clave debe contenerar mas de 8 caracteres");
        }
    }
}
