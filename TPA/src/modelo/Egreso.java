package modelo;

import java.util.Date;

public class Egreso implements Operacion {
	DocumentoComercial documento;
	MediosDeCobroYPago pago;
	Date fecha;
	float total;
	
	@Override
	public String verDetallesOperacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
