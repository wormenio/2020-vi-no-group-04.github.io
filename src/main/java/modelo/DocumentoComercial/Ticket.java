package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import java.time.LocalDate;

public class Ticket implements DocumentoComercial {
	Integer nroTicket;

	public Ticket(Integer nroTicket,LocalDate fecha){
		this.nroTicket = nroTicket;
	}

	@Override
	public Integer getNumero() {
		return this.nroTicket;
	}
}
