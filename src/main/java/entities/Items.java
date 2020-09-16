package entities;

import entities.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items extends EntidadPersistente {
}
