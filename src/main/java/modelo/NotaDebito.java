package modelo;

public class NotaDebito implements DocumentoComercial {
	int nroNotaDebito;
	
	@Override
	public int numero() {
		return this.nroNotaDebito;
	}
}
