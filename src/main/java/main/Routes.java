package main;

import controllers.ComprasController;
import controllers.HomeController;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor");

        Spark.port(8080);
        Spark.staticFileLocation("/public");

//        new Bootstrap().run();

        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        ComprasController egresosController = new ComprasController();
        HomeController homeController = new HomeController();
//        UsuariosController usuariosController = new UsuariosController();

//
        Spark.get("/home", (request, response) -> homeController.getHome(), engine);
        Spark.get("/", (request,response) -> { return new ModelAndView(null,"login.html.hbs");} , engine);
        Spark.get("/egresos/nuevo",  egresosController::getFormularioCreacion, engine);
        Spark.post("/egresos", (request, response) -> egresosController.crearEgreso(request, response));


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
