package modelo;

import java.util.Comparator;
import java.util.List;

public class CompraConPresupuesto extends Compra {
	static final int cantidadPresupuestosRequeridos = 2;
	Criterio criterio;
	List<Presupuesto> presupuestos;
	Presupuesto presupuestoAsignado;
	List<Usuario> usuariosHabilitados;
	
	public boolean esRevisor(Usuario usuario) {
		 return true;
	 }
	 
	 public void hacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 public boolean validarCompra(){		 
			 
		 return this.validarCantidadDePresupuestos()  
				&& this.validarPresupuestoAsignadoContenidoEnElListado() 
				&& this.validarPorCriterioDeMenorValor();
	 }
	 
	 public boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == CompraConPresupuesto.cantidadPresupuestosRequeridos;		 
	 }
	 
	 public boolean validarPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }
	 
	 public boolean validarPorCriterioDeMenorValor() {
		 
		 boolean validoCriterioMinimoPresupuesto = false;
		 
		 if(this.criterio == Criterio.MENOR_VALOR) {			
	
			    Presupuesto minPresupuesto = this.presupuestos
			      .stream()
			      .min(Comparator.comparing(Presupuesto::getTotal))
			      .orElseThrow(null);
			 				 
			    validoCriterioMinimoPresupuesto = minPresupuesto.compra.getTotalEgreso() == this.presupuestoAsignado.compra.getTotalEgreso();
		 }
		 
		 return validoCriterioMinimoPresupuesto;
		 
	 }
}
