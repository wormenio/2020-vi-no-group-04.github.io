package modelo;

public class Pais {
	private String id;
	private String name;
	private String locale;
	private String currency_id;
	
	public Pais() {
		
	}
	
	public String verMoneda() {
		return currency_id;
	}

	public String verID() {
		return id;
	}
}
