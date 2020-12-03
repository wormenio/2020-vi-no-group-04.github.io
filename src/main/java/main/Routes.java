package main;

import controllers.ComprasController;
import controllers.EgresosController;
import controllers.HomeController;
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
//        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/", (request, response) -> homeController.getHome(), engine);
        Spark.get("/inicio", (request,response) -> { return new ModelAndView(null,"inicio.html.hbs");} , engine);


        Spark.get("/home", (request, response) -> homeController.getHome(), engine);
        Spark.get("/login", (request,response) -> { return new ModelAndView(null,"login.html.hbs");} , engine);
        Spark.get("/compras", comprasController::getCompras, engine);
        Spark.get("/compras/nuevo",  comprasController::getFormularioCreacion, engine);
        Spark.get("/compras/:id", (request, response) -> comprasController.getDetalleCompra(request, response, engine));
        Spark.get("/compras/:id/documentoComercial/nuevo", comprasController::getFormularioDocumentoComercial, engine);
        Spark.get("/compras/:id/producto/nuevo", comprasController::getFormularioProducto, engine);
        Spark.get("/compras/:id/presupuesto/nuevo", comprasController::getFormularioPresupuesto, engine);
        Spark.post("/compras", (request, response) -> comprasController.crearEgreso(request, response));


//
//        Spark.get("/consultoras", consultorasController::getConsultoras, engine);
//
//        Spark.get("/consultoras/nueva", consultorasController::getFormularioCreacion,engine);
//
//        Spark.get("/consultoras/:id", (request, response) -> consultorasController.getDetalleConsultora(request, response, engine));
//
//        Spark.post("/consultoras", (request, response) -> consultorasController.crearConsultora(request, response));
//
//        Spark.get("/login", (request, response) -> usuariosController.getFormularioLogin(request, response), engine);
//
//        Spark.post("/login", (request, response) -> usuariosController.iniciarSesion(request, response));

    }
}
