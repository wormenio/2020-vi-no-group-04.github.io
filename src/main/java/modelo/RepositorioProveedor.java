package modelo;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioProveedor implements WithGlobalEntityManager {

    private static RepositorioProveedor instance = new RepositorioProveedor();
    public static RepositorioProveedor instance(){
        return instance;
    }

    public Proveedor getById(Long id){
        return entityManager().find(Proveedor.class, id);

    }
}
