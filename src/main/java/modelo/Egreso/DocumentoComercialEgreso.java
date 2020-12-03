package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Documentos_comerciales_del_egreso")
public class DocumentoComercialEgreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "egreso_id")
    private Long egresoId;


    @ManyToOne
    @JoinColumn(name = "documento_comercial_id")
    private DocumentoComercial documentoComercial;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id")
    private EtiquetaEgreso etiquetaEgreso;


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
        this.documentoComercial = documentoComercial;
    }

    public void setEgresoId(Long egresoId) {
        this.egresoId = egresoId;
    }



    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }
}
