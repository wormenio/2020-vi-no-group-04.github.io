package modelo;

import com.mysql.jdbc.AssertionFailedException;
import modelo.Egreso.*;
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
    public Presupuesto presupuestoCompraCuadernos;
    public ItemsDelPresupuesto presupuestoResma;
    public ItemsDelPresupuesto presupuestoToner;
    public ItemsDelPresupuesto presupuestoCuaderno;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
        Item itemResma    = testHelpers.itemResma;
        Item itemCuaderno = testHelpers.itemCuaderno;
        Item itemToner    = testHelpers.itemTonerImpresora;

      /*  unaCompraSinPresupuesto = new BuilderCompra()
                .setProveedor(testHelpers.proveedorOfimatica)
                .setEntidad(testHelpers.entidadBaseLaComercial)
                .crearCompra();
*/
        unaCompraConPresupuesto = new BuilderCompra()
                .setConPresupuesto(true)
                .setProveedor(testHelpers.proveedorOfimatica)
                .setCantidadPresupuesto(2)
                .setEntidad(testHelpers.entidadBaseLaComercial)
                .setMoneda(testHelpers.pesoArgentino)
                .crearCompra();

        unaCompraConPresupuesto.agregarItem(itemResma,150.0);
        unaCompraConPresupuesto.agregarItem(itemToner,1250.0);

        presupuestoCompraResmaYToner = new Presupuesto(
                testHelpers.proveedorOfimatica,
                LocalDate.now(),
                unaCompraConPresupuesto,
                testHelpers.remito2,
                testHelpers.pesoArgentino
        );

        unaCompraConPresupuesto.agregarPresupuesto(presupuestoCompraResmaYToner);

        presupuestoCompraResmaYToner.addItem(itemResma,150.0);
        presupuestoCompraResmaYToner.addItem(itemToner,1250.0);

        repositorio = new RepositorioCompras();
        repositorio.agregarCompraConPresupuesto(unaCompraConPresupuesto);

    }

    @Test
    public void registroDePresupuestos(){
        //Se debe llevar registro de los presupuestos, tanto el total, como sus detalles y los documentos comerciales
        // (manteniendo los datos requeridos para las operaciones de egresos).

        // Si registro un presupuesto => puedo consultarlo

        Assert.assertTrue( repositorio.comprasConPresupuesto.stream()
                .filter( compra -> compra.getPresupuestos().contains(presupuestoCompraResmaYToner)
                )
                .count() >0
                );

    }

    @Test
    public void noSePuedeCargarPresupuestoSinCompra(){
        try {
            Presupuesto otroPresupuesto = new Presupuesto(
                    testHelpers.proveedorOfimatica,
                    LocalDate.now(),
                    null,
                    testHelpers.remito2,
                    testHelpers.pesoArgentino
            );
        } catch (Exception e) {
            assertEquals("Debe indicar la compra", e.getMessage());
        }

    }

    @Test
    public void validarQueLaCompraTengaCargadoLaCantidadDePresupuestosIndicados(){
        
    }
}
