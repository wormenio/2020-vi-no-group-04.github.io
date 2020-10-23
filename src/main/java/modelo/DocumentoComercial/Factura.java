package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import java.time.LocalDate;

public class Factura implements DocumentoComercial {
	Integer nroFactura;
	String tipoFactura;
	LocalDate fecha;

	public Factura(Integer nroFactura,String tipoFactura){
		this.nroFactura = nroFactura;
		this.tipoFactura = tipoFactura;
	}
	
	@Override
	public Integer getNumero() {
		return this.nroFactura;
	}
}
