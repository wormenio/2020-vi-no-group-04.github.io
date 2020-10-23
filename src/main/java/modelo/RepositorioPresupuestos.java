package modelo;

import modelo.Egreso.Presupuesto;

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
}
