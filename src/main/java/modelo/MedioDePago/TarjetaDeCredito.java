package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class TarjetaDeCredito implements MedioDePago {

	int numeroReferencia;

	public TarjetaDeCredito(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

	public int GetNumeroReferencia(){
		return numeroReferencia;
	}

}
