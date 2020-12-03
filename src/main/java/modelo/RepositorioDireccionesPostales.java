package modelo;

import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.DireccionPostal.DireccionPostal;
import modelo.Egreso.Compra;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioDireccionesPostales implements WithGlobalEntityManager {

    private static RepositorioDireccionesPostales instance = new RepositorioDireccionesPostales();
    public static RepositorioDireccionesPostales instance(){
        return instance;
    }

    public DireccionPostal getById(Long id) {
        return entityManager().find(DireccionPostal.class, id);
    }

    public List<DireccionPostal> listadoDeRegistros(){
        return entityManager()//
                .createQuery("from DireccionPostal ", DireccionPostal.class) //
                .getResultList();
    }
}
