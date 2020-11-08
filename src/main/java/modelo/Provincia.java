package modelo;

public class Provincia {
    String id;
    String nombre;

    public Provincia(String name, String id) {
        this.id = id;
        this.nombre = name;
    }
    public  String verNombre() {
        return nombre;
    }
    public  String verID() {
        return id;
    }
}
