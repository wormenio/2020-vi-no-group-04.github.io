package modelo;

import modelo.Egreso.Item;

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

	
	public Double getTotal() {
		// TODO
		Double importeTotal = 0.0;
//		double importeTotal = items.stream()
//			      .mapToDouble(o -> o.getImporte())
//			      .sum();
		return importeTotal;
	}
}
