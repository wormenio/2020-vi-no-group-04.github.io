package modelo.MedioDePago;

public interface MedioDePago {
	public int pagarMonto(int monto);
	public int numeroDeReferencia();
	public String metodoDePago();

}
