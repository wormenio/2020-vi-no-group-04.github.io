package modelo;

import java.util.HashSet;
import java.util.Set;

public class RepositorioEtiquetaEgreso {

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
}
