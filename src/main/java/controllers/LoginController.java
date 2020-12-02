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

public class LoginController implements WithGlobalEntityManager, TransactionalOps {
	
	public ModelAndView validarUsuario(Request request, Response response) {
		String usuario = request.queryParams("userName");
		String password = request.queryParams("password");

		 RepositorioUsuarios.instance().validarUsuario(usuario,password);
		return null;
		
	}

}
