package modelo;

import java.util.List;

public class Presupuesto {
	CompraConPresupuesto compra;
	List<Item> items;
	Proveedor proveedor;
	Moneda moneda;
	
	
	public float GetTotal() {
		double importeTotal = items.stream()
			      .mapToDouble(o -> o.GetValor())
			      .sum();
	}
}
