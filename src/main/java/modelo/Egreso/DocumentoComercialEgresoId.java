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

    @Column(name = "egreso_id")
    private Long egresoId;

    @Column(name = "documento_comercial_id")
    private Long documentoComercial;



}
