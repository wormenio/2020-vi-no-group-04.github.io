package modelo;

import java.util.Date;

public class Egreso implements Operacion {
	ReferenciaEgreso referenciaDeEgreso;
	MedioDePago medioDePago;
	DocumentoComercial documentoComercial;
	Date fecha;
	float total;
	
	@Override
	public String verDetallesOperacion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DocumentoComercial documentoComercial() {
		return documentoComercial;
	}
}
