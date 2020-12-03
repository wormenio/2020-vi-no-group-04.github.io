package controllers;

import modelo.*;
import modelo.Egreso.Compra;
import modelo.Egreso.EtiquetaEgreso;
import modelo.Entidades.Entidad;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComprasController implements WithGlobalEntityManager, TransactionalOps {

    public ModelAndView getCompras(Request request, Response response) {
        String nombreBuscado = request.queryParams("filtro");
        Map<String, Object> modelo = new HashMap<>();

        List<Compra> compras =
                nombreBuscado != null ?
                        RepositorioCompras.instance().buscarPorNombre(nombreBuscado) :
                        RepositorioCompras.instance().listadoDeCompras();

        modelo.put("compras", compras);

        return new ModelAndView(modelo, "compras.html.hbs");
    }

    public ModelAndView getFormularioDocumentoComercial(Request request, Response response ){
        String id = request.params(":id");
        Map<String, Object> modelo = new HashMap<>();
        Compra compra = RepositorioCompras.instance().getById(Long.parseLong(id));
        return new ModelAndView(compra, "egreso/newDocumentoEgreso.html.hbs");
    }

    public ModelAndView getFormularioProducto(Request request, Response response ){
        String id = request.params(":id");
        Map<String, Object> modelo = new HashMap<>();
        Compra compra = RepositorioCompras.instance().getById(Long.parseLong(id));
        return new ModelAndView(compra, "egreso/newProductoEgreso.html.hbs");
    }

    public ModelAndView getFormularioPresupuesto(Request request, Response response ){
        String id = request.params(":id");
        Map<String, Object> modelo = new HashMap<>();
        Compra compra = RepositorioCompras.instance().getById(Long.parseLong(id));
        return new ModelAndView(compra, "egreso/newDocumentoEgreso.html.hbs");
    }

    public ModelAndView getFormularioCreacion(Request request, Response response) {
      /*  if(!estaLogueado(request, response)){
            response.redirect("/login");
        }
*/
        Map<String, Object> modelo = new HashMap<>();

        List<Proveedor> proveedores = RepositorioProveedor.instance().listadoDeProveedores();
        List<EtiquetaEgreso> etiquetasEgresos = RepositorioEtiquetaEgreso.instance().listadoRegistros();
        List<Moneda> monedas        = RepositorioMonedas.instance().listadoDeRegistros();
        List<Entidad> entidades     = RepositorioEntidades.instance().listadoDeRegistros();

        modelo.put("proveedores", proveedores);
        modelo.put("etiquetasEgresos", etiquetasEgresos);
        modelo.put("monedas", monedas);
        modelo.put("entidades", entidades);

        return new ModelAndView(modelo, "egreso/newCompra.html.hbs");
    }

    public Void crearEgreso(Request request, Response response) {

/*

        Usuario usuario = getUsuarioLogueado(request);

        if(usuario != null){
            response.redirect("/login");
        }
*/


        Proveedor proveedor = RepositorioProveedor.instance().getById(Long.valueOf(request.queryParams("proveedor")));

        EtiquetaEgreso etiquetaEgreso = RepositorioEtiquetaEgreso.instance().getById(Long.valueOf(request.queryParams("etiqueta")));

        Moneda moneda = RepositorioMonedas.instance().getById(Long.valueOf(request.queryParams("moneda")));

        Entidad entidad = RepositorioEntidades.instance().getById(Long.parseLong(request.queryParams("moneda")));

        LocalDate fechaCompra = LocalDate.parse(request.queryParams("fechaCompra"),
                DateTimeFormatter.ofPattern("yyyy-MM-d"));

        Compra compra = new Compra(fechaCompra,proveedor,moneda,entidad,etiquetaEgreso);

        withTransaction(() ->{
            RepositorioCompras.instance().agregar(compra);
//            usuario.agregarConsultora(nueva);
        });

        response.redirect("/compras/" + compra.getId());
        return null;
    }

    public Object getDetalleCompra(Request request, Response response, TemplateEngine engine) {

        String id = request.params(":id");
        try{
            Compra compra = RepositorioCompras.instance().getById(Long.parseLong(id));
            return compra != null ?
                    engine.render(new ModelAndView(compra, "egreso/detalleCompra.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("El id ingresado (" + id +") no es un número");
            return "Bad Request";
        }
    }



}
