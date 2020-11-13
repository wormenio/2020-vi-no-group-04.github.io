package modelo;

import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.CategoriaJuridica.CategoriaEntidadJuridicaEmpresa;
import modelo.CategoriaJuridica.ClasificacionAFIP;
import modelo.DireccionPostal.DireccionPostal;
import modelo.Entidades.EntidadBase;
import modelo.Entidades.EntidadException;
import modelo.Entidades.EntidadJuridica;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntidad {
    public TestHelpers testHelpers;
    public EntidadJuridica entidadJuridica;
    public EntidadBase entidadBase;
    public Organizacion geSoc;
    public CategoriaEntidadJuridicaEmpresa empresa;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
        geSoc = testHelpers.geSoc;
        empresa = new CategoriaEntidadJuridicaEmpresa();

//        entidadJuridicarZapatillasTigre = testHelpers.entidadJuridicaZapatillasTigre();

        entidadJuridica = new BuilderEntidad()
                .setRazonSocial("Mercado Barrial SRL")
                .setNombreFicticio("Mercadito del barrio")
                .setCuit("25858568585")
                .setDireccionPostal(new DireccionPostal())
                .setCategoriaEntidadJuridica(empresa)
                .crearEntidadJuridica();


        entidadBase = new BuilderEntidad()
                .setNombreFicticio("La comercial")
                .setDescripcion("Venta de insumos varios")
                .setCategoriaEntidad( new CategoriaEntidad())
                .crearEntidadBase();
    }

    @Test
    public void organizacionManejaEntidadBase(){
        //Req 7
        Assert.assertTrue( geSoc.tieneEntidadBase()  );
    }

    @Test
    public void organizacionManejaEntidadJuridica(){
        //Req 7
        Assert.assertTrue( geSoc.tieneEntidadJuridica()  );
    }

    @Test
    public void organizacionManejaEntidadJuridicaYEntidadBase(){
        //Req 7
        Assert.assertTrue( geSoc.tieneEntidadJuridica() && geSoc.tieneEntidadBase()  );
    }


    @Test(expected= EntidadException.class)
    public void unaEntidadBasePuedePertenecerASoloUnaEntidadJuridica(){
//       10.- Una entidad base puede pertenecer a sólo una entidad jurídica

        entidadJuridica.agregarEntidadBase(entidadBase);
        EntidadJuridica otraEntidadJuridica = new BuilderEntidad()
                .setRazonSocial("Ferreteria industrial SRL")
                .setNombreFicticio("La industrial")
                .setCuit("25854875585")
                .setDireccionPostal(new DireccionPostal())
                .setCategoriaEntidadJuridica(empresa)
                .crearEntidadJuridica();

        otraEntidadJuridica.agregarEntidadBase(entidadBase);
    }

    @Test
    public void categorizarEntidadJuridica(){
//       13.- Las entidades jurídicas serán categorizadas en Empresas y OSC (Organizaciones del sector social).

        Assert.assertEquals(entidadJuridica.getCategorizacionEntiodadJuridica(),
                empresa);
    }

    @Test
    public void lasEmpresasConMenosDe5EmpleadosTienenClasificacionAFIP_MICRO(){
//      14.-  En el caso de empresas, estas se clasifican en Micro, Pequeña, Mediana Tramo 1, Mediana Tramo 2. Dicha clasificación responderá a los criterios estipulados por la AFIP
        //  mercadoBarrial.

        entidadJuridica.setCantidadEmpleados(1);

        Assert.assertEquals(entidadJuridica.getClasificacionAFIP(), ClasificacionAFIP.MICRO);
    }
}
