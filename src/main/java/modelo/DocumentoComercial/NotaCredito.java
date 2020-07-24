package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

public class NotaCredito implements DocumentoComercial {
	int nroNotaCredito;
	
	@Override
	public int numero() {
		return this.nroNotaCredito;
	}
}
