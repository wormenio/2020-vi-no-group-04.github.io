package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.DocumentoComercial.DocumentoComercial;
import modelo.DocumentoComercial.Factura;
import modelo.DocumentoComercial.Remito;
import modelo.Egreso.*;
import modelo.MedioDePago.MedioDePago;
import modelo.MedioDePago.TarjetaDeCredito;

import java.time.LocalDate;

public class TestHelpers {
    public Organizacion geSoc = new Organizacion("Gesoc");
    public Moneda pesoArgentino = new Moneda("Peso Argentino");
    public Factura factura258 =  new Factura(258,"C");
    public Remito remito2     =  new Remito(2);
    public Item itemResma = new Item("resma papel A4");
    public Item itemTonerImpresora = new Item("Toner Impresora Laser HP");
    public Item itemCuaderno = new Item("Cuaderno Rayado 80 hojas");
    public MedioDePago tarjetaCredito5875 = new TarjetaDeCredito(5875);
    public EntidadBase entidadBaseLaComercial = entidadBaseLaComercial();
    public Proveedor proveedorOfimatica = proveedorOfimatica();

    private EntidadBase entidadBaseLaComercial(){
        return new EntidadBase("La Comercial","Venta de Ropas",new CategoriaEntidad(2585));
    }

    public EntidadJuridica entidadJuridicaMercadoBarrial(){
        return new EntidadJuridica("SupermercadoDelBarrio",
                "LaBarrial","20148523697",direccionPostalMozart());
    }

    public EntidadJuridica entidadJuridicaZapatillasTigre(){
        return new EntidadJuridica("Tigre","Fabrica de zapatillas",
                "15585855811",direccionPostalMozart());
    }


    public DireccionPostal direccionPostalMozart(){
        Pais argentina = new Pais("Argentina", "Pesos", "1", "Es-ar");
        return new DireccionPostal(argentina,"mozart","215","1");
    }


    public DocumentoComercial remitoNro1(){
        return new Remito(1);
    }

    private Proveedor proveedorOfimatica(){
        return  new Proveedor("Juan",
                            "Perez",
                            "Ofimatica",
                            "25858685",
                            "25858568585",
                            direccionPostalMozart(),
                            "1",
                "1");
    }

    public CompraSinPresupuesto laComercialRealizaCompraAOfimatica(LocalDate fecha){
        CompraSinPresupuesto unaCompra = new CompraSinPresupuesto(
                fecha,
                proveedorOfimatica,
                pesoArgentino,
                entidadBaseLaComercial
        );
        return unaCompra;
    }

    public CompraSinPresupuesto laComercialCompraResmaYTonerAOfimatica(LocalDate fecha){
        CompraSinPresupuesto compra = laComercialRealizaCompraAOfimatica(fecha);
        compra.agregarItem(itemResma,250.00);
        compra.agregarItem(itemTonerImpresora,750.0);
        return compra;
    }

    public CompraSinPresupuesto laComercialCompraDeCuadernosAOfimatica(LocalDate fecha){
        CompraSinPresupuesto compra = laComercialRealizaCompraAOfimatica(fecha);
        compra.agregarItem(itemCuaderno,150.00);
        return compra;
    }


}
