package modelo.Egreso;

import modelo.*;
import modelo.Entidades.Entidad;
import modelo.Presupuesto.Presupuesto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@DiscriminatorValue("Compra")
public class Compra extends Egreso {

	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;


	@Column(name = "requiere_presupuesto")
	private Boolean requierePresupuesto;

	@Column(name = "cantidad_presupuesto")
	private int cantidadPresupuestos;

	@Column(name = "compra_validada")
	Boolean compraValidada;

	@Column(name = "fecha_validacion")
	LocalDate fechaValidacion;

	@OneToOne
	@JoinColumn(name = "presupuesto_asignado_id")
	private Presupuesto presupuestoAsignado;

	@OneToMany
	@JoinColumn(name = "compra_id")
	private Collection<Presupuesto> presupuestos = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "usuario_revisor_compras")
	private Collection<Usuario> revisores = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "compra_id")
	private Collection<ItemsDeLaCompra> itemsDeCompra = new ArrayList<>();



	@Enumerated(EnumType.ORDINAL)
	Criterio criterio;

	public Compra() {
	}

	public Compra(LocalDate fechaCompra, Proveedor proveedor, Moneda moneda,
				  Entidad entidad, EtiquetaEgreso etiquetaEgreso) {
		super(fechaCompra, moneda, entidad, etiquetaEgreso);
		if( proveedor == null) throw new ComprasException("Debe indicar el Proveedor");
		this.proveedor = proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setCantidadPresupuestos(int cantidadPresupuestos) {
		this.cantidadPresupuestos = cantidadPresupuestos;
	}

	public int getCantidadPresupuestos() {
		return cantidadPresupuestos;
	}

	public void setPresupuestoAsignado(Presupuesto presupuesto){
		if( !presupuestos.contains(presupuesto) )
			throw  new ComprasException("El presupuesto no se encuentra en la lista de presupuestos");

		this.presupuestoAsignado = presupuesto;
	}

	public void agregarItem(Item item,Double monto){
		ItemsDeLaCompra itemDeLaCompra = new ItemsDeLaCompra();
//		itemDeLaCompra.setItem(item);
		itemDeLaCompra.setPrecioUnitario(monto);
//		itemDeLaCompra.id.setCompraId(getId());

		itemsDeCompra.add(itemDeLaCompra);
	}

	public Collection<ItemsDeLaCompra> getItems(){
		return itemsDeCompra;
	}

	public boolean esRevisor(Usuario usuario) {
		 return this.revisores.contains(usuario);
	 }
	 
	public Collection<Usuario> usuariosRevisores(){
		return revisores;
	}

	public void hacerRevisor(Usuario usuario) {
		 this.revisores.add(usuario);
	 }



	 public boolean validarCompra(){
		 return this.validarCantidadDePresupuestos()
				 && this.validarPresupuestoAsignadoContenidoEnElListado()
				 && (this.criterio == Criterio.MENOR_VALOR) ? this.validarPorCriterioDeMenorValor() : true;
	 }

	 public Boolean validarCantidadDePresupuestos() {
		 return this.presupuestos.size() == super.getEntidad().getOrganizacion().getCantidadPresupuestosRequeridos();
	 }
	 
	 public boolean validarPresupuestoAsignadoContenidoEnElListado() {
		 return this.presupuestos.contains(this.presupuestoAsignado);		 
	 }

	public Boolean validarPorCriterioDeMenorValor() {
		Presupuesto minPresupuesto = this.presupuestos
				.stream()
				.min(Comparator.comparing(Presupuesto::getTotal))
				.orElseThrow(null);

		return minPresupuesto == this.presupuestoAsignado;
	}

	 public Collection<Presupuesto> getPresupuestos(){
		return presupuestos;
	 }


	public void agregarPresupuesto(Presupuesto presupuesto)
	 {
		 this.presupuestos.add(presupuesto);
	 }

	 public Boolean seCorrespondeConAlMenosUnPresupuesto(){
		return presupuestos.contains(presupuestoAsignado);
	 }

	public String estadoValidacion() {
		return Boolean.toString(compraValidada);
	}

	public void setCompraValidada(){
		compraValidada= this.validarCompra();
		fechaValidacion= LocalDate.now();
	}

	public Boolean getRequierePresupuesto(){
		return requierePresupuesto;
	}

	public void setRequierePresupuesto(Boolean requierePresupuesto) {
		this.requierePresupuesto = requierePresupuesto;
	}

	public Integer getAnio(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(java.sql.Timestamp.valueOf(super.getFechaCompra().toString()));
		return calendar.get(Calendar.YEAR);
	}

	public Integer getMes(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(java.sql.Timestamp.valueOf(super.getFechaCompra().toString()));
		return calendar.get(Calendar.MONTH);
	}

	public float getTotalEgreso() {

		//	return (float) items.stream().mapToDouble( item -> item.getImporte() ).sum();
		return 0;
	}




}
