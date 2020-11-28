package modelo.ReglasDeNegocio;

import modelo.EntidadPersistente;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "Reglas_de_negocio")
public class ReglassDeNegocio extends EntidadPersistente {

    @Column(name = "regla_de_negocio",unique = true)
    private String reglaDeNegocio;

    @Column(name = "clase",unique = true)
    private String clase;

    @Transient
    private Set<ReglaDeNegocio> comportamientoReglaDeNegocios = new HashSet<>();

    public void setReglaDeNegocio(ReglaDeNegocio reglaDeNegocio) {
        this.reglaDeNegocio = reglaDeNegocio.getNombre();
        reglaDeNegocio.getClass();
    }

    public String getReglaDeNegocio() {
        return reglaDeNegocio;
    }



/*

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
//        listaReglasDeNegocio.add( new ReglaAgregarEntidadBaseAEntidadJuridica(entidad) );
    }

    void agregarReglaBloquearEntidadBaseEnEntidadJuridica(Entidad entidad){
//        listaReglasDeNegocio.add(new ReglaBloquearEntidadBaseEnEntidadJuridica(entidad));
    }

    void agregarReglaAceptarNuevosEgresos(Entidad entidad){
//        listaReglasDeNegocio.add(new ReglaAceptarNuevosEgresos(entidad));
    }

*/

}
