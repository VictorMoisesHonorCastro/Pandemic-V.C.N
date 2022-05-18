/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Ciudad;
import static Vista.Nueva_Partida.acciones;
import static Vista.Parametros.usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Jugador;
import static Vista.Nueva_Partida.brotes;
import static Vista.Nueva_Partida.contador;
import static Vista.Nueva_Partida.porcentajeAzul;
import static Vista.Nueva_Partida.porcentajeMorado;
import static Vista.Nueva_Partida.porcentajeRojo;
import static Vista.Nueva_Partida.porcentajeVerde;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DAM1
 */
public class BaseDatos {
        private static final String USER = "DAW1_55258158Z";
	private static final String PWD = "A55258158Z";
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";
        // Funcion que va conectarse a mi bd de mysql
        static String pos = "";

        
	

        
    public static Connection conector(int a, int b, int c, int d, ArrayList<Ciudad> ciudades) {
        // Reseteamos a null la conexion a la bd
            Connection con = null;
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Nos conectamos a la bd
            con = DriverManager.getConnection(URL,USER,PWD);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
                //jLabel35.setText("Conectado");
            // Si la conexion NO fue exitosa mostramos un mensaje de error    
        }catch (SQLException e){        
            //jLabel35.setText("Error de conexion" + e);
            
        }catch (ClassNotFoundException e) {
            //jLabel35.setText("Error de conexion" + e);
	}
        insertWithStatement(con,a,b,c,d, ciudades);
        return con;

    }
    
public static void insertWithStatement(Connection con, int a, int b, int c, int d, ArrayList<Ciudad> ciudades) {

    String cdds = "";
    
    for (int i = 0; i < 48; i++) {
        
        if (i == 47) {
            cdds += "Ciudad('" + ciudades.get(i).getNombre() + "'," + ciudades.get(i).getTipo() +  "," + ciudades.get(i).getVerde() + "," + ciudades.get(i).getAzul() + "," + ciudades.get(i).getRojo() + "," + ciudades.get(i).getMorado() + ") )";            
        } else {
            cdds += "Ciudad('" + ciudades.get(i).getNombre() + "'," + ciudades.get(i).getTipo() +  "," + ciudades.get(i).getVerde() + "," + ciudades.get(i).getAzul() + "," + ciudades.get(i).getRojo() + "," + ciudades.get(i).getMorado() + "),";
        }
     
    }
    
    String sql = "INSERT INTO Cargar_Partida VALUES(Jugador('" + pos + "','" + usuario + "'," + acciones + ","+ porcentajeVerde + "," + porcentajeAzul + "," + porcentajeRojo + "," + porcentajeMorado + "), CIUDADESA(" + cdds + ",Partida(" + contador + "," + brotes + "),Parametros(" + a + "," + b + "," + c + "," + d + "))";
    
		try {
			Statement statement = (Statement) con.createStatement();
			statement.execute(sql);
			statement.close();
			
		} catch (SQLException e) {
			System.out.println("The Insert had problems!! " + e);
			
		} 
	}

public static void selectWithStatement(Connection con, int a, int b, int c, int d) {
		
		String sql = "SELECT (w.Nombre.posicion'-'w.Nombre.nombre'-'w.Nombre.acciones'-'w.Nombre.vacunaVerde'-'w.Nombre.vacunaAzul'-'w.Nombre.vacunaRojo'-'w.Nombre.vacunaMorado'-'\n" +
"        e.Nombre'-'e.Tipo'-'e.Verde'-'e.Azul'-'e.Rojo'-'e.Morado'-'\n" +
"        w.Partidaa.ronda'-'w.Partidaa.brotes'-'\n" +
"        w.Parametro.num_ciudades_infectadas_inicio'-'w.Parametro.num_ciudades_infectadas_ronda'-'w.Parametro.maximo_enfermedades'-'w.Parametro.maximo_brotes)\n" +
"        as \"cargar_partida\" FROM cargar_partida w,TABLE(w.Lugares) e;";
		
		Statement st = null;
		
		try {
			st = con.createStatement();
			
		    ResultSet rs = st.executeQuery(sql);
		       
		    while (rs.next())
		    {
		    	String posicion = rs.getString("w.Nombre.posicion");
                        System.out.print(posicion);

		    }
		      
		    st.close();
		} catch (SQLException e) {
			System.out.println("The SELECT had problems!! " + e);
			
		}
}
    
   
    
}
