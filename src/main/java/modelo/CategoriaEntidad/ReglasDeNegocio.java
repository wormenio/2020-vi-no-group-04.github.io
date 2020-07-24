package modelo.CategoriaEntidad;

import modelo.Entidad;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReglasDeNegocio {
    private List<Object> listaReglasDeNegocio  = new ArrayList<>();

    boolean aplicarReglasDeNegocio(Integer monto_compra, Entidad entidad) {

        Iterator reglaDeNegocio = listaReglasDeNegocio.iterator();
        while( reglaDeNegocio.hasNext() ) {
            Method metodo = null;
            try {
                metodo = reglaDeNegocio.next().getClass().getMethod("aplicarRegla");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                if(   (boolean)metodo.invoke("aplicarRegla") == false ) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    void agregarReglaAgregarEntidadBaseAEntidadJuridica(Entidad entidad){
        listaReglasDeNegocio.add( new ReglaAgregarEntidadBaseAEntidadJuridica(entidad) );
    }

    void agregarReglaBloquearEntidadBaseEnEntidadJuridica(Entidad entidad){
        listaReglasDeNegocio.add(new ReglaBloquearEntidadBaseEnEntidadJuridica(entidad));
    }

    void agregarReglaAceptarNuevosEgresos(Entidad entidad){
        listaReglasDeNegocio.add(new ReglaAceptarNuevosEgresos(entidad));
    }

}
