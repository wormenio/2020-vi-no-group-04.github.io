package modelo;
import modelo.ValidarContrasenia.ValidarContraseniaException;
import org.junit.Before;
import org.junit.Test;
//import modelo.UsuarioException;

public class TestUsuario {
    private Usuario usuario;
    private UsuarioComun usuarioComun;

    @Before
    public void init() {
        usuarioComun = new UsuarioComun();
        usuario = new Usuario("usuarioComun", usuarioComun);
    }

    @Test(expected = ValidarContraseniaException.class)
    public void claveMenosDe8DigitosDaException() {
        usuario.politicasContrasenia("laClave");
       // Assert.assertFalse("La clave debe contenerar mas de 8 caracteres",usuario.politicasContrasenia("laClave"));
    }
    @Test(expected = ValidarContraseniaException.class)
    public void seValidaQueLaClaveNoRepitaMasDe3CaracteresConsecutivos() {
        usuario.politicasContrasenia("1Claaaves45");
       // Assert.assertFalse(usuario.politicasContrasenia("1Claaaves45"));
    }
    @Test(expected = ValidarContraseniaException.class)
    public void seValidaQueLaClaveTengaAlMenosUnaLetraYUnNumero() {
        usuario.politicasContrasenia("NoTieneNumeros");
        //Assert.assertFalse(usuario.politicasContrasenia("NoTieneNumeros"));
    }

}
