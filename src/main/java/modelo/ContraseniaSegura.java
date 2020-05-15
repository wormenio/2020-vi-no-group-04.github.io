package modelo;

import java.io.*;
import java.net.URL;
public class ContraseniaSegura {
	

	public boolean  esSegura(String contrasenia) {
	 

	      File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	       
	      try {	 
	    	 URL path = ContraseniaSegura.class.getResource("contrasenias.txt");
	    	 

	    	 archivo = new File (path.getFile());
	    	 fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         
	         String linea;
	         while((linea=br.readLine())!=null)
	        	 if(linea.equals(contrasenia)) {
	        		 return false;
	        	 }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	      return true;   
	   }
		
}

