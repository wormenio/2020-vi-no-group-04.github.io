package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TC")
public class TarjetaDeCredito extends MedioDePago {
/*

	int numeroReferencia;

	public TarjetaDeCredito(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

	public int GetNumeroReferencia(){
		return numeroReferencia;
	}
*/

}
