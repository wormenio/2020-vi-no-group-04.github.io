package modelo;

public class OrganizacionFormal implements TipoOrganizacion {
	String razonSocial;
	int cuit;
	String direccionPostal;
	int codigoIGJ;
	CategoriaEntidadJuridica categoria;
	String nombreFicticio;
	
	@Override
	public String nombreFicticio()
	{
		return this.nombreFicticio;
	}
}
