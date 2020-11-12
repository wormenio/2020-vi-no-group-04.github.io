package modelo.DireccionPostal;

import modelo.EntidadPersistente;
import modelo.Estado;
import modelo.Moneda;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Paises")
public class Pais extends EntidadPersistente {

	@Column
	private String locale;

	@ManyToOne
	@JoinColumn(name = "moneda_id")
	private Moneda moneda;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocale() {
		return locale;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}
	/*
	public void agregarEstados(List<Estado> estadosSistema) {
		// TODO Auto-generated method stub ¿Qué es agregarEstados?

	}*/

	/*
	public Pais(String name, String currency,  String locale) {
		setNombre(name);

		this.locale = locale;
		moneda = new Moneda(currency);
	}*/
//	public  String verNombre() {
//		return nombre;
//	}
//	public  String verID() {
//		return id;
//	}

}
