package modelo;

public class DatosPais {
	private String id;
	private String name;
	private String locale;
	private String currency_id;
	
	public DatosPais() {
		
	}
	
	public String verMoneda() {
		return currency_id;
	}

	public String verID() {
		return id;
	}
}
