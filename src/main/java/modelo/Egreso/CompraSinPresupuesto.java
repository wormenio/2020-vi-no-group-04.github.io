package modelo.Egreso;

import modelo.*;
import java.time.LocalDate;

public class CompraSinPresupuesto extends Compra {

    public CompraSinPresupuesto(LocalDate fechaCompra, Proveedor proveedor, Moneda moneda, Entidad entidad, EtiquetaEgreso etiquetaEgreso) {
        super(fechaCompra, proveedor, moneda, entidad,etiquetaEgreso);
    }

/*
    private LocalDate fechaCompra = LocalDate.now();//Se asume que por default la fecha es la del día
                                                    // de creación de la compra
    private Proveedor proveedor;
    private Moneda moneda ;

    private Entidad entidad;
    private Boolean compraConPresupuesto;



    public Compra crearCompra(){
        if( proveedor == null) throw new EntidadException("Debe indicar el Proveedor");
        if( moneda == null )  throw new EntidadException("Debe indicar la Moneda");
        if( entidad == null ) throw new EntidadException("Debe indicar la Entidad");
        if(compraConPresupuesto){
            CompraConPresupuesto compraConPresupuesto = new CompraConPresupuesto(
                    fechaCompra,
                    proveedor,
                    moneda,
                    entidad
            );
            return compraConPresupuesto;
        }
        else{
            Compra compra = new Compra();


            return compra;
        }

    }*/
}
