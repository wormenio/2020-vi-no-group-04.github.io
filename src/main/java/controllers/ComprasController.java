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

    public ModelAndView getFormularioCreacion(Request request, Response response) {
      /*  if(!estaLogueado(request, response)){
            response.redirect("/login");
        }
*/
        return new ModelAndView(null, "newCompra.html.hbs");
    }

    public Void crearEgreso(Request request, Response response) {

/*

        Usuario usuario = getUsuarioLogueado(request);

        if(usuario != null){
            response.redirect("/login");
        }
*/

        RepositorioProveedor repositorioProveedores = new RepositorioProveedor();
        Proveedor proveedor = repositorioProveedores.getById(Long.valueOf(request.queryParams("proveedor")));

        RepositorioEtiquetaEgreso repositorioEtiquetaEgreso = new RepositorioEtiquetaEgreso();
        EtiquetaEgreso etiquetaEgreso = repositorioEtiquetaEgreso.getById(Long.valueOf(request.queryParams("etiqueta")));

        RepositorioMonedas repositorioMonedas = new RepositorioMonedas();
        Moneda moneda = repositorioMonedas.getById(Long.valueOf(request.queryParams("moneda")));

        RepositorioEntidades repositorioEntidades = new RepositorioEntidades();
        Entidad entidad = repositorioEntidades.getById(Long.parseLong(request.queryParams("moneda")));

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
                    engine.render(new ModelAndView(compra, "detalleCompra.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("El id ingresado (" + id +") no es un número");
            return "Bad Request";
        }
    }

}
