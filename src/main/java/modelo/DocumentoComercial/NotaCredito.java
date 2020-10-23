package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import java.time.LocalDate;

public class NotaCredito implements DocumentoComercial {
	Integer numero;

	public NotaCredito(Integer numero){
		this.numero = numero;
	}

	@Override
	public Integer getNumero() {
		return this.numero;
	}
}
