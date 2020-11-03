package modelo.Egreso;

import modelo.*;

import java.time.LocalDate;
import java.util.*;

public class CompraConPresupuesto extends Compra {

	Criterio criterio;
	Set<Presupuesto> presupuestos = new HashSet<>();
	Presupuesto presupuestoAsignado;
	

	public CompraConPresupuesto(LocalDate fechaCompra, Proveedor proveedor, Moneda moneda,
								Entidad entidad,  EtiquetaEgreso etiquetaEgreso) {
		super(fechaCompra, proveedor, moneda, entidad,etiquetaEgreso);
	}

	public void setPresupuestoAsignado(Presupuesto presupuesto){
		if( !presupuestos.contains(presupuesto) )
			throw  new ComprasException("El presupuesto no se encuentra en la lista de presupuestos");

		this.presupuestoAsignado = presupuesto;
	}

	public boolean esRevisor(Usuario usuario) {
		 return this.usuariosHabilitados.contains(usuario);
	 }
	 
	public List<Usuario> usuariosHabilitados(){
		return usuariosHabilitados;
	}

	 public void hacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }

	 @Override
	 public boolean validarCompra(){		 

		 return this.validarCantidadDePresupuestos()  
				&& this.validarPresupuestoAsignadoContenidoEnElListado() 
				&& this.validarPorCriterioDeMenorValor();
		 
	 }

	 public Boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == entidad.getOrganizacion().getCantidadPresupuestosRequeridos();
	 }
	 
	 public boolean validarPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }
	 
	 public Boolean validarPorCriterioDeMenorValor() {
//		TODO -> tiene un "return false" al final!
		 if(this.criterio == Criterio.MENOR_VALOR) {			
	
			    Presupuesto minPresupuesto = this.presupuestos
			      .stream()
			      .min(Comparator.comparing(Presupuesto::getTotal))
			      .orElseThrow(null);
			 				 
			    return minPresupuesto == this.presupuestoAsignado;
		 }
		 
		 return false;
	 }

	 public Set<Presupuesto> getPresupuestos(){
		return presupuestos;
	 }
	 
	public void agregarPresupuesto(Presupuesto presupuesto)
	 {
		 this.presupuestos.add(presupuesto);
		 
	 }

	 public Boolean seCorrespondeConAlMenosUnPresupuesto(){
		return presupuestos.contains(presupuestoAsignado);
	 }

	 


}
