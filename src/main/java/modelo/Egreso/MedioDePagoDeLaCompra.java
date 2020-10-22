package modelo.Egreso;

import modelo.MedioDePago.MedioDePago;

public class MedioDePagoDeLaCompra {
    MedioDePago medioDePago;
    Double monto;
    public MedioDePagoDeLaCompra(MedioDePago medioDePago, Double monto){
        this.medioDePago = medioDePago;
        this.monto = monto;
    }

    public MedioDePago getMedioDePago(){
        return medioDePago;
    }
}
