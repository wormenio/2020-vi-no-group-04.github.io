package modelo.ValidarContrasenia;

public class ValidarContraseniaException extends  RuntimeException{
    public ValidarContraseniaException() {
        super();
    }

    public ValidarContraseniaException(String message) {
        super(message);
    }
}
