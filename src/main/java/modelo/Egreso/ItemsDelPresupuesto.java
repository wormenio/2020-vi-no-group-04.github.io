package modelo.Egreso;

public class ItemsDelPresupuesto {
    Item item;
    Double monto;

    public ItemsDelPresupuesto(Item item, Double monto){
        this.item = item;
        this.monto = monto;
    }

    public Item getItem(){
        return item;
    }
}
