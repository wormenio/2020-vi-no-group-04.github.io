package modelo;

import modelo.Egreso.Compra;

import modelo.Egreso.EtiquetaEgreso;
import modelo.Entidades.Entidad;

import java.time.LocalDate;

public class BuilderCompra {
    private Proveedor proveedor;
    private Compra compra;
    private Entidad entidad;
    private Moneda moneda;
    private Boolean requierePresupuesto = false;
    private Integer cantidadPresupuesto;
    private EtiquetaEgreso etiquetaEgreso = new EtiquetaEgreso();


    public BuilderCompra setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
        return this;
    }

    public BuilderCompra setEntidad(Entidad entidad){
        this.entidad = entidad;
        return this;
    }
    public BuilderCompra setMoneda(Moneda moneda){
        this.moneda = moneda;
        return this;
    }
    public BuilderCompra setRequierePresupuesto(Boolean requierePresupuesto){
        this.requierePresupuesto = requierePresupuesto;
        return this;
    }
    
    public BuilderCompra setCantidadPresupuesto(Integer cantidadPresupuesto){
        this.cantidadPresupuesto = cantidadPresupuesto;
        return this;
    }

    public Compra crearCompra(){
        Compra compra = new Compra();
        compra.setRequierePresupuesto(requierePresupuesto);
        compra.setProveedor(proveedor);
        compra.setMoneda(moneda);
        compra.setEntidad(entidad);
        compra.setCantidadPresupuestos(cantidadPresupuesto);

        return compra;

    }

}
