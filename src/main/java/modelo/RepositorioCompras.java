package modelo;

import modelo.Egreso.Compra;
import modelo.Egreso.CompraConPresupuesto;
import modelo.Egreso.CompraSinPresupuesto;

import java.util.HashSet;
import java.util.Set;

public class RepositorioCompras {

	Set<Compra> comprasConPresupuesto = new HashSet<>();
	Set<Compra> comprasSinPresupuesto = new HashSet<>();
	Set<Compra> compras = new HashSet<>();//TODO Ver si se puede usar un solo Set
	
	public void agregarCompraConPresupuesto(Compra compra) {
		comprasConPresupuesto.add(compra);
	}

	public void agregarCompraSinPresupuesto(CompraSinPresupuesto compra) {
		comprasSinPresupuesto.add(compra);
	}
        


	public Set<Compra> getComprasSinPresupuesto(){
		return comprasSinPresupuesto;
	}

	public Set<Compra> getComprasConPresupuesto(){
		return comprasConPresupuesto;
//		return compras.stream().filter(
//					compra->compra.getRequierePresupuesto()
//				)
//				.collect(Collectors.toSet());
	}

}
