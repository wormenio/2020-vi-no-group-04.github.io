package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

public class Factura implements DocumentoComercial {
	int nroFactura;
	String tipoFactura;
	
	@Override
	public int numero() {
		return this.nroFactura;
	}
}
