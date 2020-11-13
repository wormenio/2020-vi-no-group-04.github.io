package controllers;

import modelo.Egreso.Compra;
import modelo.Egreso.EtiquetaEgreso;
import modelo.Proveedor;
import modelo.RepositorioCompras;
import modelo.RepositorioPresupuestos;
import modelo.RepositorioProveedor;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class ComprasController implements WithGlobalEntityManager, TransactionalOps {

    public ModelAndView getFormularioEgreso(Request request, Response response) {
        return new ModelAndView(null, "newEgreso.html.hbs");
    }

    public ModelAndView getFormularioCreacion(Request request, Response response) {
      /*  if(!estaLogueado(request, response)){
            response.redirect("/login");
        }
*/
        return new ModelAndView(null, "newEgreso.html.hbs");
    }

    public Void crearEgreso(Request request, Response response) {

/*

        Usuario usuario = getUsuarioLogueado(request);

        if(usuario != null){
            response.redirect("/login");
        }
*/


        String fechaCompra = request.queryParams("fechaCompra"); //Pasar a fecha
        RepositorioProveedor repositorioPresupuestos = new RepositorioProveedor();
        Proveedor proveedor = repositorioPresupuestos.getById(Long.valueOf(request.queryParams("proveedor")));
        EtiquetaEgreso etiquetaEgreso = new EtiquetaEgreso();

        //Crear repositorio de proveedores
        //Buscar el proveedor por id
        //Idem Moneda, repo + busqueda
//        idem Etiqueta


        Integer cantidadEmpleados = Integer.parseInt(request.queryParams("cantEmpleados"));
	/*LocalDate fechaCompra, Proveedor proveedor, Moneda moneda,
	Entidad entidad, EtiquetaEgreso etiquetaEgreso*/
        Compra nueva = new Compra();

        withTransaction(() ->{
//            RepositorioCompras.instancia.agregar(nueva);
//            usuario.agregarConsultora(nueva);
        });

        response.redirect("/egresos/" + nueva.getId());
        return null;
    }

}
