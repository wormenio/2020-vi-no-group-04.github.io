package modelo.MedioDePago;

import modelo.MedioDePago.MedioDePago;

public class TarjetaDeCredito implements MedioDePago {

	int numeroTarjeta;

	public TarjetaDeCredito(int numeroTarjeta){
		this.numeroTarjeta = numeroTarjeta;
	}


	@Override
	public int pagarMonto(int monto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numeroDeReferencia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String metodoDePago() {
		// TODO Auto-generated method stub
		return null;
	}

}
