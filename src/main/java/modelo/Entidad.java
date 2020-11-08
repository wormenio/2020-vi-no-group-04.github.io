package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.CategoriaEntidad.ReglasDeNegocio;

public interface Entidad {
	public String getNombreFicticio();

	public void setCategoriaEntidad(CategoriaEntidad categoria);
	public Integer getMontoMaximoEgreso();
	public String getTipoEntidad();
	public Boolean esEntidadBase();
	public Boolean esEntidadJuridica();
	public Organizacion getOrganizacion();

}
