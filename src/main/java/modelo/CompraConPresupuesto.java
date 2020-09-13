package modelo;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CompraConPresupuesto extends Compra {
	/*public CompraConPresupuesto(BuzonMensajes buzon) {
	
	}*/

	static final int cantidadPresupuestosRequeridos = 2;
	Criterio criterio;
	List<Presupuesto> presupuestos;
	Presupuesto presupuestoAsignado;
	List<Usuario> usuariosHabilitados = new ArrayList<>();
	
	public boolean esRevisor(Usuario usuario) {
		 return this.usuariosHabilitados.contains(usuario);
	 }
	 
	public List<Usuario> usuariosHabilitados(){
		return usuariosHabilitados;
	}
	 public void hacerRevisor(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 public boolean validarCompra(){		 

		 return this.validarCantidadDePresupuestos()  
				&& this.validarPresupuestoAsignadoContenidoEnElListado() 
				&& this.validarPorCriterioDeMenorValor();
		 
	 }
	 public int getCantidadPresupuestoRequeridos() {
		 return cantidadPresupuestosRequeridos;
	 }
	 public boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == this.cantidadPresupuestosRequeridos;		 
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
         
        public int getEtiqueta(){
         return this.etiqueta;
        }
        
        public int getAnio(){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(this.fecha_egreso);
            return calendar.get(Calendar.YEAR);            
        }
        
        public int getMes(){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(this.fecha_egreso);
            return calendar.get(Calendar.MONTH);
        }
}
