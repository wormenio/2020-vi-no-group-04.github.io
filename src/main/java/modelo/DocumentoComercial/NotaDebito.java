package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("ND")
public class NotaDebito extends DocumentoComercial {
/*	Integer numero;

	public NotaDebito(Integer numero){
		this.numero = numero;
	}

	@Override
	public Integer getNumero() {
		return this.numero;
	}*/
}
