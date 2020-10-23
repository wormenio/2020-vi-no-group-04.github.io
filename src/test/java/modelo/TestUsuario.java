package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestUsuario {
    private Usuario unUsuario;
    BuzonMensajes buzonDeMensajes;

    @Before
    public void init() {
     //   buzonDeMensajes = new BuzonMensajes();
     //   unUsuario = new Usuario(buzonDeMensajes);
    }

    @Test
    public void validarNuevoUsuario() {
        unUsuario = new Usuario("unNombre",RolUsuario.ADMINISTRADOR,"unaBuenaClave11");
        Assert.assertEquals("unNombre",unUsuario.getNombreUsuario());
    }


    @Test
    public void noSeDaDeAltaUsuarioPorClaveDebil() {
        //La password se encuentra en el archivo de claves débiles "contrasenia.txt"
        unUsuario = new Usuario("unNombre",RolUsuario.ADMINISTRADOR,"1qaz2wsx");
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorClaveMenoA8Digitos() {
        unUsuario = new Usuario("unNombre",RolUsuario.ESTANDAR,"1234567");
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorClaveSinUnDigitoYUnaLetra() {
        unUsuario = new Usuario("unNombre",RolUsuario.ESTANDAR,"malaClave.");
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorCaracteresRepetidos() {
        unUsuario = new Usuario("unNombre",RolUsuario.ADMINISTRADOR,"malaClave.111");
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

}
