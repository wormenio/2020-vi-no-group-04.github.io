package modelo;

import modelo.Egreso.Compra;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RepositorioCompras {

/*	Set<Compra> comprasConPresupuesto = new HashSet<>();
	Set<Compra> comprasSinPresupuesto = new HashSet<>();
	*/

	Set<Compra> compras = new HashSet<>();
	
	public void agregarCompra(Compra compra) {
		compras.add(compra);
	}

//	public void agregarCompraSinPresupuesto(CompraSinPresupuesto compra) {
//		comprasSinPresupuesto.add(compra);
//	}
        
	public Set<Compra> getCompras(){return  compras;}

//	public Set<Compra> getComprasSinPresupuesto(){
//		return comprasSinPresupuesto;
//	}

	public Set<Compra> getComprasConPresupuesto(){
		return compras.stream().filter(
					compra->compra.getRequierePresupuesto()
				)
				.collect(Collectors.toSet());
	}

	public void validarCompras() {
		getComprasConPresupuesto().stream().map( compra -> compra.validarCompra());

	}

}
