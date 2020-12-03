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

import javax.swing.JOptionPane;

public class LoginController implements WithGlobalEntityManager, TransactionalOps {
	
	public ModelAndView validarUsuario(Request request, Response response) {
		String boton = request.queryParams("button");
		String usuario = request.queryParams("userName");
		String password = request.queryParams("password");
		
		if (boton!=null){
			Usuario usuarioLogueado = RepositorioUsuarios.instance().validarUsuario(usuario,password);
			
			if(usuarioLogueado==null) {
				JOptionPane.showMessageDialog(null, "Hello World");
				return new ModelAndView(null, "login.html.hbs");
			}
			return new ModelAndView(null,"inicio.html.hbs");
		}
		return new ModelAndView(null, "login.html.hbs");

	}
}
