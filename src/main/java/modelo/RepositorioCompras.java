package modelo;

import modelo.Egreso.Compra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import modelo.Entidades.Entidad;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioCompras implements WithGlobalEntityManager{

	private static RepositorioCompras instance = new RepositorioCompras();
	public static RepositorioCompras instance(){
		return instance;
	}


	Set<Compra> compras = new HashSet<>();
	
	public void agregarCompra(Compra compra) {
		compras.add(compra);
	}


        
	public Set<Compra> getCompras(){return  compras;}



	public Set<Compra> getComprasConPresupuesto(){
		return compras.stream().filter(
					compra->compra.getRequierePresupuesto()
				)
				.collect(Collectors.toSet());
	}

	public void validarCompras() {
		getComprasConPresupuesto().stream().map( compra -> compra.validarCompra());

	}
	public void agregar(Compra consultora)  {
	    entityManager().persist(consultora);
	}

	public Compra getById(Long id){
		return entityManager().find(Compra.class, id);
	}

	public List<Compra> buscarPorNombre(String nombreBuscado){
		return null;
	}

	public List<Compra> listadoDeCompras(){
		return entityManager()//
				.createQuery("from Compra ", Compra.class) //
				.getResultList();
	}

/*	Set<Compra> comprasConPresupuesto = new HashSet<>();
	Set<Compra> comprasSinPresupuesto = new HashSet<>();
	*/
	//	public Set<Compra> getComprasSinPresupuesto(){
//		return comprasSinPresupuesto;
//	}
	//	public void agregarCompraSinPresupuesto(CompraSinPresupuesto compra) {
//		comprasSinPresupuesto.add(compra);
//	}
}
