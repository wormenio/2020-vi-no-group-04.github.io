package modelo;

/*import com.mysql.jdbc.AssertionFailedException;
import com.mysql.jdbc.PreparedStatement;*/
import modelo.Egreso.*;
import modelo.Entidades.EntidadBase;
import modelo.Presupuesto.ItemsDelPresupuesto;
import modelo.Presupuesto.Presupuesto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPresupuesto {
    public TestHelpers testHelpers;
    public Compra unaCompraSinPresupuesto;
    public Compra unaCompraConPresupuesto;
    public Presupuesto presupuestoCompraResmaYToner;
    public RepositorioCompras repositorio;
    public Item itemResma    ;
    public Item itemToner   ;

    public Presupuesto presupuestoCompraCuadernos;
    public ItemsDelPresupuesto presupuestoResma;
    public ItemsDelPresupuesto presupuestoToner;
    public ItemsDelPresupuesto presupuestoCuaderno;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
//        itemResma    = testHelpers.itemResma;
//        Item itemCuaderno = ;
        itemToner    = new Item();

      /*  unaCompraSinPresupuesto = new BuilderCompra()
                .setProveedor(testHelpers.proveedorOfimatica)
                .setEntidad(testHelpers.entidadBaseLaComercial)
                .crearCompra();
*/
        unaCompraConPresupuesto = new BuilderCompra()
                .setRequierePresupuesto(true)
                .setProveedor(new Proveedor())
                .setCantidadPresupuesto(2)
                .setEntidad(new EntidadBase())
                .setMoneda(new Moneda())
                .crearCompra();

        unaCompraConPresupuesto.agregarItem(itemResma,150.0);
        unaCompraConPresupuesto.agregarItem(itemToner,1250.0);

        presupuestoCompraResmaYToner = new Presupuesto();

        unaCompraConPresupuesto.agregarPresupuesto(presupuestoCompraResmaYToner);

        presupuestoCompraResmaYToner.agregarItem(itemResma,150.0);
        presupuestoCompraResmaYToner.agregarItem(itemToner,1250.0);

        repositorio = new RepositorioCompras();
        repositorio.agregarCompra(unaCompraConPresupuesto);

    }

    @Test
    public void registroDePresupuestos(){
        //Se debe llevar registro de los presupuestos, tanto el total, como sus detalles y los documentos comerciales
        // (manteniendo los datos requeridos para las operaciones de egresos).

        // Si registro un presupuesto => puedo consultarlo

        Assert.assertTrue( repositorio.compras.stream()
                .filter( compra -> compra.getPresupuestos().contains(presupuestoCompraResmaYToner)
                )
                .count() >0
                );

    }

    @Test
    public void noSePuedeCargarPresupuestoSinCompra(){
        try {
            Presupuesto otroPresupuesto = new Presupuesto();
        } catch (Exception e) {
            assertEquals("Debe indicar la compra", e.getMessage());
        }

    }

    @Test
    public void validarSeCorrespondeConAlMenosUnPresupuesto(){
        Assert.assertTrue(unaCompraConPresupuesto.seCorrespondeConAlMenosUnPresupuesto());
    }

    @Test
    public void validarPorCriterioDeMenorValor(){
        Presupuesto otroPresupuesto = new Presupuesto();

        presupuestoCompraResmaYToner.agregarItem(itemResma,100.0);
        presupuestoCompraResmaYToner.agregarItem(itemToner,1250.0);

        unaCompraConPresupuesto.agregarPresupuesto(presupuestoCompraResmaYToner);
        unaCompraConPresupuesto.setPresupuestoAsignado(otroPresupuesto);
        Assert.assertTrue(unaCompraConPresupuesto.validarPorCriterioDeMenorValor());

    }
}
