package entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Documentos_comerciales")
public class DocumentoComercial extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name="tipo_documento_comercial_id")
    private TipoDocumentoComercial tipoDocumentoComercial;
}
