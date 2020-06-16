package modelo.ValidarContrasenia;

import java.io.*;
import java.net.URL;

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
			URL path =  ValidarContraseniaDebil.class.getResource("contrasenias.txt");


			archivo = new File (path.getFile());
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);


			String linea;
			while((linea=br.readLine())!=null)
				if(linea.equals(contrasenia)) {
					throw new ValidarContraseniaException("La clave: "+contrasenia+" es una clave débil");
				}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ValidarContraseniaException("Tenemos problemas para validar la contrasenia. Por favor informar al administrador del sistema");
		}finally{

			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
}

