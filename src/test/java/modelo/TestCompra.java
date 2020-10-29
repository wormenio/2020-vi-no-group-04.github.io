package modelo;
import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.*;
import modelo.MedioDePago.MedioDePago;
import modelo.MedioDePago.TarjetaDeCredito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestCompra {
    public CompraSinPresupuesto unaCompra;
    public RepositorioCompras repositorioCompras;
    public DocumentoComercial facturaC258;
    public Proveedor proveedorOfimatica;
    public Item itemResma;
    public Item itemTonerImpresora;

    public MedioDePago tarjetaCredito5875;
    public TestHelpers testHelpers;
    public Organizacion gesoc = testHelpers.geSoc;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
        facturaC258 = testHelpers.factura258;
        proveedorOfimatica = testHelpers.proveedorOfimatica;
        itemResma = testHelpers.itemResma;
        itemTonerImpresora = testHelpers.itemTonerImpresora;
        tarjetaCredito5875 = testHelpers.tarjetaCredito5875;

        unaCompra = testHelpers.laComercialCompraResmaYTonerAOfimatica(LocalDate.now());
        unaCompra.addMediosDePago(tarjetaCredito5875,10.0);

        repositorioCompras = new RepositorioCompras();
        repositorioCompras.agregarCompraSinPresupuesto(unaCompra);

    }

    @Test
    public void registroDeLasOperacionesDeEgresos(){
        //    Se debe llevar registro de todas las operaciones de egresos de fondos a través de diversos medios de pagos.
        Set<CompraSinPresupuesto> variasCompras = new HashSet<>();
        variasCompras.add(unaCompra);
        Assert.assertEquals(repositorioCompras.getComprasSinPresupuesto(),variasCompras);
    }

    @Test
    public void compraTieneDocumentoComercial(){
        //Requerimiento 1
        Set<DocumentoComercial> documentos = new HashSet<>();
        documentos.add(facturaC258);
        unaCompra.addDocumentoComercial(facturaC258);
        Assert.assertEquals(unaCompra.getDocumentoComercial(), documentos);
    }

    @Test
    public void elDocumentoComercialEsOpcional(){
        //Requerimiento 1
        Assert.assertEquals(unaCompra.getDocumentoComercial(),new HashSet<>());
    }

    @Test
    public void conocerElProveedorDeUnaOperacionDeEgreso(){
        //Requerimiento 3
        Set<Proveedor> proveedores = new HashSet<>();
        proveedores.add(proveedorOfimatica);
        Assert.assertEquals(unaCompra.getProveedor(), proveedorOfimatica);
    }

    @Test
    public void seConoceElDetalleDeLosItemsDelEgreso(){
        //Requerimiento 4

        Assert.assertTrue(unaCompra.getItems()
                .stream()
                .filter(item -> item.getItem().equals(itemResma)
                            && item.getMonto()== 250.0
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

        Assert.assertTrue(unaCompra.getMediosDePago().stream()
                    .filter( medioDePago ->
                                    medioDePago.getMedioDePago() == tarjetaCredito5875
                            )
                .count() >0
                );
    }

    @Test
    public void validarQueLaCompraTengaCargadoLaCantidadDePresupuestosIndicados(){
        Compra unaCompraConPresupuesto = new BuilderCompra()
                .setConPresupuesto(true)
                .setProveedor(testHelpers.proveedorOfimatica)
                .setEntidad(testHelpers.entidadBaseLaComercial)
                .setMoneda(testHelpers.pesoArgentino)
                .crearCompra();

        Presupuesto presupuestoCompraResmaYToner = new Presupuesto(
                testHelpers.proveedorOfimatica,
                LocalDate.now(),
                unaCompraConPresupuesto,
                testHelpers.remito2,
                testHelpers.pesoArgentino
        );

        unaCompraConPresupuesto.agregarPresupuesto(presupuestoCompraResmaYToner);
        gesoc.setCantidadPresupuestosRequeridos(1);
        Assert.assertTrue(unaCompraConPresupuesto.validarCantidadDePresupuestos());

    }



}
