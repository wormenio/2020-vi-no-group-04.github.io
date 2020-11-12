package modelo.Entidades;

import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.Organizacion;

import javax.persistence.*;

@Entity
@Table(name = "Entidades")
@DiscriminatorColumn(name="tipo_entidad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Entidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private CategoriaEntidad categoriaEntidad;

	@Column(name = "monto_maximo_egreso")
	private Double MontoMaximoEgreso;

	@Column(name = "nombre_ficticio")
	private String nombreFicticio;


	@Transient
	Organizacion organizacion = new Organizacion();

	public abstract Boolean esEntidadBase();
	public abstract Boolean esEntidadJuridica();


	public String getNombreFicticio(){
		return nombreFicticio;
	}

	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}

	public void setMontoMaximoEgreso(Double montoMaximoEgreso) {
		MontoMaximoEgreso = montoMaximoEgreso;
	}
	public Double getMontoMaximoEgreso() {
		return MontoMaximoEgreso;
	}

	public Organizacion getOrganizacion(){
		return organizacion;
	}

	public void setCategoriaEntidad(CategoriaEntidad categoria){
		this.categoriaEntidad = categoria;
	}

	public CategoriaEntidad getCategoriaEntidad() {
		return categoriaEntidad;
	}


}
