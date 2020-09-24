package entities;

import entities.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario extends EntidadPersistente {

    private String hash;
/*
    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol;*/
}
