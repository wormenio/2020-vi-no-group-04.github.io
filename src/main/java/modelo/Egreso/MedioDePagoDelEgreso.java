package modelo.Egreso;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.*;

@Entity
@Table(name = "Medios_de_pago_del_egreso")
public class MedioDePagoDelEgreso {

    @EmbeddedId
    MediosDePagoDelEgresoId id;

    @ManyToOne
    @JoinColumn(name = "medio_de_pago_id")
    private MedioDePago medioDePago;

    @Column(name = "monto")
    Double montoEgreso;

    public void setMedioDePago(MedioDePago medioDePago){
        this.medioDePago = medioDePago;
    }

    public void setMonto(Double monto){
        this.montoEgreso = monto;
    }


    public MedioDePago getMedioDePago(){
        return medioDePago;
    }

    public Double getMonto(){
        return montoEgreso;
    }

    /*

    public MedioDePagoDeLaCompra(MedioDePago medioDePago, Double monto) {
        this.medioDePago = medioDePago;
        this.monto = monto;
    }
*/
}
