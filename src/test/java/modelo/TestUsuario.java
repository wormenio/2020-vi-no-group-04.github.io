package modelo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsuario {
    private Usuario usuario;
    private UsuarioComun usuarioComun;

    @Before
    public void init() {
        usuarioComun = new UsuarioComun();
        usuario = new Usuario("usuarioComun", usuarioComun);
    }

    @Test
    public void provarClaveValida() {
        usuario.esValido("usuario","laclave");
    }
}
