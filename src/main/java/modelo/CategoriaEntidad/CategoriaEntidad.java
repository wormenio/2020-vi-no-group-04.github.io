package modelo.CategoriaEntidad;

import modelo.Entidad;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CategoriaEntidad {
    private String nombre;
    private ReglasDeNegocio reglasDeNegocio;

//TODO
    public CategoriaEntidad(String nombreCategoria){ this.nombre = nombreCategoria; }

    public boolean aplicarReglasDeNegocio(Integer monto_compra, Entidad entidad) {
        return reglasDeNegocio.aplicarReglasDeNegocio(monto_compra, entidad);
    }

}
