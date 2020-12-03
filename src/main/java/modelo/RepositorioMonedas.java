package modelo;

import modelo.Egreso.Compra;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;


public class RepositorioMonedas implements WithGlobalEntityManager {
	 private static RepositorioMonedas instance = new RepositorioMonedas();
	    public static RepositorioMonedas instance(){
	        return instance;
	    }
	
	public Moneda getById(Long id){
        return entityManager().find(Moneda.class, id);

    }

	public List<Moneda> listadoDeRegistros(){
		return entityManager()//
				.createQuery("from Moneda ", Moneda.class) //
				.getResultList();
	}

}
