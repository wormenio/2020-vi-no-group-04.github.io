package modelo;

import modelo.Egreso.Compras;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioCompras {
	
	List<CompraConPresupuesto> comprasConPresupuesto = new ArrayList<CompraConPresupuesto>();
	Set<Compras> compras = new HashSet<>();
	
	public void agregarCompraConPresupuesto(CompraConPresupuesto compra) {
		comprasConPresupuesto.add(compra);
	}

	public void agregarCompra(Compras compra) {
		compras.add(compra);
	}
        
	public List<CompraConPresupuesto> listadoComprasConPresupuesto(){
		return  comprasConPresupuesto;
	}

	public Set<Compras> listadoDeCompras(){
		return compras;
	}

}
