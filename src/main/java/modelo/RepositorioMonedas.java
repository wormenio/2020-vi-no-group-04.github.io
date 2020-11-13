package modelo;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;


public class RepositorioMonedas implements WithGlobalEntityManager {
	 private static RepositorioMonedas instance = new RepositorioMonedas();
	    public static RepositorioMonedas instance(){
	        return instance;
	    }
	
	public Moneda getById(Long id){
        return entityManager().find(Moneda.class, id);

    }
}
