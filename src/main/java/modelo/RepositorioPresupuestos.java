package modelo;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.Egreso;
import modelo.Presupuesto.Presupuesto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class RepositorioPresupuestos {
    Set<Presupuesto> presupuestos = new HashSet<>();

    public void addPresupuesto(Presupuesto presupuesto){
        presupuestos.add(presupuesto);
    }

    public Set<Presupuesto> getPresupuestos(){
        return presupuestos;
    }

    public void nuevoPresupuesto(Proveedor proveedor, LocalDate fechaPresupuesto, Egreso compra,
                       DocumentoComercial documentoComercial, Moneda moneda){
     /*   if( compra == null ) throw new ComprasException("Debe indicar la compra");
        this.proveedor = proveedor;
        this.fechaPresupuesto = fechaPresupuesto;
        this.compra = compra;
        this.documentoComercial = documentoComercial;
        compra.agregarPresupuesto(this);
        this.moneda = moneda;*/
    }

}
