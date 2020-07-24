package modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCompras {
	
	List<CompraConPresupuesto> compras = new ArrayList<CompraConPresupuesto>();
	
	public void agregarCompra(CompraConPresupuesto compra) {
		compras.add(compra);
	}
	public List<CompraConPresupuesto> listadoCompras(){
		return compras;
	}
}
