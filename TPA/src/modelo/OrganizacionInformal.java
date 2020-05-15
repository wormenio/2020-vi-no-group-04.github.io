package modelo;

public class OrganizacionInformal implements TipoOrganizacion{
	OrganizacionFormal agrupacion;
	String descripcion;
	String nombreFicticio;
	
	@Override
	public String nombreFicticio()
	{
		return this.nombreFicticio;
	}
}
