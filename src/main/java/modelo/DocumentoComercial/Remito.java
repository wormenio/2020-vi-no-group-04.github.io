package modelo.DocumentoComercial;

import java.time.LocalDate;

public class Remito implements DocumentoComercial {
    Integer numero;

    public Remito(Integer nroTicket){
        this.numero = numero;
    }

    @Override
    public Integer getNumero() {
        return this.numero;
    }

}
