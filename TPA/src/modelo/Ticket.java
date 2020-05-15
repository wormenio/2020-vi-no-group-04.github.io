package modelo;

public class Ticket implements DocumentoComercial {
	int nroTicket;
	
	@Override
	int numero() {
		return this.nroTicket;
	}
}
