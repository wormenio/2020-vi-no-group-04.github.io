package modelo;

public class NotaCredito implements DocumentoComercial {
	int nroNotaCredito;
	
	@Override
	int numero() {
		return this.nroNotaCredito;
	}
}
