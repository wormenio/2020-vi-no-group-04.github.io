package modelo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CategoriaEntidad {
    private Map<Integer, String> categorias = new HashMap<Integer, String>();
    private Integer codigoCategoria;
    private ReglasDeNegocio reglasDeNegocio;


    public CategoriaEntidad(Integer codigoCategoria , ReglasDeNegocio reglasDeNegocio ){
        this.codigoCategoria = codigoCategoria;
        this.reglasDeNegocio = reglasDeNegocio;
    }

    public boolean aplicarReglasDeNegocio() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return reglasDeNegocio.aplicarReglasDeNegocio();
    }

    void agregarNuevaCategoria(Integer codigo, String descripcion){
        categorias.put(codigo, descripcion);
    }

    public  Map<Integer, String> getCategorias(){
        return categorias;

    }


}

class ReglaAceptarNuevosEgresos {
    boolean aplicarRegla(){
        return false;
    }
}

class ReglaAgregarEntidadBaseAEntidadJuridica {
    boolean aplicarRegla(){
        return false;
    }
}

class ReglaBloquearEntidadBaseEnEntidadJuridica {
    boolean aplicarRegla(){
        return false;
    }
}

class ReglasDeNegocio {
    private List<Object> listaReglasDeNegocio  = new ArrayList<>();

    boolean aplicarReglasDeNegocio() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Recorrer todas las reglas y aplicarlas

        Iterator reglaDeNegocio = listaReglasDeNegocio.iterator();
        while( reglaDeNegocio.hasNext() ) {
            Method metodo = reglaDeNegocio.next().getClass().getMethod("aplicarRegla");
           if(   (boolean)metodo.invoke("aplicarRegla") == false ) {
               return false;
           }
        }
        return true;
    }

    void agregarReglaAgregarEntidadBaseAEntidadJuridica(){
        listaReglasDeNegocio.add(new ReglaAgregarEntidadBaseAEntidadJuridica());
    }

    void agregarReglaBloquearEntidadBaseEnEntidadJuridica(){
        listaReglasDeNegocio.add(new ReglaBloquearEntidadBaseEnEntidadJuridica());
    }

    void agregarReglaAceptarNuevosEgresos(){
        listaReglasDeNegocio.add(new ReglaAceptarNuevosEgresos());
    }

}
