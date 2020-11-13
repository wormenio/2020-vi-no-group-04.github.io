package modelo.Presupuesto;

import modelo.Egreso.Item;

import javax.persistence.*;

@Entity(name = "items_del_presupuesto")
public class ItemsDelPresupuesto {


    @EmbeddedId
    ItemsDelPresupuestoId id;
/*

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
*/

    @Column(name = "monto")
    private Double precioUnitario;
    private Integer cantidad;

//    public Long getId() {
//        return id;
//    }

    public void setItem(Item item) {
        id.setItem(item);
    }

    public Item getItem(){
        return id.getItem();
    }

    public void setMonto(Double monto) {
        this.precioUnitario = monto;
    }

    public Double getMonto() {
        return precioUnitario;
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
