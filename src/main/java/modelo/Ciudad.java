package modelo;

public class Ciudad {
    String id;
    String nombre;

    public Ciudad(String name, String id) {
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
