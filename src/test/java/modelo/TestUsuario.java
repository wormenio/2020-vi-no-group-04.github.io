package modelo;

import modelo.ValidarContrasenia.ValidarContraseniaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;


public class TestUsuario {
    private Usuario unUsuario;

    @Before
    public void init() {
        unUsuario = new Usuario();
    }

    @Test(expected = UsuarioException.class)
    public void validarNuevoUsuarioCorrecto() {
        unUsuario.registrarUsuario("unNombre",RolUsuario.ADMINISTRADOR,"1234");

     //   Assert.assertEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test(expected = UsuarioException.class)
    public void contraseniaRepiteCaracterDaExcepcion() {
        unUsuario.registrarUsuario("unNombre",RolUsuario.ADMINISTRADOR,"paaasword");
    }

    @Test(expected = UsuarioException.class)
    public void usuarioConClavepasswordDaExcepcion() {
        unUsuario.registrarUsuario("unNombre",RolUsuario.ADMINISTRADOR,"password");
    }


}
