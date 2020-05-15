package modelo;

public class Factura implements DocumentoComercial{
	int nroFactura;
	String tipoFactura;
	
	@Override
	public int numero() {
		return this.nroFactura;
	}
}
