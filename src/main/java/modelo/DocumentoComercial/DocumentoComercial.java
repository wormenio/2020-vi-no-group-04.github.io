package modelo.DocumentoComercial;

import modelo.EntidadPersistente;
import modelo.Entidades.Entidad;

import javax.persistence.*;

@Entity(name = "Documentos_comerciales")
@DiscriminatorColumn(name = "tipo_documento",length = 20)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DocumentoComercial extends EntidadPersistente {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}
*/
//	Integer getNumero();

}
