package modelo.Egreso;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.*;

@Entity(name = "Medios_de_pago_compra")
public class MedioDePagoDeLaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MedioDePago medioDePago;

    Double monto;

/*

    public MedioDePagoDeLaCompra(MedioDePago medioDePago, Double monto) {
        this.medioDePago = medioDePago;
        this.monto = monto;
    }
*/

    public void setMedioDePago(MedioDePago medioDePago){
        this.medioDePago = medioDePago;
    }

    public void setMonto(Double monto){
        this.monto = monto;
    }


    public MedioDePago getMedioDePago(){
        return medioDePago;
    }

    public Double getMonto(){
        return monto;
    }
}
