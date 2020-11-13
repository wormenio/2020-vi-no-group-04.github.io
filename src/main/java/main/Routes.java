package main;

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
        EgresosController egresosController = new EgresosController();
        HomeController homeController = new HomeController();
//        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/", (request, response) -> homeController.getHome(), engine);
        
        Spark.get("/consultoras",(request, response) ->egresosController.getEgresos(), engine);

//
//        Spark.get("/", (request, response) -> homeController.getHome(), engine);
       /* Spark.get("/", (request,response) -> {
        	return new ModelAndView(null,"login.html.hbs");
        	} , engine);*/

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
