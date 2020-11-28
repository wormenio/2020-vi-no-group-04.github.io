package modelo;

import modelo.Egreso.EtiquetaEgreso;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.HashSet;
import java.util.Set;

public class RepositorioEtiquetaEgreso implements WithGlobalEntityManager {

    private static RepositorioEtiquetaEgreso instance = new RepositorioEtiquetaEgreso();
    public static RepositorioEtiquetaEgreso instance(){
        return instance;
    }

    Set<EtiquetaEgreso> etiquetas = new HashSet<>();

    public void agregarEtiqueta( EtiquetaEgreso etiqueta){
        etiquetas.add(etiqueta);
    }

    public void eliminarEtiqueta(EtiquetaEgreso etiqueta){
        etiquetas.remove(etiqueta);
    }

    public Set<EtiquetaEgreso> getEtiquetas(){
        return etiquetas;
    }

    public EtiquetaEgreso getById(Long id){
        return entityManager().find(EtiquetaEgreso.class, id);

    }
}
