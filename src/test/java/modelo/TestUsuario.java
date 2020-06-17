package modelo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import modelo.UsuarioException;

public class TestUsuario {
    private Usuario usuario;
    private Comun usuarioComun;

    @Before
    public void init() {
        usuarioComun = new Comun();
        usuario = new Usuario("usuarioComun", usuarioComun);
    }

    @Test(expected = UsuarioException.class)
    public void claveMenosDe8DigitosDaException() {
        Assert.assertFalse("La clave debe contenerar mas de 8 caracteres",usuario.politicasContrasenia("laClave"));
    }
    @Test(expected = UsuarioException.class)
    public void seValidaQueLaClaveNoRepitaMasDe3CaracteresConsecutivos() {
        Assert.assertFalse(usuario.politicasContrasenia("1Claaaves45"));
    }
    @Test(expected = UsuarioException.class)
    public void seValidaQueLaClaveTengaAlMenosUnaLetraYUnNumero() {
        Assert.assertFalse(usuario.politicasContrasenia("NoTieneNumeros"));
    }

}
