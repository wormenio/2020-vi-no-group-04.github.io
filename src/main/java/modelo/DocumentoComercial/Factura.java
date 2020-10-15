package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

public class Factura implements DocumentoComercial {
	Integer nroFactura;
	String tipoFactura;

	public Factura(Integer nroFactura,String tipoFactura){
		this.nroFactura = nroFactura;
		this.tipoFactura = tipoFactura;
	}
	
	@Override
	public int numero() {
		return this.nroFactura;
	}
}
