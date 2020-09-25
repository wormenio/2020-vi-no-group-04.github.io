package entities;

import entities.DocumentoComercial;

import javax.persistence.*;

@Entity
@Table(name = "Documentos_comerciales_compras")
public class DocumentoComercialCompra {

    @EmbeddedId
    private DocumentoComercialCompraId id;

    private int numero;


}
