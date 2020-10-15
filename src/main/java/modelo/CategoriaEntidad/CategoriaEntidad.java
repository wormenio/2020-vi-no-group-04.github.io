package modelo.CategoriaEntidad;

import modelo.Entidad;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CategoriaEntidad {
    private Map<Integer, String> categorias = new HashMap<Integer, String>();
    private Integer codigoCategoria;
    private ReglasDeNegocio reglasDeNegocio;

//TODO
    public CategoriaEntidad(Integer codigoCategoria){
        this.codigoCategoria = codigoCategoria;
    }
   /* public CategoriaEntidad(Integer codigoCategoria , ReglasDeNegocio reglasDeNegocio ){
        this.codigoCategoria = codigoCategoria;
        this.reglasDeNegocio = reglasDeNegocio;
    }*/

    public boolean aplicarReglasDeNegocio(Integer monto_compra, Entidad entidad) {
        return reglasDeNegocio.aplicarReglasDeNegocio(monto_compra, entidad);
    }

    void agregarNuevaCategoria(Integer codigo, String descripcion){
        categorias.put(codigo, descripcion);
    }

    public  Map<Integer, String> getCategorias(){
        return categorias;

    }


}
