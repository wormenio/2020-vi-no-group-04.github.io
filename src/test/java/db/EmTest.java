package db;

import modelo.RolUsuario;
import modelo.Usuario;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;


public class EmTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    @Test
    public void persistirUsuarioTest(){
        Usuario usuario = new Usuario();

        usuario.setNombreUsuario("wormeno");
        usuario.setRolUsuario(RolUsuario.ADMINISTRADOR);
        entityManager().persist(usuario);

    }


}
