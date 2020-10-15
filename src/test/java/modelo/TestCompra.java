package modelo;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.Egreso.Compras;
import modelo.Egreso.Item;
import modelo.MedioDePago.TarjetaDeCredito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestCompra {
    public Compras compraSemanal;
    public RepositorioCompras repositorioCompras;

    @Before
    public void init(){
        Pais argentina = new Pais("Argentina", "Pesos", "1", "Es-ar");
        Moneda pesoArgentino = new Moneda("PesoArgentino");
        Proveedor ofimatica = new Proveedor(argentina,
                "Ofimatica",
                "258969696",
                "mozart",
                "215",
                "1");

        TarjetaDeCredito tarjetaCredito = new TarjetaDeCredito(5875);
        Item resma = new Item("resma papel A4");
        CategoriaEntidad unaCategoria = new CategoriaEntidad(2585);
        EntidadBase laComercial = new EntidadBase("Venta Ropas",unaCategoria);

        compraSemanal = new Compras(LocalDate.now(), ofimatica,pesoArgentino,laComercial);
        compraSemanal.addMediosDePago(tarjetaCredito,10.00);
        compraSemanal.agregarItem(resma,50.00);

        repositorioCompras = new RepositorioCompras();
        repositorioCompras.agregarCompra(compraSemanal);

    }

    @Test
    public void registroDeLasOperacionesDeEgresos(){
        //    Se debe llevar registro de todas las operaciones de egresos de fondos a través de diversos medios de pagos.
        Set<Compras> variasCompras = new HashSet<>();
        variasCompras.add(compraSemanal);
        Assert.assertEquals(repositorioCompras.listadoDeCompras(),variasCompras);
    }

/*


    @Test
    public void probarRegistroConUsuarioNoValido()
    {
    	Assert.assertFalse(organizacion.registrarse("ale" , "4h9y2male5a0k", usuarioComun));
    }
    
    @Test
    public void probarRegistroConClaveNoValida()
    {
    	Assert.assertFalse(organizacion.registrarse("ler9ohtw4" , "111122222", usuarioComun));
    }
    
    @Test
    public void probarRegistroConUsuarioValido()
    {
    	Assert.assertTrue(organizacion.registrarse("user0528", "ole8712mo", usuarioComun));
    }

 */
}
