package entities;

import javax.persistence.*;

@Entity
@Table(name = "Documentos_comerciales")
public class DocumentoComercial {
    @Id
    @GeneratedValue
    private int id;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_comercial_id")
    private TiposDocumentoComercial tipoDocumentoComercial;
}
