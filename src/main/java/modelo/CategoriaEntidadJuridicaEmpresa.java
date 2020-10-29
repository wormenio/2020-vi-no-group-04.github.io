package modelo;

public class CategoriaEntidadJuridicaEmpresa implements CategoriaEntidadJuridica {
//	ClasificacionAFIP categorizacion;


	public CategorizacionEntidadJuridica getCategoriaEntidadJuridica()
	{
		return CategorizacionEntidadJuridica.EMPRESA;
	}


	public ClasificacionAFIP getClasificacionAFIP(Integer cantidadEmpleados) {
		ClasificacionAFIP categoria =
				(cantidadEmpleados <= 5 && cantidadEmpleados <= 15) ? ClasificacionAFIP.MICRO :
				(cantidadEmpleados > 15 && cantidadEmpleados <= 60) ? ClasificacionAFIP.PEQUENIA :
				(cantidadEmpleados > 60 && cantidadEmpleados <= 235) ? ClasificacionAFIP.MEDIANA_TRAMO_1 :
				ClasificacionAFIP.MEDIANA_TRAMO_2;
		return categoria;
	}

}
