package modelo;

import java.util.Date;

public interface Egreso{
	
	public DocumentoComercial getDocumentoComercial();	
	public Date getFechaEgreso();
	public MedioDePago getMedioDePagoEgreso();
	public float getTotalEgreso();
	public String getDetalleEgreso();
}
