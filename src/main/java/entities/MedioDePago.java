package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tipos_medio_de_pago")
public class MedioDePago extends EntidadPersistente{

    @OneToMany
    @JoinColumn(name="tipo_medio_pago_id")
    private List<MediosDePagoCompra> mediosDePago = new ArrayList<>();
}
