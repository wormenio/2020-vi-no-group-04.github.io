package modelo.Presupuesto;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.Item;
import modelo.Moneda;
import modelo.Proveedor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Presupuestos")
public class Presupuesto {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "fecha")
	private LocalDate fechaPresupuesto;

	@ManyToOne
	private Proveedor proveedor;

	@ManyToOne
	private DocumentoComercial documentoComercial;

	@OneToMany
	@JoinColumn(name="presupuesto_id")
	private Collection<ItemsDelPresupuesto> itemsDelPresupuesto = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "moneda_id")
	Moneda moneda;

	public void agregarItem(Item item, Double monto ) {
		ItemsDelPresupuesto itemDelPresupuesto	= new ItemsDelPresupuesto();
		itemDelPresupuesto.setItem(item);
		itemDelPresupuesto.setMonto(monto);

		itemsDelPresupuesto.add(itemDelPresupuesto);
	}

	public Collection<ItemsDelPresupuesto> getItems() {
		return itemsDelPresupuesto;
	}

	public Double getTotal() {
		// TODO
		Double importeTotal = 0.0;
//		double importeTotal = items.stream()
//			      .mapToDouble(o -> o.getImporte())
//			      .sum();
		return importeTotal;
	}

	/*public Presupuesto(Proveedor proveedor, LocalDate fechaPresupuesto, Egreso compra,
					   DocumentoComercial documentoComercial, Moneda moneda){
		if( compra == null ) throw new ComprasException("Debe indicar la compra");
		this.proveedor = proveedor;
		this.fechaPresupuesto = fechaPresupuesto;
		this.compra = compra;
		this.documentoComercial = documentoComercial;
		compra.agregarPresupuesto(this);
		this.moneda = moneda;
	}*/
}
