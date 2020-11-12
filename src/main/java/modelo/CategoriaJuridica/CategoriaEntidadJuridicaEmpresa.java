package modelo.CategoriaJuridica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Empresa")
public class CategoriaEntidadJuridicaEmpresa extends CategoriaEntidadJuridica {

	public CategoriaJuridica getCategoriaEntidadJuridica()
	{
		return CategoriaJuridica.EMPRESA;
	}


	public ClasificacionAFIP getClasificacionAFIP(Integer cantidadEmpleados) {
		ClasificacionAFIP categoria =
				(cantidadEmpleados <= 5 && cantidadEmpleados <= 15) ? ClasificacionAFIP.MICRO :
				(cantidadEmpleados > 15 && cantidadEmpleados <= 60) ? ClasificacionAFIP.PEQUENIA :
				(cantidadEmpleados > 60 && cantidadEmpleados <= 235) ? ClasificacionAFIP.MEDIANA_TRAMO_1 :
				ClasificacionAFIP.MEDIANA_TRAMO_2;
		return categoria;
	}

}
