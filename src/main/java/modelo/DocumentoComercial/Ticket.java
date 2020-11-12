package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Ticket")
public class Ticket extends DocumentoComercial {
/*	Integer nroTicket;

	public Ticket(Integer nroTicket,LocalDate fecha){
		this.nroTicket = nroTicket;
	}

	@Override
	public Integer getNumero() {
		return this.nroTicket;
	}*/
}
