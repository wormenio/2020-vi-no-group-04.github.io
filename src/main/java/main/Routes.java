package main;

import controllers.*;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor");

        Spark.port(8080);
        Spark.staticFileLocation("/public");

        //new Bootstrap().run();

        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        ComprasController comprasController = new ComprasController();
        HomeController homeController = new HomeController();
        LoginController loginController = new LoginController();
        EntidadesController entidadesController = new EntidadesController();

//        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/", (request, response) -> { return new ModelAndView(null,"login.html.hbs");}, engine);
        Spark.get("/", (request, response) -> loginController.validarUsuario(request, response), engine);

        Spark.get("/inicio", (request,response) -> { return new ModelAndView(null,"inicio.html.hbs");} , engine);


        Spark.get("/home", (request, response) -> homeController.getHome(), engine);
        Spark.get("/login", (request,response) -> { return new ModelAndView(null,"login.html.hbs");} , engine);

        Spark.get("/compras", comprasController::getCompras, engine);
        Spark.get("/compras/nuevo",  comprasController::getFormularioCreacion, engine);
        Spark.get("/compras/:id", (request, response) -> comprasController.getDetalleCompra(request, response, engine));
        Spark.get("/compras/:id/documentoComercial/nuevo", comprasController::getFormularioDocumentoComercial, engine);
        Spark.get("/compras/:id/producto/nuevo", comprasController::getFormularioProducto, engine);
        Spark.get("/compras/:id/presupuesto/nuevo", comprasController::getFormularioPresupuesto, engine);
        Spark.get("/compras/:id/usuarioRevisor/nuevo", comprasController::getFormularioUsuario, engine);

        Spark.post("/compras", (request, response) -> comprasController.crearEgreso(request, response));
        Spark.post("/compras/:id/documentoComercial", (request, response) -> comprasController.crearDocumentoDelEgreso(request, response));
        Spark.post("/compras/:id/producto", (request, response) -> comprasController.crearProductoDelEgreso(request, response));
        Spark.post("/compras/:id/presupuesto", (request, response) -> comprasController.crearPresupuesoDelEgreso(request, response));
        Spark.post("/compras/:id/usuarioRevisor", (request, response) -> comprasController.crearUsuarioRevisorDelEgreso(request, response));

        /************       ENTIDADES    ************/

//        Nuevas entidades
        Spark.get("entidades/entidadesBase/nuevo",  entidadesController::getFormularioCreacionEntidadBase, engine);
        Spark.get("entidades/entidadesJuridicas/nuevo",  entidadesController::getFormularioCreacionEntidadJuridica, engine);


//        Listado entidades
        Spark.get("/entidades", entidadesController::getEntidades, engine);

//        Detalle entidades
        Spark.get("/entidades/entidadesBase/:id", (request, response) -> entidadesController.getDetalleEntidadBase(request, response, engine));
        Spark.get("/entidades/entidadesJuridicas/:id", (request, response) -> entidadesController.getDetalleEntidadJuridica(request, response, engine));

//        Nuevas entidades
        Spark.post("entidades/entidadesBase", (request, response) -> entidadesController.crearEntidadBase(request, response));
        Spark.post("entidades/entidadesJuridicas", (request, response) -> entidadesController.crearEntidadJuridica(request, response));

    }
}
