package modelo;

import modelo.Entidades.Entidad;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioEntidades  implements WithGlobalEntityManager {

    private static RepositorioEntidades instance = new RepositorioEntidades();
    public static RepositorioEntidades instance(){
        return instance;
    }

    public Entidad getById(Long id){
        return entityManager().find(Entidad.class, id);

    }

}
