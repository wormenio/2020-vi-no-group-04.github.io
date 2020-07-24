package modelo;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.MedioDePago.MedioDePago;

import java.util.*;

public abstract class Compra implements Egreso{
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


	 //TODO
	//TPA 2 - 3) Se desea verificar las siguientes condiciones en los egresos y los presupuestos:


}
