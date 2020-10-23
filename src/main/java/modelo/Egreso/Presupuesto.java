package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.EntidadException;
import modelo.Moneda;
import modelo.Proveedor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Presupuesto {
	Proveedor proveedor;
	LocalDate fechaPresupuesto;
	Compra compra;
	DocumentoComercial documentoComercial;
	Set<ItemsDelPresupuesto> items = new HashSet<>();
	float importeTotal;
	Moneda moneda;
	
	public Presupuesto(Proveedor proveedor, LocalDate fechaPresupuesto, Compra compra,
					   DocumentoComercial documentoComercial, Moneda moneda){
		if( compra == null ) throw new ComprasException("Debe indicar la compra");
		this.proveedor = proveedor;
		this.fechaPresupuesto = fechaPresupuesto;
		this.compra = compra;
		this.documentoComercial = documentoComercial;
		compra.agregarPresupuesto(this);
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

	public void addItem(Item item, Double monto ) {
		this.items.add(new ItemsDelPresupuesto(item,monto));
	}
}
