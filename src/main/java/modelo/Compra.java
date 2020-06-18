package modelo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Compra implements ReferenciaEgreso {
	 static final int cantidadPresupuestosRequeridos = 2;
	 Criterio criterio;
	 Proveedor proveedor;
	 List<Presupuesto> presupuestos;
	 Presupuesto presupuestoAsignado;
	 List<Usuario> usuariosHabilitados;
	 List<Item> items = new ArrayList<Item> ();
	 //Moneda moneda;
	 
	 public boolean esRevisor(Usuario usuario) {
		 return true;
	 }
	 
	 public void hacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 
	 public int  calcularMonto() {
		return 0;
		 
	 }
	 
	 public boolean validarCompra(){		 
					 			 
			 return this.validarCantidadDePresupuestos()  
					&& this.validarPresupuestoAsignadoContenidoEnElListado() 
					&& this.validarPorCriterioDeMenorValor();
	 }
	 
	 public boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == this.cantidadPresupuestosRequeridos;		 
	 }
	 
	 public boolean validarPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }
	 
	 public boolean validarPorCriterioDeMenorValor() {
		 
		 boolean validoCriterioMinimoPresupuesto = false;
		 
		 if(this.criterio == Criterio.MENOR_VALOR) {			

			    Presupuesto minPresupuesto = this.presupuestos
			      .stream()
			      .min(Comparator.comparing(Presupuesto::GetValor))
			      .orElseThrow(null);
			 				 
			    validoCriterioMinimoPresupuesto = minPresupuesto.detalle.total == this.presupuestoAsignado.detalle.total;
		 }
		 
		 return validoCriterioMinimoPresupuesto;
		 
	 }
	 

}
