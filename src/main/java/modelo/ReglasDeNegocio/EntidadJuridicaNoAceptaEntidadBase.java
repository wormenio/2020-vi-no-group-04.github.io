package modelo.ReglasDeNegocio;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Egreso")
class EntidadJuridicaNoAceptaEntidadBase extends ReglaDeNegocio {

    @Override
    public Boolean reglaEsTipoCompra() {
        return false;
    }

    @Override
    public Boolean reglaEsTipoEntidad() {
        return true;
    }


    @Override
    /**
     * Bloquear la posibilidad de agregar entidades base a una entidad jurídica.
     */
    public void aplicarReglaDeNegocio( Entidad entidadOrigen, Entidad entidadDestino) {
        if( entidadOrigen.esEntidadJuridica() && entidadDestino.esEntidadBase() ){
            throw new EntidadException("La categoria no permite agregar Entidades Base");
        }
    }
}
