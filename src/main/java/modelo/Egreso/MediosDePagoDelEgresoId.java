package modelo.Egreso;

import modelo.MedioDePago.MedioDePago;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MediosDePagoDelEgresoId implements Serializable {
    @Column(name = "egreso_id")
    private Long egresoId;

    @Column(name = "medio_de_pago_id")
    private Long medioDePagoId;
    /*
    @OneToMany
    @JoinColumn(name = "medio_de_pago_id")
    private MedioDePago medioDePago;*/
}
