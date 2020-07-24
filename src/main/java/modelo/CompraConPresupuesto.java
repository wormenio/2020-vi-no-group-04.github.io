package modelo;

import java.util.Comparator;
import java.util.List;

public class CompraConPresupuesto extends Compra {
	public CompraConPresupuesto(BuzonMensajes buzon) {
	//	buzonDeMensajes = buzon;
		// TODO Auto-generated constructor stub
	}

	static final int cantidadPresupuestosRequeridos = 2;
	Criterio criterio;
	List<Presupuesto> presupuestos;
	Presupuesto presupuestoAsignado;
	List<Usuario> usuariosHabilitados;
	
	public boolean esRevisor(Usuario usuario) {
		 return this.usuariosHabilitados.contains(usuario);
	 }
	 
	 public void hacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 public boolean validarCompra(){		 

		 return this.validarCantidadDePresupuestos()  
				&& this.validarPresupuestoAsignadoContenidoEnElListado() 
				&& this.validarPorCriterioDeMenorValor();
		 
		 // Remover, deberia estar en el main
		 // buzonDeMensajes.agregarNotificacion(this, validacion);

		 
		 //	return validacion;
	 }
	 
	 public boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == CompraConPresupuesto.cantidadPresupuestosRequeridos;		 
	 }
	 
	 public boolean validarPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }
	 
	 public boolean validarPorCriterioDeMenorValor() {
		 
		 
		 if(this.criterio == Criterio.MENOR_VALOR) {			
	
			    Presupuesto minPresupuesto = this.presupuestos
			      .stream()
			      .min(Comparator.comparing(Presupuesto::getTotal))
			      .orElseThrow(null);
			 				 
			    return minPresupuesto == this.presupuestoAsignado;
		 }
		 
		 return false;
		 
	 }
	 
	 public void agregarPresupuesto( float importePresupuesto, Proveedor proveedor, Moneda moneda )
	 {
		 Presupuesto presupuesto = new Presupuesto(proveedor,moneda);
		 this.presupuestos.add(presupuesto);
		 
	 }
}
