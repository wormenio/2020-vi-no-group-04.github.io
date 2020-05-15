package modelo;

public class Factura implements DocumentoComercial{
	int nroFactura;
	String tipoFactura;
	
	@Override
	int numero() {
		return this.nroFactura;
	}
}
