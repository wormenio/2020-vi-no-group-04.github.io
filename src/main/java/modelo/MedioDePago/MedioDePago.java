package modelo.MedioDePago;

import modelo.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "medios_de_pago")
@DiscriminatorColumn(name = "tipo_medio",length = 15)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class  MedioDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_referencia")
    private Integer numeroReferencia;


    public Long getId() {
        return id;
    }

    public Integer getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(Integer numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

}
