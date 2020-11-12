package modelo.CategoriaJuridica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Osc")
public class CategoriaEntidadJuridicaOSC extends CategoriaEntidadJuridica {

	public CategoriaJuridica getCategoriaEntidadJuridica() {
		return CategoriaJuridica.OSC;
	}

	@Override
	public ClasificacionAFIP getClasificacionAFIP(Integer cantidadEmpleados) {
		return null;
	}
}
