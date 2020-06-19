package modelo;

import java.util.List;

public class Presupuesto {
	CompraConPresupuesto compra;
	List<Item> items;
	float importeTotal;
	Proveedor proveedor;
	Moneda moneda;
	
	Presupuesto( CompraConPresupuesto compra, Proveedor proveedor, Moneda moneda ){
		this.compra = compra;
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
