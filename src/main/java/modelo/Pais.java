package modelo;

import java.util.List;

public class Pais {
	String nombre;
	String id;
	String locale;
	Moneda moneda;
	
	public Pais(String name, String currency, String id, String locale) {
		this.nombre=name;
		this.id = id;
		this.locale = locale;
		moneda = new Moneda(currency);
	}
	public  String verNombre() {
		return nombre;
	}
	public  String verID() {
		return id;
	}
	public void agregarEstados(List<Estado> estadosSistema) {
		// TODO Auto-generated method stub
		
	}
}
