package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Efectivo")
public class Efectivo extends MedioDePago {

/*
	int numeroReferencia;

	public Efectivo(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}
*/

}
