package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

public class NotaDebito implements DocumentoComercial {
	int nroNotaDebito;
	
	@Override
	public int numero() {
		return this.nroNotaDebito;
	}
}
