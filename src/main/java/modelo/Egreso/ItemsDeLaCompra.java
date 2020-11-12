package modelo.Egreso;
/*

import entities.EntidadPersistente;
import entities.ItemsDeCompraId;
import entities.Moneda;
*/

import modelo.Moneda;

import javax.persistence.*;

@Entity(name = "Items_de_compra")
public class ItemsDeLaCompra  {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @EmbeddedId
    ItemsDeCompraId id;


    private Double precioUnitario;
    private Integer cantidad;

/*    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;*/

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setPrecioUnitario(Double monto) {
        this.precioUnitario = monto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setItem(Item item){
        id.setItem(item);
    }

    public Item getItem(){
        return id.getItem();
    }

    public void setCompraId(Long compraId){
        id.setCompraId(compraId);
    }

    public void setMoneda(Moneda moneda){
        this.moneda = moneda;
    }

    public Moneda getMoneda(){
        return moneda;
    }

   /*

    public ItemsDeLaCompra(Item item, Double monto){
        setId(item.getId());
        this.monto = monto;
    }
*/
}
