package modelo;


import modelo.ValidarContrasenia.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestValidarContrasenia {

    public ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();
    public ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
    public ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
    public ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();
    public ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();

    @Before
    public void init() {
       /* ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
        ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
        ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();

        */
    }

    @Test
    public void validarCaracteresRepetidos() {
        validarCaracteresRepetidos.validar("unaBuenaClave");

    }


    @Test(expected = ValidarContraseniaException.class)
    public void validarNoCumpleLongitudMinima() {
        validarLongitudMinima.validar("pepe");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarNoCumpleUnNumeroUnaLetra() {
        validarLongitudMinima.validar("pepe");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarUnNumeroUnaLetra() {
        validarLongitudMinima.validar("1a");
    }
    /*
    @Test(expected = ValidarContraseniaException.class)
    public void seValidaQueLaClaveNoRepitaMasDe3CaracteresConsecutivos() {
        usuario.politicasContrasenia("1Claaaves45");
    }
    @Test(expected = ValidarContraseniaException.class)
    public void seValidaQueLaClaveTengaAlMenosUnaLetraYUnNumero() {
        usuario.politicasContrasenia("NoTieneNumeros");
    }

     */
}
