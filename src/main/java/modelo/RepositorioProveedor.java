package modelo;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioProveedor implements WithGlobalEntityManager {

    private static RepositorioProveedor instance = new RepositorioProveedor();
    public static RepositorioProveedor instance(){
        return instance;
    }

    public Proveedor getById(Long id){
        return entityManager().find(Proveedor.class, id);

    }

    public List<Proveedor> listadoDeProveedores(){
        return entityManager()//
                .createQuery("from Proveedor ", Proveedor.class) //
                .getResultList();
    }
}
