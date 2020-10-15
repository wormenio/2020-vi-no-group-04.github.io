package modelo;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.Item;
import modelo.MedioDePago.MedioDePago;

import java.util.*;

public abstract class Compra{
	 String idCompra;
	 Proveedor proveedor;
	 Map<Item, Integer> items = new HashMap<Item, Integer>();
	 DocumentoComercial documentoComercial;
	 Date fecha_egreso;
	 MedioDePago medioDePago;
	 Moneda moneda;
	 float monto_total;
	 Integer cantidad_presupuestos;
	 Boolean requiere_presupuesto;
	 Entidad entidad;
	 List<Presupuesto> presupuestos = new ArrayList<>();

	 int etiqueta;
//	FIXME
//	Cambiar int etiqueta
//	EtiquetaEgreso etiqueta;

	 
	public Proveedor getProveedor() {
		return proveedor;
	}
	public String getId() {
		return idCompra;
	}

	public void setProveedor( Proveedor unProveedor){
		proveedor = unProveedor;
	}


	 public DocumentoComercial getDocumentoComercial()
	 {
		return documentoComercial;
	 }
	 
	 public Date getFechaEgreso()
	 {
		 return fecha_egreso;
	 }
	 
	 public MedioDePago getMedioDePagoEgreso()
	 {
		 return medioDePago;
	 }
	 
	 public float getTotalEgreso() {

	 //	return (float) items.stream().mapToDouble( item -> item.getImporte() ).sum();
		 return 0;
	 }
	 
	 public String getDetalleEgreso()
	 {
		 return "";
	 }

	 public void altaPresupuesto(Presupuesto unPresupuesto){
	 	presupuestos.add(unPresupuesto);
	 }

     public void etiquetarEgreso(int codigoEtiqueta) {
    	 this.etiqueta = codigoEtiqueta;
     }
     
     public int getEtiqueta(){
         return this.etiqueta;
     }


}
