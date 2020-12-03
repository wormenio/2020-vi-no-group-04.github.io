package controllers;

import modelo.*;
import modelo.CategoriaJuridica.CategoriaEntidadJuridica;
import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.DireccionPostal.DireccionPostal;
import modelo.Egreso.Compra;
import modelo.Egreso.EtiquetaEgreso;
import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadBase;
import modelo.Entidades.EntidadJuridica;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntidadesController implements WithGlobalEntityManager, TransactionalOps {

    private CategoriaEntidadJuridica categoriaJuridica;
    private CategoriaEntidad categoriaEntidad;
    private DireccionPostal direccionPostal;
    private Entidad entidadJuridica;
    private Entidad entidadBase;

    public ModelAndView getEntidades(Request request, Response response) {
        String nombreBuscado = request.queryParams("filtro");

        Map<String, Object> modelo = new HashMap<>();

        List<Entidad> entidades =
                nombreBuscado != null ?
                        RepositorioEntidades.instance().buscarPorNombre(nombreBuscado) :
                        RepositorioEntidades.instance().listadoDeRegistros();

        modelo.put("compras", entidades);

        return new ModelAndView(modelo, "entidad/entidades.html.hbs");

    }

    public Object getDetalleEntidadBase(Request request, Response response, TemplateEngine engine) {
        String id = request.params(":id") ;
        try{
            entidadBase = RepositorioEntidades.instance().getById(Long.parseLong(id));

            return entidadBase != null ?
                    engine.render(new ModelAndView(entidadBase, "entidad/detalleEntidadBase.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("El id ingresado (" + id +") no es un número");
            return "Bad Request";
        }
    }

    public Object getDetalleEntidadJuridica(Request request, Response response, TemplateEngine engine) {
        String id = request.params(":id") ;
        try{
            entidadJuridica = RepositorioEntidades.instance().getById(Long.parseLong(id));

            return entidadJuridica != null ?
                    engine.render(new ModelAndView(entidadJuridica, "entidad/detalleEntidadJuridica.html.hbs"))
                    : null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("El id ingresado (" + id +") no es un número");
            return "Bad Request";
        }
    }

    public ModelAndView getFormularioCreacionEntidadBase(Request request, Response response) {
      /*  if(!estaLogueado(request, response)){
            response.redirect("/login");
        }
*/
        Map<String, Object> modelo = new HashMap<>();
        List<CategoriaEntidad> categoriasEntidades = RepositorioCategoriasEntidades
                .instance()
                .listadoDeRegistros();
        modelo.put("categoriasEntidades",categoriasEntidades);
        return new ModelAndView(modelo, "entidad/newEntidadBase.html.hbs");
    }

    public ModelAndView getFormularioCreacionEntidadJuridica(Request request, Response response) {
      /*  if(!estaLogueado(request, response)){
            response.redirect("/login");
        }
*/
        Map<String, Object> modelo = new HashMap<>();

        List<CategoriaEntidadJuridica> categoriasJuridicas = RepositorioCategoriasJuridicas
                .instance()
                .listadoDeRegistros();

        List<DireccionPostal> direccionesPostales = RepositorioDireccionesPostales
                .instance()
                .listadoDeRegistros();

        List<CategoriaEntidad> categoriasEntidades = RepositorioCategoriasEntidades
                .instance()
                .listadoDeRegistros();

        modelo.put("categoriasJuridicas", categoriasJuridicas);
        modelo.put("direccionesPostales", direccionesPostales);
        modelo.put("categoriasEntidades", categoriasEntidades);
        return new ModelAndView(modelo, "entidad/newEntidadJuridica.html.hbs");
    }


    public Void crearEntidadBase(Request request, Response response) {

/*
        Usuario usuario = getUsuarioLogueado(request);
        if(usuario != null){
            response.redirect("/login");
        }
*/
        try {
            categoriaEntidad = RepositorioCategoriasEntidades.instance()
                    .getById(Long.valueOf(request.queryParams("categoriaEntidad")));

            EntidadBase entidadBase = new EntidadBase(request.queryParams("nombreFicticio"),
                    request.queryParams("descripcion"), categoriaEntidad);

            withTransaction(() ->{
                RepositorioEntidades.instance().agregar(entidadBase);
            });
            response.redirect("/entidades/entidadesBase/" + entidadBase.getId());
            return null;

        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("error "+e.getMessage());
            return null;
        }



    }

    public Void crearEntidadJuridica(Request request, Response response) {

/*
        Usuario usuario = getUsuarioLogueado(request);
        if(usuario != null){
            response.redirect("/login");
        }
*/
        try{
            categoriaJuridica = RepositorioCategoriasJuridicas.instance()
                    .getById(Long.valueOf(request.queryParams("categoriaJuridica")));
            categoriaEntidad = RepositorioCategoriasEntidades.instance()
                    .getById(Long.valueOf(request.queryParams("categoriaEntidad")));
            direccionPostal = RepositorioDireccionesPostales.instance()
                    .getById(Long.valueOf(request.queryParams("direccionPostal")));
            Long codigoIgj = request.queryParams("razonSicial")!=null ?
                    Long.valueOf(request.queryParams("codigoIgj")) : null;

            EntidadJuridica entidadJuridica = new EntidadJuridica(request.queryParams("razonSocial"),
                    request.queryParams("nombreFicticio"),
                    request.queryParams("cuit"),codigoIgj,
                    Integer.valueOf(request.queryParams("cantidadEmpleados")),categoriaJuridica,
                    categoriaEntidad,direccionPostal);
            withTransaction(() ->{
                RepositorioEntidades.instance().agregar(entidadJuridica);
            });

            response.redirect("/entidades/entidadesJuridicas/" + entidadJuridica.getId());
            return null;
        } catch(NumberFormatException e){
            response.status(400);
            System.out.println("error "+e.getMessage());
            return null;
        }

    }


}
