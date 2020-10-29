package modelo;

import modelo.CategoriaEntidad.ReglasDeNegocio;

public interface Entidad {
	public String getNombreFicticio();

//	public void setCategoriaEntidadJuridica(CategoriaEntidadJuridica categoria);
	public Integer getMontoMaximoEgreso();
	public String getTipoEntidad();
	public Boolean esEntidadBase();
	public Boolean esEntidadJuridica();
	public Organizacion getOrganizacion();

}
