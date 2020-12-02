package modelo.ReglasDeNegocio;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entidades")
class EntidadBaseNoConformaEntidadJuridica extends ReglaDeNegocio {

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
     * No permitir que una entidad base pueda ser parte de alguna entidad jurídica.
     */
    public void aplicarReglaDeNegocio(Entidad entidadOrigen, Entidad entidadDestino) {
        if(entidadDestino.esEntidadJuridica()){
            throw new EntidadException("La categoria no permite que la entidad sea parte la Entidad Jurídica");
        }
    }

}
