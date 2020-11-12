package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestUsuario {
    private Usuario unUsuario;
    BuzonMensajes buzonDeMensajes;

    @Before
    public void init() {
        unUsuario = new Usuario();
        unUsuario.setNombreUsuario("unNombre");
        unUsuario.setRolUsuario(RolUsuario.ADMINISTRADOR);
        unUsuario.setContrasenia("unaBuenaClave11");
    }

    @Test
    public void validarNuevoUsuario() {
        Assert.assertEquals("unNombre",unUsuario.getNombreUsuario());
    }


    @Test
    public void noSeDaDeAltaUsuarioPorClaveDebil() {
        //La password se encuentra en el archivo de claves débiles "contrasenia.txt"
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorClaveMenoA8Digitos() {
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorClaveSinUnDigitoYUnaLetra() {
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

    @Test
    public void noSeDaDeAltaUsuarioPorCaracteresRepetidos() {
        Assert.assertNotEquals("unNombre",unUsuario.getNombreUsuario());
    }

}
