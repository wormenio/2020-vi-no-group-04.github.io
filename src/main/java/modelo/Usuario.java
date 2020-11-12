package modelo;

import modelo.ValidarContrasenia.*;
import modelo.UsuarioException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_admin")
    private Boolean isAdmin;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@ElementCollection
    private Collection<String> buzonMensajeCompras = new ArrayList<>();

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "rol_usuario")
    private RolUsuario rolUsuario;

	public Long getId() {
		return id;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public Boolean usuarioEsAdmin() {
		return isAdmin;
	}

	public void setRolUsuario(RolUsuario rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	/*

	public Usuario(String nombreUsuario, RolUsuario rolUsuario, String contrasenia){
			validarContrasenia(contrasenia);
			registrarContrasenia(contrasenia);
			this.nombreUsuario = nombreUsuario;
			this.rolUsuario = rolUsuario;
	}
*/

	public void setContrasenia(String contrasenia){
		validarContrasenia(contrasenia);
	}



	public void validarContrasenia(String contrasenia) {
	 	ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();

		ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();
		ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
		ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
		ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();
		
		// Usar Arrays.asList
		listValidarContrasenia.add(validarLongitudMinima);
		listValidarContrasenia.add(validarCaracteresRepetidos);
		listValidarContrasenia.add(validarUnNumeroUnaLetra);
		listValidarContrasenia.add(validarContraseniaDebil);

		listValidarContrasenia.forEach( objeto -> objeto.validar(contrasenia) );

	}

	public void agregarNotificacion(String estadoCompra) {
		buzonMensajeCompras.add(estadoCompra);
	}

	private void registrarContrasenia(String contrasenia){
		//TODO
	}
    


}


