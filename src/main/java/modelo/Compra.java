package modelo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Compra implements ReferenciaEgreso {
	 int maximoPresupuestosRequeridos;
	 Criterio criterio;
	 Proveedor proveedor;
	 List<Presupuesto> presupuestos;
	 Presupuesto presupuestoAsignado;
	 List<Usuario> usuariosHabilitados;
	 List<Item> items = new ArrayList<Item> ();
	 //Moneda moneda; ESTO SE TIENE QUE TRAER DE MERCADOLIBRE
	 
	 public boolean esRevisor(Usuario usuario) {
		 return true;
	 }
	 
	 public void HacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 
	 public int  calcularMonto() {
		return 0;
		 
	 }
	 
	 public boolean validarCompra(){		 
		 if(this.maximoPresupuestosRequeridos > 0) {			 			 
			 return this.validoCantidadDePresupuestos()  
					&& this.validoPresupuestoAsignadoContenidoEnElListado() 
					&& this.validoPorCriterioDeMenorValor();
		 }
		 
		 
		 
		 return true;
	 }
	 
	 public boolean validoCantidadDePresupuestos() {
		 return this.presupuestos.size() == this.maximoPresupuestosRequeridos;		 
	 }
	 
	 public boolean validoPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }
	 
	 public boolean validoPorCriterioDeMenorValor() {
		 
		 boolean validoCriterioMinimoPresupuesto = false;
		 
		 if(this.criterio == Criterio.MENOR_VALOR) {			

			    Presupuesto minPresupuesto = this.presupuestos
			      .stream()
			      .min(Comparator.comparing(Presupuesto::GetTotal))
			      .orElseThrow(null);
			 				 
			    validoCriterioMinimoPresupuesto = minPresupuesto.detalle.total == this.presupuestoAsignado.detalle.total;
		 }
		 
		 return validoCriterioMinimoPresupuesto;
		 
	 }
	 

}
