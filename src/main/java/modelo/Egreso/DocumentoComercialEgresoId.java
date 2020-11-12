package modelo.Egreso;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DocumentoComercialEgresoId implements Serializable {

    @Column(name="egreso_id")
    private Integer egresoId;


    @Column(name="documento_comercial_id")
    private Long documentoComercialId;
/*

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public void setDocumentoComercialId(Long documentoComercialId) {
        this.documentoComercialId = documentoComercialId;
    }
*/

}
