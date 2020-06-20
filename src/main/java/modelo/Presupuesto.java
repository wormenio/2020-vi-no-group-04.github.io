package modelo;

import java.util.List;

public class Presupuesto {
	List<Item> items;
	float importeTotal;
	Proveedor proveedor;
	Moneda moneda;
	
	Presupuesto( Proveedor proveedor, Moneda moneda ){
		this.proveedor = proveedor;
		this.moneda = moneda;
	}
	
//	public float getTotal() {
//		return importeTotal;
//	}
	
	public Double getTotal() {
		double importeTotal = items.stream()
			      .mapToDouble(o -> o.getImporte())
			      .sum();
		return importeTotal;
	}
}
