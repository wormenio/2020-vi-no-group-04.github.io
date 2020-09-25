package modelo;


import modelo.ValidarContrasenia.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

//import modelo.ValidarContrasenia.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestValidarContrasenia {

   // public ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();
    public ValidarCaracteresRepetidos validarCaracteresRepetidos;
    public ValidarLongitudMinima validarLongitudMinima;
    public ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra;
    public ValidarContraseniaDebil validarContraseniaDebil;
    //  public ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
  //  public ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();
  //  public ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();

    @Before
    public void init() {
        validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
        validarLongitudMinima = new ValidarLongitudMinima();
        validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
        validarContraseniaDebil = new ValidarContraseniaDebil();
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarExcepcionConCaracteresRepetidos() {
        validarCaracteresRepetidos.validar("repiiteclaveee111");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarExcepcionNoSeCumpleLongitudMinima() {
        validarLongitudMinima.validar("1234567");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarExcepcionNoSeTieneUnCaracterUnaLetra() {
        validarUnNumeroUnaLetra.validar("soloLetras");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarExcepcionContraseniaDebil() {
        validarContraseniaDebil.validar(validarContraseniaDebil.getRandomPassword());
        //Obtenemos cualquier elemento del archivo de contraseñas.txt y le aplicamos el Validar.
    }

}
