package modelo;

public class RestPais {
	private String id;
	private String name;
	private String locale;
	private String currency_id;
	
	public RestPais() {
		
		
		
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
