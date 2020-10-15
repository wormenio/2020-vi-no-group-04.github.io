package modelo.Egreso;

import modelo.*;
import modelo.DocumentoComercial.DocumentoComercial;
import modelo.MedioDePago.MedioDePago;

import java.time.LocalDate;
import java.util.*;

public class Compras {

    LocalDate fechaCompra;
    MedioDePago medioDePago;
    Proveedor proveedor = null;
    Moneda moneda = null;
    Entidad entidad;

    Set<ItemsDeLaCompra> items = new HashSet<>();
    Set<MedioDePagoDeLaCompra> mediosDePagoDeLaCompra = new HashSet<>();
    String idCompra;


    DocumentoComercial documentoComercial;

    float monto_total;
    Integer cantidad_presupuestos;
    Boolean requiere_presupuesto;
    List<Presupuesto> presupuestos = new ArrayList<>();

    int etiqueta;
//	FIXME
//	Cambiar int etiqueta
//	EtiquetaEgreso etiqueta;

    public Compras(LocalDate fechaCompra, Proveedor proveedor, Moneda moneda,
                   Entidad entidad){
        this.fechaCompra = fechaCompra;
        this.proveedor = proveedor;
        this.moneda = moneda;
        this.entidad = entidad;

    }

    public void addMediosDePago(MedioDePago medioDePago, Double importe){
        MedioDePagoDeLaCompra unMedio = new MedioDePagoDeLaCompra(medioDePago,importe);
        mediosDePagoDeLaCompra.add(unMedio);
    }

    public void agregarItem(Item item, Double monto){
        ItemsDeLaCompra unItem = new ItemsDeLaCompra(item,monto);
        items.add(unItem);
    }



    public Proveedor getProveedor() {
        return proveedor;
    }
    public String getId() {
        return idCompra;
    }

//    public void setProveedor( Proveedor unProveedor){
//        proveedor = unProveedor;
//    }


    public DocumentoComercial getDocumentoComercial()
    {
        return documentoComercial;
    }

    public LocalDate getFechaCompra()
    {
        return fechaCompra;
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
