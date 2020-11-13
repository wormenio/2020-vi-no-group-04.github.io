package modelo.ReglasDeNegocioEntidades;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;
import modelo.ReglasDeNegocioEntidades.ReglasDeNegocioEntidades;
import modelo.RepositorioCompras;

class ReglaAceptarNuevosEgresos implements ReglasDeNegocioEntidades {

   /* Entidad entidad;
    public ReglaAceptarNuevosEgresos( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer monto_compra, Entidad entidad){
        return entidad.getMontoMaximoEgreso() > monto_compra;
    }*/


    @Override
    /**
     * Bloquear la posibilidad de aceptar nuevos egresos a una determinada entidad,
     * porque la misma superó un monto previamente establecido.
     */
    public void aplicarReglaDeNegocioEntidad(Entidad entidad) {
        RepositorioCompras repositorioCompras = new RepositorioCompras();
        if( repositorioCompras.getTotalComprasEntidad(entidad) > entidad.getMontoMaximoEgreso() ){
            throw new EntidadException("No puede aceptar nuevos egresos: Supero el monto establecido: "
                    + entidad.getMontoMaximoEgreso());
        }

    }
}
