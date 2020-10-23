package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntidad {
    public TestHelpers testHelpers;
    public EntidadJuridica entidadJuridicaMercadoBarrial;
    public EntidadJuridica entidadJuridicarZapatillasTigre;
    public EntidadBase  entidadBaseLaComercial;
    public Organizacion geSoc;

    @Before
    public void init(){
        testHelpers = new TestHelpers();
        geSoc = testHelpers.geSoc;
        entidadJuridicaMercadoBarrial   = testHelpers.entidadJuridicaMercadoBarrial();
        entidadJuridicarZapatillasTigre = testHelpers.entidadJuridicaZapatillasTigre();
        entidadBaseLaComercial          = testHelpers.entidadBaseLaComercial;
    }

    @Test
    public void organizacionManejaEntidadBase(){
        //Req 7
        geSoc.addEntidadBase(entidadBaseLaComercial);
        Assert.assertTrue( geSoc.tieneEntidadBase()  );
    }

    @Test
    public void organizacionManejaEntidadJuridica(){
        //Req 7

        geSoc.addEntidadJuridica(entidadJuridicaMercadoBarrial);
        Assert.assertTrue( geSoc.tieneEntidadJuridica()  );
    }

    @Test
    public void organizacionManejaEntidadJuridicaYEntidadBase(){
        //Req 7
        geSoc.addEntidadJuridica(entidadJuridicaMercadoBarrial);
        geSoc.addEntidadBase(entidadBaseLaComercial);
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

        CategoriaEntidadJuridicaEmpresa empresa = new CategoriaEntidadJuridicaEmpresa();
        entidadJuridicaMercadoBarrial.setCategoriaEntidadJuridica(empresa);

        Assert.assertEquals(entidadJuridicaMercadoBarrial.getCategorizacionEntiodadJuridica(),
                empresa);
    }

    @Test
    public void lasEmpresasConMenosDe5EmpleadosTienenClasificacionAFIP_MICRO(){
//      14.-  En el caso de empresas, estas se clasifican en Micro, Pequeña, Mediana Tramo 1, Mediana Tramo 2. Dicha clasificación responderá a los criterios estipulados por la AFIP
        //  mercadoBarrial.

        entidadJuridicaMercadoBarrial.setCantidadEmpleados(1);
        CategoriaEntidadJuridicaEmpresa empresa = new CategoriaEntidadJuridicaEmpresa();
        entidadJuridicaMercadoBarrial.setCategoriaEntidadJuridica(empresa);

        Assert.assertEquals(entidadJuridicaMercadoBarrial.getClasificacionAFIP(),ClasificacionAFIP.MICRO);
    }
}
