package modelo.Entidades;

import java.util.ArrayList;
import java.util.Collection;

import modelo.CategoriaJuridica.CategoriaEntidadJuridica;
import modelo.CategoriaJuridica.ClasificacionAFIP;
import modelo.DireccionPostal.DireccionPostal;
import modelo.FuncionesUtiles.Utils;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Juridica")
public class EntidadJuridica extends Entidad {

	private String cuit;
	@Column(name = "razon_social")
	private String razonSocial;

	@ManyToOne
	@JoinColumn(name = "direccion_postal_id")
	private DireccionPostal direccionPostal;

	@Column(name = "codigo_igj")
	private Integer codigoIGJ;

	@Column(name="cantidad_empleados")
	private Integer cantidadEmpleados;

	@OneToMany
	@JoinColumn(name = "entidad_juridica_id")
	private Collection<EntidadBase> entidadesBase = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "categoria_juridica_id")
	private CategoriaEntidadJuridica categoriaJuridica;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "clasificacion_afip")
	private ClasificacionAFIP clasificacionAFIP;


	@Override
	public Boolean esEntidadBase() {
		return false;
	}

	@Override
	public Boolean esEntidadJuridica() {
		return true;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getCuit(){
		return cuit;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRazonSocial(){
		return  razonSocial;
	}

	public DireccionPostal getDireccionPostal(){
		return direccionPostal;
	}

	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public Integer getCodigoIGJ() {
		return codigoIGJ;
	}

	public void setCodigoIGJ(Integer codigoIGJ){
		this.codigoIGJ = codigoIGJ;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados){
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public Integer getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void agregarEntidadBase(EntidadBase entidad){
		validarBaseTieneEntidadJuridica(entidad);
		entidadesBase.add(entidad);
//		entidad.setEntidadJuridica(this);
	}

	public Collection<EntidadBase> getEntidadesBase() {
		return entidadesBase;
	}

	public CategoriaEntidadJuridica getCategorizacionEntiodadJuridica(){
		return categoriaJuridica;
	}

	public void setCategoriaJuridica(CategoriaEntidadJuridica categoriaJuridica) {
		this.categoriaJuridica = categoriaJuridica;
	}

	private void validarCuit(String cuit){
		Utils utils = new Utils();
		if ( !utils.validarEr(cuit,"^[0-9]{11}$") ){
			throw new EntidadException("El cuit debe ser numerico y tener 11 digitos");
		}
	}


	public ClasificacionAFIP getClasificacionAFIP(){
		return categoriaJuridica.getClasificacionAFIP(cantidadEmpleados);
	}




	private void validarBaseTieneEntidadJuridica(EntidadBase entidad){
// TODO VER SI ES NECESARIO

/*		if ( entidad.tieneEntidadJuridica() ){
			throw new EntidadException("La Entidad "+entidad.getNombreFicticio()+ " ya pertenece a una entidad juridica");
		}*/
	}



	///////////////









	/*public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio) {
		categoriaEntidad = new CategoriaEntidad(codigoCategoria,reglasDeNegocio);
	}*/
/*	@Override
	public void setCategoriaEntidadJuridica(CategoriaEntidadJuridica categoria) {
		this.categoriaEntidadJuridica = categoria;
	}*/


	/*
	public EntidadJuridica(String razonSocial,String nombreFicticio,String cuit, DireccionPostal direccionPostal,
						CategoriaEntidadJuridica categoria,Organizacion organizacion){

		this.categoriaEntidadJuridica = categoria;
		validarCuit(cuit);
		this.razonSocial = razonSocial;
		this.nombreFicticio = nombreFicticio;
		this.cuit = cuit;
		this.direccionPostal = direccionPostal;
		organizacion.aregarEntidad(this);
	}*/

}
