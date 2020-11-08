package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class TarjetaDeDebito implements MedioDePago {

	int numeroReferencia;

	public TarjetaDeDebito(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

}
