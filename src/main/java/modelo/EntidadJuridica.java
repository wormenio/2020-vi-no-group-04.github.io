package modelo;

import java.util.ArrayList;
import java.util.List;

public class EntidadJuridica implements Entidad {
	EntidadJuridica agrupacion;
	int cuit;
	String razonSocial;
	DireccionPostal direccionPostal;
	int codigoIGJ;
	CategoriaEntidadJuridica categoria;
	List<EntidadBase> conformadaPor = new ArrayList<EntidadBase> ();
	
	public String getNombreFicticio()
	{
		return razonSocial;
	}
}
