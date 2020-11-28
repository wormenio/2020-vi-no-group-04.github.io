package modelo.ReglasDeNegocio;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;
import modelo.RepositorioCompras;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Egreso")
class BloquearAceptarNuevosEgresos extends ReglaDeNegocio {


    @Override
    public Boolean reglaEsTipoCompra() {
        return true;
    }

    @Override
    public Boolean reglaEsTipoEntidad() {
        return false;
    }

//    public String getNombre(){
//        return "Bloquear aceptar Nuevos Egresos";
//    }

    @Override
    /**
     * Bloquear la posibilidad de aceptar nuevos egresos a una determinada entidad,
     * porque la misma superó un monto previamente establecido.
     */
    public void aplicarReglaDeNegocio(Entidad entidadOrigen, Entidad entidadDestino) {
        RepositorioCompras repositorioCompras = new RepositorioCompras();
        if( repositorioCompras.getTotalComprasEntidad(entidadOrigen) > entidadOrigen.getMontoMaximoEgreso() ){
            throw new EntidadException("No puede aceptar nuevos egresos: Supero el monto establecido: "
                    + entidadOrigen.getMontoMaximoEgreso());
        }

    }


}
