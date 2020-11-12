package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DineroEnCuenta")
public class DineroEnCuenta extends MedioDePago {
/*

	int numeroReferencia;

	public DineroEnCuenta(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}
*/

}
