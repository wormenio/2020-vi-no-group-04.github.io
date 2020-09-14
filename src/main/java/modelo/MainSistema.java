package modelo;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainSistema {
	
	
public static void main(String[] args) {
		
	
	
		
	
		SeleccionadorPais generadorPaies = new SeleccionadorPais();
		List<Pais> paisesSistema = generadorPaies.paisesSistema();
		
	  System.out.print(paisesSistema.get(0).verNombre());	

	}

}
