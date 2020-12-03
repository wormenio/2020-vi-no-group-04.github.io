package modelo;

import modelo.CategoriaJuridica.CategoriaEntidadJuridica;
import modelo.CategorizacionEntidad.CategoriaEntidad;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioCategoriasEntidades implements WithGlobalEntityManager {

    private static RepositorioCategoriasEntidades instance = new RepositorioCategoriasEntidades();
    public static RepositorioCategoriasEntidades instance(){
        return instance;
    }

    public CategoriaEntidad getById(Long id) {
        return entityManager().find(CategoriaEntidad.class, id);
    }

    public List<CategoriaEntidad> listadoDeRegistros(){
        return entityManager()//
                .createQuery("from CategoriaEntidad ", CategoriaEntidad.class) //
                .getResultList();
    }
}
