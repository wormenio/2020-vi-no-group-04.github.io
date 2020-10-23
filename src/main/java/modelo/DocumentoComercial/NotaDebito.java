package modelo.DocumentoComercial;

import modelo.DocumentoComercial.DocumentoComercial;

import java.time.LocalDate;

public class NotaDebito implements DocumentoComercial {
	Integer numero;

	public NotaDebito(Integer numero){
		this.numero = numero;
	}

	@Override
	public Integer getNumero() {
		return this.numero;
	}
}
