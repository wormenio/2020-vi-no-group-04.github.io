package db;

import org.junit.Test;
import entities.usuario.UsuarioEntity;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;


public class EmTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    @Test
    public void persistirUsuarioTest(){
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsuario("wormeno");
        usuario.setNombre("walter");
        usuario.setApellido("Ormeño");
        usuario.setHash("44889966abs");
        usuario.setIsAdmin(true);

        entityManager().persist(usuario);

    }


}
