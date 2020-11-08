package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class Cajero implements MedioDePago {

	int numeroReferencia;

	public Cajero(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

}
