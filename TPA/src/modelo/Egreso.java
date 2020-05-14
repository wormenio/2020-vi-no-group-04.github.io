package modelo;

import java.util.Date;

public class Egreso implements Operacion {
	ReferenciaEgreso referenciaDeEgreso;
	MediosDeCobroYPago pago;
	DocumentoComercial documentoComercial;
	Date fecha;
	float total;
	
	@Override
	public String verDetallesOperacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
