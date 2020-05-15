package modelo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOrganizacion {
    private Organizacion organizacion;
    private UsuarioComun usuarioComun;

    @Before
    public void init() {
        organizacion = new Organizacion();
        usuarioComun = new UsuarioComun();
    }

    @Test
    public void provarRegistroConUsuarioNoValido() {
        organizacion.registrarse("12345622222222" , "1234", usuarioComun);
    }
}
