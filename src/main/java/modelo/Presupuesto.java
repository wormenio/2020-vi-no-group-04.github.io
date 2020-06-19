package modelo;

import java.util.List;

public class Presupuesto {
	CompraConPresupuesto compra;
	List<Item> items;
	Proveedor proveedor;
	Moneda moneda;
	
	
	public Double getTotal() {
		double importeTotal = items.stream()
			      .mapToDouble(o -> o.getImporte())
			      .sum();
		return importeTotal;
	}
}
