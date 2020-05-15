package modelo;

public class Ticket implements DocumentoComercial {
	int nroTicket;
	
	@Override
	public int numero() {
		return this.nroTicket;
	}
}
