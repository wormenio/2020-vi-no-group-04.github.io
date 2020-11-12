package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TD")
public class TarjetaDeDebito extends MedioDePago {
/*

	int numeroReferencia;

	public TarjetaDeDebito(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}
*/

}
