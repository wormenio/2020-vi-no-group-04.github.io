package modelo;

import java.util.Date;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Compra implements Egreso{
	
	 Proveedor proveedor;
	 List<Item> items = new ArrayList<Item> ();
	 DocumentoComercial documentoComercial;
	 Date fecha;
	 MedioDePago medioDePago;
	 Moneda moneda;
	 
	 public DocumentoComercial getDocumentoComercial()
	 {
		return documentoComercial;
	 }
	 
	 public Date getFechaEgreso()
	 {
		 return fecha;
	 }
	 
	 public MedioDePago getMedioDePagoEgreso()
	 {
		 return medioDePago;
	 }
	 
	 public Double getTotalEgreso() {
		 return items.stream().mapToDouble( item -> item.getImporte() ).sum();
	 }
	 
	 public String getDetalleEgreso()
	 {
		 return "";
	 }
	 

}
