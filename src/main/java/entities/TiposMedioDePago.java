package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tipos_medio_de_pago")
public class TiposMedioDePago extends EntidadPersistente{

    @OneToMany
    @JoinColumn(name="tipo_medio_pago_id")
    private List<MediosDePago> mediosDePago = new ArrayList<>();
}
