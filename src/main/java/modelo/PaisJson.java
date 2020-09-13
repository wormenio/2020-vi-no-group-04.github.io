package modelo;

public class PaisJson {
	private String id;
	private String name;
	private String locale;
	private String currency_id;
	
	public PaisJson() {
		
		
		
	}
	
	public String verLocale() {
		return locale;
		
	}
	public String verMoneda() {
		return currency_id;
	}
	public String verNombre() {
		return name;
	}

	public String verID() {
		return id;
	}
}
