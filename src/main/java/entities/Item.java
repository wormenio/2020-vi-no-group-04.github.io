package entities;

import entities.EntidadPersistente;
import entities.presupuesto.ItemsDelPresupuesto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Items")
public class Item extends EntidadPersistente {

    @OneToMany
    @JoinColumn(name ="item_id")
    @OrderColumn(name = "nombre")
    private List<ItemsDeCompra> compras = new ArrayList<>();

    @OneToMany
    @JoinColumn(name ="item_id" )
    private Collection<ItemsDelPresupuesto> itemsDelPresupuestos;
}
