package modelo;

import modelo.Egreso.Compra;
import modelo.Entidades.Entidad;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioEntidades  implements WithGlobalEntityManager {

    private static RepositorioEntidades instance = new RepositorioEntidades();
    public static RepositorioEntidades instance(){
        return instance;
    }

    public void agregar(Entidad entidad)  {
        entityManager().persist(entidad);
    }

    public Entidad getById(Long id){
        return entityManager().find(Entidad.class, id);

    }

    public List<Entidad> listadoDeRegistros(){
        return entityManager()
                .createQuery("from Entidad ", Entidad.class)
                .getResultList();
    }

    public List<Entidad> buscarPorNombre(String  nombreEntidad) {

         List<Entidad> entidades = entityManager()
                .createQuery("from Entidad e where e.id = :idEntidad ", Entidad.class)
                .setParameter("idEntidad", nombreEntidad)
                .getResultList();
         return entidades;
    }
}
