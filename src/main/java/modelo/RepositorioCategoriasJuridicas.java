package modelo;

import modelo.CategoriaJuridica.CategoriaEntidadJuridica;
import modelo.Egreso.Compra;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioCategoriasJuridicas implements WithGlobalEntityManager {

    private static RepositorioCategoriasJuridicas instance = new RepositorioCategoriasJuridicas();
    public static RepositorioCategoriasJuridicas instance(){
        return instance;
    }

    public CategoriaEntidadJuridica getById(Long id) {
        return entityManager().find(CategoriaEntidadJuridica.class, id);
    }

    public List<CategoriaEntidadJuridica> listadoDeRegistros(){
        return entityManager()//
                .createQuery("from CategoriaEntidadJuridica ", CategoriaEntidadJuridica.class) //
                .getResultList();
    }
}
