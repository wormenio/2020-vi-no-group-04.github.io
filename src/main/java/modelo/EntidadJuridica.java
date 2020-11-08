package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;

import java.util.HashSet;
import java.util.Set;

import modelo.FuncionesUtiles.Utils;

public class EntidadJuridica implements Entidad {

	static final String tipoEntidad = "ENTIDADJURIDICA";
	String cuit;
	String razonSocial;
	String nombreFicticio;
	DireccionPostal direccionPostal;
	Integer codigoIGJ;
	CategoriaEntidadJuridica categoriaEntidadJuridica;
	Set<EntidadBase> entidadesBase = new HashSet<>();
	Integer montoMaximoEgreso;
	Integer cantidadEmpleados;
	EntidadJuridica agrupacion;
	CategoriaEntidad categoriaEntidad;
	Organizacion organizacion;

	public EntidadJuridica(String razonSocial,String nombreFicticio,String cuit, DireccionPostal direccionPostal,
						CategoriaEntidadJuridica categoria,Organizacion organizacion){

		this.categoriaEntidadJuridica = categoria;
		validarCuit(cuit);
		this.razonSocial = razonSocial;
		this.nombreFicticio = nombreFicticio;
		this.cuit = cuit;
		this.direccionPostal = direccionPostal;
		organizacion.aregarEntidad(this);
	}

	public void setCodigoIGJ(Integer codigoIGJ){
		this.codigoIGJ = codigoIGJ;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados){
		this.cantidadEmpleados = cantidadEmpleados;
	}

	/*public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio) {
		categoriaEntidad = new CategoriaEntidad(codigoCategoria,reglasDeNegocio);
	}*/

	@Override
	public String getNombreFicticio() {
		return nombreFicticio;
	}

	@Override
	public void setCategoriaEntidad(CategoriaEntidad categoria) {
		this.categoriaEntidad = categoria;
	}

	public String getRazonSocial(){
		return  razonSocial;
	}

	public String getCuit(){
		return cuit;
	}

	public DireccionPostal getDireccionPostal(){
		return direccionPostal;
	}

/*	@Override
	public void setCategoriaEntidadJuridica(CategoriaEntidadJuridica categoria) {
		this.categoriaEntidadJuridica = categoria;
	}*/


	public CategoriaEntidadJuridica getCategorizacionEntiodadJuridica(){
		return categoriaEntidadJuridica;
	}

	public Integer getMontoMaximoEgreso(){
		return montoMaximoEgreso;
	}

	public String getTipoEntidad(){
		return tipoEntidad;
	}

	@Override
	public Boolean esEntidadBase() {
		return false;
	}

	@Override
	public Boolean esEntidadJuridica() {
		return true;
	}

	private void validarCuit(String cuit){
		Utils utils = new Utils();
		if ( !utils.validarEr(cuit,"^[0-9]{11}$") ){
			throw new EntidadException("El cuit debe ser numerico y tener 11 digitos");
		}
	}

	public void addEntidadBase(EntidadBase entidad){
		validarBaseTieneEntidadJuridica(entidad);
		entidadesBase.add(entidad);
		entidad.setEntidadJuridica(this);
	}

	private void validarBaseTieneEntidadJuridica(EntidadBase entidad){

		if ( entidad.tieneEntidadJuridica() ){
			throw new EntidadException("La Entidad "+entidad.getNombreFicticio()+ " ya pertenece a una entidad juridica");
		}
	}

	public ClasificacionAFIP getClasificacionAFIP(){
			return categoriaEntidadJuridica.getClasificacionAFIP(cantidadEmpleados);
	}

	public Organizacion getOrganizacion(){
		return organizacion;
	}

}
