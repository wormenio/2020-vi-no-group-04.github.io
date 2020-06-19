package modelo.ValidarContrasenia;

import modelo.UsuarioException;

import java.io.*;
// import java.net.URL;

/**
 * Valida que la contrasenia contra un archivo txt de contrasenias débiles
 */
public class ValidarContraseniaDebil implements ValidarContrasenia {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	@Override
	public void validar(String contrasenia) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			String pathClaves = System.getProperty("user.dir");

			archivo = new File (pathClaves+"/claves/contrasenias.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
			while((linea=br.readLine())!=null){
				if(linea.equals(contrasenia)) {
					throw new Exception("La clave: "+contrasenia+" es una clave débil");
				}
			}
			fr.close();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ValidarContraseniaException(e.getMessage());
		}
	}
}

