package modelo;



import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Monedas")
public class Moneda extends EntidadPersistente{

    private String symbol;
    private Integer decimal_places;

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setDecimal_places(Integer decimal_places) {
        this.decimal_places = decimal_places;
    }

    public Integer getDecimal_places() {
        return decimal_places;
    }

    //    public Moneda(String currency) {
//        symbol=currency;
//    }
//    private String descripcion;

}
