package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntidad {
    public TestHelpers testHelpers;
    public EntidadJuridica entidadJuridicaMercadoBarrial;
    public EntidadJuridica entidadJuridicarZapatillasTigre;
    public EntidadBase  entidadBaseLaComercial;
    public Organizacion geSoc;
    public CategoriaEntidadJuridicaEmpresa empresa;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
        geSoc = testHelpers.geSoc;
        empresa = new CategoriaEntidadJuridicaEmpresa();

        entidadJuridicarZapatillasTigre = testHelpers.entidadJuridicaZapatillasTigre();

        entidadJuridicaMercadoBarrial = new BuilderEntidad()
                .setRazonSocial("Mercado Barrial SRL")
                .setNombreFicticio("Mercadito del barrio")
                .setCuit("25858568585")
                .setDireccionPostal(testHelpers.direccionPostalMozart())
                .setCategoriaEntidadJuridica(empresa)
                .crearEntidadJuridica();

        entidadBaseLaComercial = new BuilderEntidad()
                .setNombreFicticio("La comercial")
                .setDescripcion("Venta de insumos varios")
                .setCategoriaEntidad( new CategoriaEntidad("La Comercial"))
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


    @Test(expected=EntidadException.class)
    public void unaEntidadBasePuedePertenecerASoloUnaEntidadJuridica(){
//       10.- Una entidad base puede pertenecer a sólo una entidad jurídica

        entidadJuridicaMercadoBarrial.addEntidadBase(entidadBaseLaComercial);
        entidadJuridicarZapatillasTigre.addEntidadBase(entidadBaseLaComercial);
    }

    @Test
    public void categorizarEntidadJuridica(){
//       13.- Las entidades jurídicas serán categorizadas en Empresas y OSC (Organizaciones del sector social).

        Assert.assertEquals(entidadJuridicaMercadoBarrial.getCategorizacionEntiodadJuridica(),
                empresa);
    }

    @Test
    public void lasEmpresasConMenosDe5EmpleadosTienenClasificacionAFIP_MICRO(){
//      14.-  En el caso de empresas, estas se clasifican en Micro, Pequeña, Mediana Tramo 1, Mediana Tramo 2. Dicha clasificación responderá a los criterios estipulados por la AFIP
        //  mercadoBarrial.

        entidadJuridicaMercadoBarrial.setCantidadEmpleados(1);

        Assert.assertEquals(entidadJuridicaMercadoBarrial.getClasificacionAFIP(),ClasificacionAFIP.MICRO);
    }
}
