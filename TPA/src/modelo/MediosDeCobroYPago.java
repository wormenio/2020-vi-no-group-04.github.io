package modelo;

public interface MediosDeCobroYPago {
	public int pagarMonto(int monto);
	public int numeroDeReferencia();
	public String metodoDePago();

}
