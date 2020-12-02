package modelo.Egreso;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemsDeCompraId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Long compraId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

}
