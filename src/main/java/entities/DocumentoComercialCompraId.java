package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DocumentoComercialCompraId implements Serializable {

    private int compra_id;
    private int documento_comercial_id;

}
