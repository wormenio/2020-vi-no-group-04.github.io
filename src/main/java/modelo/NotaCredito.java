package modelo;

public class NotaCredito implements DocumentoComercial {
	int nroNotaCredito;
	
	@Override
	public int numero() {
		return this.nroNotaCredito;
	}
}
