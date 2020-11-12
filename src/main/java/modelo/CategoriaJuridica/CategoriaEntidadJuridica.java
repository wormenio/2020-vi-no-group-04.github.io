package modelo.CategoriaJuridica;

import modelo.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "Categorias_juridicas")
@DiscriminatorColumn(name="tipo_categoria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CategoriaEntidadJuridica extends EntidadPersistente {


	public abstract CategoriaJuridica getCategoriaEntidadJuridica();
	public abstract ClasificacionAFIP getClasificacionAFIP(Integer cantidadEmpleados);
}
