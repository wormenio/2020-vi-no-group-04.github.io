package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class Efectivo implements MedioDePago {

	int numeroReferencia;

	public Efectivo(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

}
