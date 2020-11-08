package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class DineroEnCuenta implements MedioDePago {

	int numeroReferencia;

	public DineroEnCuenta(int numeroReferencia){
		this.numeroReferencia = numeroReferencia;
	}

}
