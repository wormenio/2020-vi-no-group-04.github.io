package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Documentos_comerciales_de_egresos")
public class DocumentoComercialEgreso {

    @EmbeddedId
    private DocumentoComercialEgresoId id= new DocumentoComercialEgresoId();

 /*   @ManyToOne
    @JoinColumn(name = "documento_comercial_id")
    private DocumentoComercial documentoComercial;
*/
    @Column(name = "numero")
    private Integer numeroDocumento;

    @Column(name = "fecha_documento")
    private LocalDate fechaDocumento;

    public void setFechaDocumento(LocalDate fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public LocalDate getFechaDocumento() {
        return fechaDocumento;
    }

    public void setDocumentoComercial(DocumentoComercial documentoComercial) {
//        this.documentoComercial = documentoComercial;
        id.setDocumentoComercial(documentoComercial);
    }

    public DocumentoComercial getDocumentoComercial() {
        return id.getDocumentoComercial();
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }
}
