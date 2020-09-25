package entities;


import entities.EntidadPersistente;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Documentos_comerciales")
public class DocumentoComercial extends EntidadPersistente {

    @OneToMany
    @JoinColumn(name = "documento_comercial_id")
    private Collection<DocumentoComercialCompra> documentosComercialesCompra;

}
