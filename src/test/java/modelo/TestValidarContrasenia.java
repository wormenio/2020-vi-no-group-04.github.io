package modelo;


import modelo.ValidarContrasenia.*;
import org.junit.Before;
import org.junit.Test;

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
    	// Mockear la validacion y ver la carpeta resources de java para implementar una solucion
        //password es una palabra que se encuentra en el archivo de contrasenias debiles "contrasenias.txt"
        validarContraseniaDebil.validar("password");
    }

/*
    @Test(expected = ValidarContraseniaException.class)
    public void validarNoCumpleLongitudMinima() {
     //   validarLongitudMinima.validar("pepe");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarNoCumpleUnNumeroUnaLetra() {
        //validarLongitudMinima.validar("pepe");
    }

    @Test(expected = ValidarContraseniaException.class)
    public void validarUnNumeroUnaLetra() {
        // validarLongitudMinima.validar("1a");
    }

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
