package modelo;

public class Pais {
	String nombre;
	Moneda moneda;
	
	public Pais(String name, String currency) {
		this.nombre=name;
		moneda = new Moneda(currency);
	}
}
