package modelo;

import entities.entidad.Categoria;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.CategoriaEntidad.ReglasDeNegocio;

public class EntidadBase implements Entidad {

	static final String tipoEntidad = "BASE";
	String descripcion;
	String nombreFicticio;
	CategoriaEntidad categoriaEntidad;
	Integer montoMaximoEgreso;
	EntidadJuridica entidadJuridica;
	Organizacion organizacion;

	public EntidadBase(String nombreFicticio,String descripcion, CategoriaEntidad categoriaEntidad,
					   Organizacion organizacion){
		this.descripcion = descripcion;
		this.categoriaEntidad = categoriaEntidad;
		this.nombreFicticio = nombreFicticio;
		organizacion.aregarEntidad(this);
	}

	public String getNombreFicticio() {	
		return this.descripcion;
	}

	public String getDescripcion(){
		return descripcion;
	}

	/*@Override
	public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio) {
		categoriaEntidad = new CategoriaEntidad(codigoCategoria,reglasDeNegocio);
	}*/
/*
	@Override
	public void setCategoriaEntidadJuridica(CategoriaEntidadJuridica categoria) {
		throw new EntidadException("Una Entidad Base no puede tener Categorizacion de Entidad juridica");
	}*/

	public Integer getMontoMaximoEgreso(){
		return montoMaximoEgreso;
	}

	public String getTipoEntidad(){
		return tipoEntidad;
	}

	@Override
	public Boolean esEntidadBase() {
		return true;
	}

	@Override
	public Boolean esEntidadJuridica() {
		return false;
	}

	public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
		this.entidadJuridica = entidadJuridica;
	}

	public Boolean tieneEntidadJuridica(){
		return this.entidadJuridica == null;
	}

	public Organizacion getOrganizacion(){
		return organizacion;
	}
}
