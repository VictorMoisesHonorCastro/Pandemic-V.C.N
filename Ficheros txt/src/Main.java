import java.io.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		String NomFit = "ciudades.txt";
		//Creamos un String que va a contener todo el texto del archivo
	     String s; 
	     
	     String[] separar;
	     String[] tmp;
	     int[] coordenadas = new int[2];
	     String ciudad = "";

	     String frase = "";
	try {
	      //Abrir el fichero indicado en la variable nombreFichero
		   FileReader fr = new FileReader(NomFit);
		   BufferedReader br = new BufferedReader(fr); 
		   
		    do { 
		       s = br.readLine();
		       
			   if (s != null) {
				   
				   separar = s.split(";");
				   
				   tmp = separar[2].split(",");
				   coordenadas[0] = Integer.parseInt(tmp[0]);
				   coordenadas[1] = Integer.parseInt(tmp[1]);
				   
				   ciudad = separar[0];
				   
				   String[] ciudadesC = separar[3].split(",");
				   
				   System.out.println("La ciudad " + ciudad + " está en las coordenadas " + coordenadas[0] + "," + coordenadas[1] + " y sus ciudades colindantes son: ");
				   String texto="La ciudad " + ciudad + " está en las coordenadas " + coordenadas[0] + "," + coordenadas[1] + " y sus ciudades colindantes son: ";
					String NomFit1 = "text.txt";
					//Creamos un String que va a contener todo el texto del archivo
				Scanner teclado = new Scanner(System.in);
				try {
				      
					   // true -> guarda los datos al final del fichero conservando los datos que ya había	
					   // false o res -> Si el archivo existe lo elimina y escribe el nuevo contenido
					   FileWriter fw = new FileWriter(NomFit1,true);
					   //Crear un objeto BufferedWriter
					   BufferedWriter bw = new BufferedWriter(fw);
					 
					 
					    
					   
					       //Escrbir en el fichero el texto
					       bw.write(texto);
					       //Escribir en el fichero un salto de línea
					       bw.newLine();
					       //También se puede: bw.write("\n");
			
					   //Cerrar el buffer
					   bw.close();
					   fw.close();
				
						
				    }catch(IOException e){
				         System.out.println("Error E/S: "+e);}
				
				
				   for (int i = 0; i < ciudadesC.length; i++) {					   
					   
					   String ciudadC = "";
					   String[] separa = new String[10];
					   String[] temporal;
					   int[] coordenadasC = new int[2];
					   double x = 0;
					   double y = 0;
					   double h1 = 0;
					   double h2 = 0;
					   double z = 0;
					   

					   String s2;
					   FileReader fr2 = new FileReader(NomFit);
					   BufferedReader br2 = new BufferedReader(fr2); 
					   
					   while(!ciudadesC[i].trim().equals(ciudadC)) {						   						  						   
						   
						   s2 = br2.readLine();
						   
						   if (s2 != null) {
							   
							   separa = s2.split(";");
							   ciudadC = separa[0].trim();
							   
						   }

					   }				   					   
					   
					   temporal = separa[2].split(",");
					   
					   coordenadasC[0] = Integer.parseInt(temporal[0]);
					   coordenadasC[1] = Integer.parseInt(temporal[1]);
					   
					   x = coordenadas[0] * coordenadas[0] + coordenadasC[0] * coordenadasC[0];
					   y = coordenadas[1] * coordenadas[1] + coordenadasC[1] * coordenadasC[1];
					   
					   h1 = Math.sqrt(x);
					   h2 = Math.sqrt(y);
					   
					   z = h1 + h2;
					   System.out.println(ciudadC + " a una distancia de " + z);
					   String texto1=ciudadC + " a una distancia de " + z;
						String NomFit11 = "text.txt";
						//Creamos un String que va a contener todo el texto del archivo
					
					try {
					      
						   // true -> guarda los datos al final del fichero conservando los datos que ya había	
						   // false o res -> Si el archivo existe lo elimina y escribe el nuevo contenido
						   FileWriter fw = new FileWriter(NomFit11,true);
						   //Crear un objeto BufferedWriter
						   BufferedWriter bw = new BufferedWriter(fw);
						 
						 
						    
						   
						       //Escrbir en el fichero el texto
						       bw.write(texto1);
						       //Escribir en el fichero un salto de línea
						       bw.newLine();
						       //También se puede: bw.write("\n");
				
						   //Cerrar el buffer
						   bw.close();
						   fw.close();
			
							
					    }catch(IOException e){
					         System.out.println("Error E/S: "+e);}
					   fr2.close();
			           br2.close(); 
					   

				   }
				   
			   }			   
			   
			   
		   } while(s != null);
		      
		   //Cerrar el fichero
		   fr.close();
	           br.close();
		   }catch(IOException e){ System.out.println("Error E/S: "+e);}
	
	

	}
	

}
