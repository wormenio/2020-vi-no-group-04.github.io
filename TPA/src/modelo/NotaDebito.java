package modelo;

public class NotaDebito implements DocumentoComercial {
	int nroNotaDebito;
	
	@Override
	int numero() {
		return this.nroNotaDebito;
	}
}
