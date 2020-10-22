package modelo;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.DocumentoComercial.Factura;
import modelo.Egreso.Compras;
import modelo.Egreso.Item;
import modelo.Egreso.ItemsDeLaCompra;
import modelo.Egreso.MedioDePagoDeLaCompra;
import modelo.MedioDePago.MedioDePago;
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
    public Factura factura;
    public Proveedor ofimatica;
    public ItemsDeLaCompra resma50Pesos;
    public TarjetaDeCredito tarjetaDeCredito;
    public MedioDePagoDeLaCompra medioDePagoDeLaCompra;
    public Organizacion geSoc;
    public CategoriaEntidad unaCategoria;
    public DireccionPostal direccionPostalMozart;
    public EntidadBase laComercial;
    public EntidadJuridica mercadoBarrial;

    @Before
    public void init(){
        geSoc = new Organizacion();
        Pais argentina = new Pais("Argentina", "Pesos", "1", "Es-ar");
        Moneda pesoArgentino = new Moneda("PesoArgentino");
        direccionPostalMozart = new DireccionPostal(argentina,"mozart","215","1");
        ofimatica = new Proveedor("Ofimatica","25858568585",direccionPostalMozart);

        tarjetaDeCredito = new TarjetaDeCredito(5875);
        Item resma = new Item("resma papel A4");
        resma50Pesos = new ItemsDeLaCompra(resma,50.0);

        unaCategoria = new CategoriaEntidad(2585);
        laComercial = new EntidadBase("La Comercial","Venta de Ropas",unaCategoria);
        geSoc.addEntidadBase(laComercial);
        compraSemanal = new Compras(LocalDate.now(), ofimatica,pesoArgentino,laComercial);

        medioDePagoDeLaCompra = new MedioDePagoDeLaCompra(tarjetaDeCredito,10.0);
        compraSemanal.addMediosDePago(medioDePagoDeLaCompra);

        compraSemanal.agregarItem(resma50Pesos);

        repositorioCompras = new RepositorioCompras();
        repositorioCompras.agregarCompra(compraSemanal);

        factura = new Factura(258,"C");

        mercadoBarrial = new EntidadJuridica("SupermercadoDelBarrio",
                "LaBarrial","20148523697",direccionPostalMozart);
    }

    @Test
    public void registroDeLasOperacionesDeEgresos(){
        //    Se debe llevar registro de todas las operaciones de egresos de fondos a través de diversos medios de pagos.
        Set<Compras> variasCompras = new HashSet<>();
        variasCompras.add(compraSemanal);
        Assert.assertEquals(repositorioCompras.listadoDeCompras(),variasCompras);
    }

    @Test
    public void compraTieneDocumentoComercial(){
        //Requerimiento 1
        compraSemanal.setDocumentoComercial(factura);
        Assert.assertEquals(compraSemanal.getDocumentoComercial(),factura);
    }

    @Test
    public void compraSinDocumentoComercial(){
        //Requerimiento 1
        Assert.assertEquals(compraSemanal.getDocumentoComercial(),null);
    }

    @Test
    public void conocerElProveedorDeUnaOperacionDeEgreso(){
        //Requerimiento 3
        Assert.assertEquals(compraSemanal.getProveedor(),ofimatica);
    }

    @Test
    public void conocerDetalleDeLosItemsDelEgreso(){
        //Requerimiento 4
        Set<ItemsDeLaCompra> itemsComprados = new HashSet<>();

        Item toner = new Item("Toner Impresora");
        ItemsDeLaCompra toner150 = new ItemsDeLaCompra(toner,150.0);
        itemsComprados.add(toner150);
        itemsComprados.add(resma50Pesos);

        compraSemanal.agregarItem(toner150);
        Assert.assertEquals(compraSemanal.getItems(),itemsComprados);

    }


    @Test
    public void llevarRegistroMedioDePago(){
        //5.- De los medios de pago se debe registrar el medio en sí mismo y algún dato que permita identificar el instrumento
        // utilizado (por ejemplo, si es una tarjeta de débito, su número ; si es un cheque, su número; etc.)
        Set<MedioDePago> medioDePago = new HashSet<>();
        medioDePago.add(tarjetaDeCredito);
        Assert.assertEquals(compraSemanal.getMediosDePago(),medioDePago);
    }

    @Test
    public void organizacionManejaEntidadBase(){
        //Req 7
        Assert.assertTrue( geSoc.tieneEntidadBase()  );
    }

    @Test
    public void organizacionManejaEntidadJuridica(){
        //Req 7

        EntidadJuridica mercadoBarrial = new EntidadJuridica("SupermercadoDelBarrio",
                "LaBarrial","20148523697",direccionPostalMozart);
        geSoc.addEntidadJuridica(mercadoBarrial);
        Assert.assertTrue( geSoc.tieneEntidadJuridica()  );
    }

    @Test
    public void organizacionManejaEntidadJuridicaYEntidadBase(){
        //Req 7
        geSoc.addEntidadJuridica(mercadoBarrial);
        Assert.assertTrue( geSoc.tieneEntidadJuridica() && geSoc.tieneEntidadBase()  );
    }


    @Test(expected=EntidadException.class)
    public void unaEntidadBasePuedePertenecerASoloUnaEntidadJuridica(){
//       10.- Una entidad base puede pertenecer a sólo una entidad jurídica

        EntidadJuridica zapatillasTigre = new EntidadJuridica("Tigre","Fabrica de zapatillas",
                "15585855811",direccionPostalMozart);

        mercadoBarrial.addEntidadBase(laComercial);
        mercadoBarrial.addEntidadBase(laComercial);
    }

    @Test
    public void categorizarEntidadJuridica(){
//       13.- Las entidades jurídicas serán categorizadas en Empresas y OSC (Organizaciones del sector social).
        CategoriaEntidadJuridicaEmpresa empresa = new CategoriaEntidadJuridicaEmpresa();
        mercadoBarrial.setCategoriaEntidadJuridica(empresa);
        Assert.assertEquals(mercadoBarrial.getCategorizacionEntiodadJuridica(),
                empresa);
    }

    @Test
    public void lasEmpresasConMenosDe5EmpleadosTienenClasificacionAFIP_MICRO(){
//      14.-  En el caso de empresas, estas se clasifican en Micro, Pequeña, Mediana Tramo 1, Mediana Tramo 2. Dicha clasificación responderá a los criterios estipulados por la AFIP
      //  mercadoBarrial.
        mercadoBarrial.setCantidadEmpleados(1);
        CategoriaEntidadJuridicaEmpresa empresa = new CategoriaEntidadJuridicaEmpresa();
        mercadoBarrial.setCategoriaEntidadJuridica(empresa);

        Assert.assertEquals(mercadoBarrial.getClasificacionAFIP(),ClasificacionAFIP.MICRO);
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
