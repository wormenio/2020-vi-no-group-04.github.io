package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("NC")
public class NotaCredito extends DocumentoComercial {
/*	Integer numero;

	public NotaCredito(Integer numero){
		this.numero = numero;
	}

	@Override
	public Integer getNumero() {
		return this.numero;
	}*/
}
