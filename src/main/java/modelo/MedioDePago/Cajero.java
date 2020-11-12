package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cajero")
public class Cajero extends MedioDePago {
/*

	int numeroReferencia;

	public Cajero(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}
*/

}
