package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;

public class EgresosController implements WithGlobalEntityManager, TransactionalOps {

	public ModelAndView getEgresos() {
        

        return new ModelAndView(null, "NewEgreso.html.hbs");
    }

}
