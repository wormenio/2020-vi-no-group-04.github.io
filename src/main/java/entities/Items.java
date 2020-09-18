package entities;

import entities.EntidadPersistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Items")
public class Items extends EntidadPersistente {

    @OneToMany
    @JoinColumn(name ="item_id")
    @OrderColumn(name = "nombre")
    private List<ItemsDeCompra> compras = new ArrayList<>();
}
