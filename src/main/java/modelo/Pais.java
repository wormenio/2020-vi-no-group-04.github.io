package modelo;

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
}
