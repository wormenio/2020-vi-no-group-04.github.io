package entities.usuario;

import entities.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name="Usuarios")
public class UsuarioEntity extends EntidadPersistente {

    private String usuario;
    private String apellido;
    private String hash;
    @Column(name = "is_admin")
    private Boolean isAdmin;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setIsAdmin(Boolean is_admin) {
        this.isAdmin = is_admin;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

}