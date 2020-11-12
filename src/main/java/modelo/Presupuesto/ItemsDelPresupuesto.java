package modelo.Presupuesto;

import modelo.Egreso.Item;

import javax.persistence.*;

@Entity(name = "items_del_presupuesto")
public class ItemsDelPresupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Double monto;
    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    /*  public ItemsDelPresupuesto(Item item, Double monto){
        this.item = item;
        this.monto = monto;
    }
*/

}
