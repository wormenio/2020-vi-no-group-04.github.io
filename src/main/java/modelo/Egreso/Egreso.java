package modelo.Egreso;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Entidades.Entidad;
import modelo.MedioDePago.MedioDePago;
import modelo.Moneda;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Egresos")
@DiscriminatorColumn(name = "tipo_egreso",length = 15)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Egreso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	@JoinColumn(name="entidad_id")
	private Entidad entidad;

	@Column(name = "fecha_compra")
	private LocalDate fechaCompra;

	@Column(name = "monto_total")
	private  Double montoTotal;

	@ManyToOne
	@JoinColumn(name = "moneda_id")
	private Moneda moneda;

	@OneToMany
	@JoinColumn(name = "egreso_id")
	private Collection<MedioDePagoDelEgreso> mediosDePago = new ArrayList<>();

	@OneToMany
	@JoinColumn(name="egreso_id")
	private Collection<DocumentoComercialEgreso> documentosComerciales = new ArrayList<>();



	@ManyToOne
	@JoinColumn(name = "etiqueta_id")
	private EtiquetaEgreso etiquetaEgreso;

	public Egreso(LocalDate fechaCompra, Moneda moneda,
				  Entidad entidad, EtiquetaEgreso etiquetaEgreso){

		if( moneda == null )  throw new ComprasException("Debe indicar la Moneda");
		if( entidad == null ) throw new ComprasException("Debe indicar la Entidad");
		this.fechaCompra = fechaCompra;
		this.moneda = moneda;
		this.entidad = entidad;
		this.etiquetaEgreso = etiquetaEgreso;
	}

	public Egreso() {

	}

	public Long getId() {
		return id;
	}


	public void agregarMediosDePago(MedioDePago medioDePago, double monto){
		MedioDePagoDelEgreso medioDePagoDeLaCompra = new MedioDePagoDelEgreso();
		medioDePagoDeLaCompra.setMedioDePago(medioDePago);
		medioDePagoDeLaCompra.setMonto(monto);

		mediosDePago.add(medioDePagoDeLaCompra);
	}

	public Collection<MedioDePagoDelEgreso> getMediosDePago() {
		return mediosDePago;
	}



	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Entidad getEntidad(){
		return entidad;
	}

	public void agregarDocumentoComercial(DocumentoComercial documento, Integer numeroDocumento, LocalDate fecha ){
		DocumentoComercialEgreso documentoComercialCompra = new DocumentoComercialEgreso();
		documentoComercialCompra.setDocumentoComercial(documento);
		documentoComercialCompra.setNumeroDocumento(numeroDocumento);
		documentoComercialCompra.setFechaDocumento(fecha);

		documentosComerciales.add(documentoComercialCompra);
	}

	public Collection<DocumentoComercialEgreso> getDocumentoComercial()
	{
		return documentosComerciales;
	}

	public LocalDate getFechaCompra()
	{
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public void setEtiquetaEgreso(EtiquetaEgreso etiquetaEgreso) {
		this.etiquetaEgreso = etiquetaEgreso;
    }

    public EtiquetaEgreso  getEtiquetaEgreso(){
         return etiquetaEgreso;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	//	private Collection<EtiquetaEgreso> etiquetasEgresos = new ArrayList<>();



/*
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setPresupuestoAsignado(Presupuesto presupuesto){ }

	public  void agregarPresupuesto(Presupuesto presupuesto){}

	public Set<Presupuesto> getPresupuestos(){
		return null;
	}

	public void setCantidadPresupuestosRequeridos(Integer cantidad){}

	public Boolean validarCantidadDePresupuestos(){
		return false;
	}

	public Boolean validarPorCriterioDeMenorValor() {
		return false;
	}

	public Boolean seCorrespondeConAlMenosUnPresupuesto(){
		return false;
	}
*/




//	public Iterable<Usuario> usuariosRevisores() {
//		return usuariosHabilitados;
//	}




//	public abstract String estadoValidacion();

}
