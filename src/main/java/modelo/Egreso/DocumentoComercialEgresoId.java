package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.print.Doc;
import java.io.Serializable;

@Embeddable
public class DocumentoComercialEgresoId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "egreso_id")
    private Integer egresoId;


    @ManyToOne
    @JoinColumn(name = "documento_comercial_id")
    private DocumentoComercial documentoComercial;
/*

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }
*/
    public void setDocumentoComercial(DocumentoComercial documentoComercial) {
        this.documentoComercial = documentoComercial;
    }

    public DocumentoComercial getDocumentoComercial() {
        return documentoComercial;
    }
}
