package modelo;

import modelo.Egreso.Compra;
import modelo.Egreso.CompraConPresupuesto;
import modelo.Egreso.CompraSinPresupuesto;

import java.time.LocalDate;

public class BuilderCompra {
    private Proveedor proveedor;
    private Compra compra;
    private Entidad entidad;
    private Moneda moneda;
    private Boolean conPresupuesto = false;
    private Integer cantidadPresupuesto;
    private EtiquetaEgreso etiquetaEgreso = new EtiquetaEgreso("Etiqueta 1");


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
    public BuilderCompra setConPresupuesto(Boolean conPresupuesto){
        this.conPresupuesto = conPresupuesto;
        return this;
    }
    
    public BuilderCompra setCantidadPresupuesto(Integer cantidadPresupuesto){
        this.cantidadPresupuesto = cantidadPresupuesto;
        return this;
    }

    public Compra crearCompra(){
        if(conPresupuesto){
            return new CompraConPresupuesto(
                    LocalDate.now(),
                    proveedor,
                    moneda,
                    entidad,
                    etiquetaEgreso
            ) ;
        }
        else{
            return new CompraSinPresupuesto(
                    LocalDate.now(),
                    proveedor,
                    moneda,
                    entidad,
                    etiquetaEgreso
            ) ;
        }

    }
}
