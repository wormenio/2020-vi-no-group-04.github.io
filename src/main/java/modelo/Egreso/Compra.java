package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.Item;
import modelo.Egreso.ItemsDeLaCompra;
import modelo.Egreso.MedioDePagoDeLaCompra;
import modelo.Egreso.Presupuesto;
import modelo.Entidad;
import modelo.EtiquetaEgreso;
import modelo.MedioDePago.MedioDePago;
import modelo.Moneda;
import modelo.Proveedor;

import java.time.LocalDate;
import java.util.*;

public abstract class Compra {

	 Proveedor proveedor;
	 Set<ItemsDeLaCompra> itemsDeLaCompras = new HashSet<>();
	 LocalDate fechaCompra;
	 Set<MedioDePagoDeLaCompra> mediosDePagoDeLaCompra = new HashSet<>();
	 Set<DocumentoComercial> documentosComerciales = new HashSet<>();
	 List<Presupuesto> presupuestos = new ArrayList<>();
	 Moneda moneda;
	 float monto_total;
//	 Integer cantidad_presupuestos;
//	 Boolean requiere_presupuesto;
	 Entidad entidad;
	 EtiquetaEgreso etiquetaEgreso;


	 int etiqueta;
//	FIXME
//	Cambiar int etiqueta
//	EtiquetaEgreso etiqueta;

	public Compra(LocalDate fechaCompra, Proveedor proveedor, Moneda moneda,
				  Entidad entidad, EtiquetaEgreso etiquetaEgreso){
		if( proveedor == null) throw new ComprasException("Debe indicar el Proveedor");
		if( moneda == null )  throw new ComprasException("Debe indicar la Moneda");
		if( entidad == null ) throw new ComprasException("Debe indicar la Entidad");
		this.fechaCompra = fechaCompra;
		this.proveedor = proveedor;
		this.moneda = moneda;
		this.entidad = entidad;
		this.etiquetaEgreso = etiquetaEgreso;
	}

	public void addMediosDePago(MedioDePago medioDePago, Double monto){
		mediosDePagoDeLaCompra.add(new MedioDePagoDeLaCompra(medioDePago, monto)  );
	}

	public Set<MedioDePagoDeLaCompra> getMediosDePago() {
		return mediosDePagoDeLaCompra;
	}

	public void agregarItem(Item item,Double precio){
		itemsDeLaCompras.add(new ItemsDeLaCompra(item,precio));
	}

	public Set<ItemsDeLaCompra> getItems(){
		return itemsDeLaCompras;
	}

	public Entidad getEntidad(){
		return entidad;
	}

	public void addDocumentoComercial(DocumentoComercial documento){
		documentosComerciales.add(documento);
	}

	public Set<DocumentoComercial> getDocumentoComercial()
	{
		return documentosComerciales;
	}

	public LocalDate getFechaCompra()
	{
		return fechaCompra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void etiquetarEgreso(int codigoEtiqueta) {
    	 this.etiqueta = codigoEtiqueta;
     }

    public int getEtiqueta(){
         return this.etiqueta;
     }

	public Integer getAnio(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(java.sql.Timestamp.valueOf(fechaCompra.toString()));
		return calendar.get(Calendar.YEAR);
	}

	public Integer getMes(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(java.sql.Timestamp.valueOf(fechaCompra.toString()));
		return calendar.get(Calendar.MONTH);
	}

	public void setPresupuestoAsignado(Presupuesto presupuesto){ }

	public  void agregarPresupuesto(Presupuesto presupuesto){}

	public Set<Presupuesto> getPresupuestos(){
		return null;
	}

	public void setCantidadPresupuestosRequeridos(Integer cantidad){}

	public Boolean validarCantidadDePresupuestos(){
		return false;
	}

	public Boolean validarPorCriterioDeMenorValor() {
		return false;
	}

	public Boolean seCorrespondeConAlMenosUnPresupuesto(){
		return false;
	}

	public void setCompraValidada(){ 	}

	public float getTotalEgreso() {

		//	return (float) items.stream().mapToDouble( item -> item.getImporte() ).sum();
		return 0;
	}
}
