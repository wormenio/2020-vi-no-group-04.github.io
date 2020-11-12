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
    public Organizacion geSoc = new Organizacion();
/*
    public Moneda pesoArgentino = new Moneda();
    public Factura factura258 =  new Factura(258,"C");
    public Remito remito2     =  new Remito(2);
    public Item itemResma = new Item("resma papel A4");
    public Item itemTonerImpresora = new Item();
    public Item itemCuaderno = new Item();
    public MedioDePago tarjetaCredito5875 = new TarjetaDeCredito();*/
//    public Entidad entidadBaseLaComercial = entidadBaseLaComercial();
//    public Proveedor proveedorOfimatica = Proveedor();
//
//    private EntidadBase entidadBaseLaComercial(){
//        return new EntidadBase("La Comercial","Venta de Ropas",
//                new CategoriaEntidad("La Comercial"),geSoc);
//    }


/*

    public EntidadJuridica entidadJuridicaMercadoBarrial(){
        return new EntidadJuridica("SupermercadoDelBarrio",
                "LaBarrial","20148523697",
                direccionPostalMozart(),
                new CategoriaEntidadJuridicaOSC(),
                geSoc);
    }

    public EntidadJuridica entidadJuridicaZapatillasTigre(){
        return new EntidadJuridica("Tigre","Fabrica de zapatillas",
                "15585855811",direccionPostalMozart(),
                new CategoriaEntidadJuridicaEmpresa(),
                geSoc);
    }


    public DireccionPostal direccionPostalMozart(){
        Pais argentina = new Pais("Argentina", "ARS", "AR", "es_AR");
        Provincia capital_federal = new Provincia("Capital Federal","TUxBQ0NBUGZlZG1sYQ");
        Ciudad villa_luro = new Ciudad("Villa Luro", "TUxBQlZJTDI3MDJa");
        return new DireccionPostal(argentina, capital_federal, villa_luro, "mozart",215,"1", "D");
    }
*/


    public DocumentoComercial remitoNro1(){
        return new Remito();
    }
/*

    private Proveedor proveedorOfimatica(){
        return  new Proveedor("Juan",
                            "Perez",
                            "Ofimatica",
                            "25858685",
                            "25858568585",
                            direccionPostalMozart()
                            );
    }

    public CompraSinPresupuesto laComercialRealizaCompraAOfimatica(LocalDate fecha){
        CompraSinPresupuesto unaCompra = new CompraSinPresupuesto(
                fecha,
                proveedorOfimatica,
                pesoArgentino,
                entidadBaseLaComercial,
                new EtiquetaEgreso("Utiles")
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
*/


}
