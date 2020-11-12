package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Factura")
public class Factura extends DocumentoComercial {

/*
	private Integer nroFactura;

	private String tipoFactura;
	private LocalDate fecha;*/
/*

	public Factura(Integer nroFactura,String tipoFactura){
		this.nroFactura = nroFactura;
		this.tipoFactura = tipoFactura;
	}
*/


//	public Integer getNumero() {
//		return this.nroFactura;
//	}
}
