package modelo;
import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.DocumentoComercial.DocumentoComercial;
import modelo.DocumentoComercial.Factura;
import modelo.Egreso.*;
import modelo.Entidades.EntidadBase;
import modelo.MedioDePago.MedioDePago;
import modelo.MedioDePago.TarjetaDeCredito;
import modelo.Presupuesto.Presupuesto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestCompra {
    public Compra unaCompraSinPresupuesto;
    public RepositorioCompras repositorioCompras;
    public DocumentoComercial facturaC258;
    public Proveedor proveedorOfimatica;
    public Item itemResma;
    public Item itemTonerImpresora;

    public MedioDePago tarjetaCredito5875;
//    public TestHelpers testHelpers;
    public Organizacion gesoc = new Organizacion();

    @Before
    public void init(){

        unaCompraSinPresupuesto = new Compra();
        repositorioCompras = new RepositorioCompras();

        repositorioCompras.agregarCompra(unaCompraSinPresupuesto);


//        testHelpers = new TestHelpers();
        facturaC258 = new Factura();
//        proveedorOfimatica = testHelpers.proveedorOfimatica;
        itemResma = new Item();
        itemTonerImpresora = new Item();
        tarjetaCredito5875 = new TarjetaDeCredito();


    /*

        unaCompraSinPresupuesto = testHelpers.laComercialCompraResmaYTonerAOfimatica(LocalDate.now());
        unaCompraSinPresupuesto.addMediosDePago(tarjetaCredito5875, 10.0);


        repositorioCompras.agregarCompraSinPresupuesto(unaCompraSinPresupuesto);
*/
    }

    @Test
    public void registroDeLasOperacionesDeEgresos(){
        //    Se debe llevar registro de todas las operaciones de egresos de fondos a través de diversos medios de pagos.
        Set<Compra> variasCompras = new HashSet<>();
        variasCompras.add(unaCompraSinPresupuesto);
        Assert.assertEquals(repositorioCompras.getCompras(),variasCompras);
    }

    @Test
    public void compraTieneDocumentoComercial(){
        //Requerimiento 1
        Collection<DocumentoComercial> documentos = new HashSet<>();
        documentos.add(facturaC258);
        unaCompraSinPresupuesto.agregarDocumentoComercial(facturaC258, 252, LocalDate.now());
        Assert.assertEquals(unaCompraSinPresupuesto.getDocumentoComercial(), documentos);
    }

    @Test
    public void elDocumentoComercialEsOpcional(){
        //Requerimiento 1
        Assert.assertEquals(unaCompraSinPresupuesto.getDocumentoComercial(),new HashSet<>());
    }

    @Test
    public void conocerElProveedorDeUnaOperacionDeEgreso(){
        //Requerimiento 3
        Set<Proveedor> proveedores = new HashSet<>();
        proveedores.add(proveedorOfimatica);
        Assert.assertEquals(unaCompraSinPresupuesto.getProveedor(), proveedorOfimatica);
    }

    @Test
    public void seConoceElDetalleDeLosItemsDelEgreso(){
        //Requerimiento 4

        Assert.assertTrue(unaCompraSinPresupuesto.getItems()
                .stream()
                .filter(item -> item.getItem().equals(itemResma)
                            && item.getPrecioUnitario()== 250.0
                        )
                .collect(Collectors.toSet())
                .size()>0
        );

    }


    @Test
    public void llevarRegistroMedioDePago(){
        //5.- De los medios de pago se debe registrar el medio en sí mismo y algún dato que permita identificar el instrumento
        // utilizado (por ejemplo, si es una tarjeta de débito, su número ; si es un cheque, su número; etc.)

        // => Si agrego un medio de pago, lo puedo consultar

        Assert.assertTrue(unaCompraSinPresupuesto.getMediosDePago().stream()
                    .filter( medioDePago ->
                                    medioDePago.getMedioDePago() == tarjetaCredito5875
                            )
                .count() >0
                );
    }

    @Test
    public void validarQueLaCompraTengaCargadoLaCantidadDePresupuestosIndicados(){
        Compra unaCompraConPresupuesto = new BuilderCompra()
                .setRequierePresupuesto(true)
                .setProveedor(new Proveedor())
                .setEntidad(new EntidadBase("La Comercial","Venta de Ropas",
                        new CategoriaEntidad() ))
                .setMoneda(new Moneda())
                .setCantidadPresupuesto(5)
                .crearCompra();

        Presupuesto presupuestoCompraResmaYToner = new Presupuesto();

        unaCompraConPresupuesto.agregarPresupuesto(presupuestoCompraResmaYToner);
        gesoc.setCantidadPresupuestosRequeridos(1);
        unaCompraConPresupuesto.validarCantidadDePresupuestos();
        Assert.assertTrue(unaCompraConPresupuesto.validarCantidadDePresupuestos());

    }



}
