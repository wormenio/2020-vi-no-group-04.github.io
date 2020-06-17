package modelo;

import java.util.List;

public class Presupuesto {
	Egreso detalle;
	Compra compraAsociada;
	List<DocumentoComercial> documentosComerciales;
	
	
	public float GetValor() {
		return detalle.total;		
	}
}
