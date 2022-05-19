/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ciudad;
import Modelo.Jugador;
import Vista.Nueva_Partida;
import static Vista.Nueva_Partida.acciones;
import static Vista.Nueva_Partida.brotes;
import static Vista.Nueva_Partida.contador;
import static Vista.Nueva_Partida.porcentajeAzul;
import static Vista.Nueva_Partida.porcentajeMorado;
import static Vista.Nueva_Partida.porcentajeRojo;
import static Vista.Nueva_Partida.porcentajeVerde;
import Vista.PanelPrincipal;
import static Vista.Parametros.usuario;
import Vista.Ranking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author DAM1
 */
public class BaseDatos {
    
    
    static DefaultListModel listModel = new DefaultListModel();
    static JList list =new JList(listModel);
    
    static ArrayList <String> lista = new ArrayList<>();
    public static ArrayList <Ciudad> ciudades = new ArrayList<>();    
    
    private static final String USER = "PND_4_20";
    private static final String PWD = "CNV1234";
    private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
    // Funcion que va conectarse a mi bd de mysql
    static String pos = "San Francisco";
    static String posicion = "";
    static String nombre = "";
    static int acciones = 0;
    static int vacunaVerde = 0;
    static int vacunaAzul = 0;
    static int vacunaRojo = 0;
    static int vacunaMorado = 0;
    static int ronda = 0;
    static int brotes = 0;
    static int ciudadesInfIni = 0;
    static int ciudadesInfRon = 0;
    static int maxEnf = 0;
    static int maxBro = 0;
    
    

    

    public static Connection conector() {
        // Reseteamos a null la conexion a la bd
        Connection con = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Nos conectamos a la bd
            con = DriverManager.getConnection(URL, USER, PWD);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            //jLabel35.setText("Conectado");
            // Si la conexion NO fue exitosa mostramos un mensaje de error    
        } catch (SQLException e) {
            //jLabel35.setText("Error de conexion" + e);

        } catch (ClassNotFoundException e) {
            //jLabel35.setText("Error de conexion" + e);
        }

        return con;

    }

    public static void insertWithStatement(Connection con, int a, int b, int c, int d, ArrayList<Ciudad> ciudades) {

        String cdds = "";

        for (int i = 0; i < 48; i++) {

            if (i == 47) {
                cdds += "Ciudad('" + ciudades.get(i).getNombre() + "'," + ciudades.get(i).getTipo() + "," + ciudades.get(i).getVerde() + "," + ciudades.get(i).getAzul() + "," + ciudades.get(i).getRojo() + "," + ciudades.get(i).getMorado() + ") )";
            } else {
                cdds += "Ciudad('" + ciudades.get(i).getNombre() + "'," + ciudades.get(i).getTipo() + "," + ciudades.get(i).getVerde() + "," + ciudades.get(i).getAzul() + "," + ciudades.get(i).getRojo() + "," + ciudades.get(i).getMorado() + "),";
            }

        }

        String sql = "INSERT INTO Cargar_Partida VALUES(Jugador('" + pos + "','" + usuario + "'," + acciones + "," + porcentajeVerde + "," + porcentajeAzul + "," + porcentajeRojo + "," + porcentajeMorado + "), CIUDADESA(" + cdds + ",Partida(" + contador + "," + brotes + "),Parametros(" + a + "," + b + "," + c + "," + d + "))";

        try {
            Statement statement = (Statement) con.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            System.out.println("The Insert had problems!! " + e);

        }
    }

    public static ArrayList<Ciudad> selectWithStatement(Connection con, String jugador) {
        
        for (int j = 0; j < 48; j++) {
            ciudades.add(new Ciudad());
        }
        Statement st = null;
        String sql = "SELECT w.NOMBRE.posicion, w.NOMBRE.nombre, w.NOMBRE.acciones, w.NOMBRE.vacunaVerde, w.NOMBRE.vacunaAzul, w.NOMBRE.vacunaRojo, w.NOMBRE.vacunaMorado, w.PARTIDAA.ronda, w.PARTIDAA.brotes, w.PARAMETRO.num_ciudades_infectadas_inicio, w.PARAMETRO.num_ciudades_infectadas_ronda, w.PARAMETRO.maximo_enfermedades, w.PARAMETRO.maximo_brotes FROM CARGAR_PARTIDA w where w.NOMBRE.nombre ='" + jugador +"'";
       
        

        try {
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            

            while (rs.next()) {
                posicion = rs.getString("NOMBRE.POSICION");
                PanelPrincipal.player.setPosicion(posicion);
                
                String nombre = rs.getString("NOMBRE.NOMBRE");
                PanelPrincipal.player.setNombre(nombre);
                
                acciones = rs.getInt("NOMBRE.acciones");
                PanelPrincipal.player.setAcciones(acciones);
                
                vacunaVerde = rs.getInt("NOMBRE.vacunaVerde");
                PanelPrincipal.player.setvacunaV(vacunaVerde);
                
                vacunaAzul = rs.getInt("NOMBRE.vacunaAzul");
                PanelPrincipal.player.setvacunaA(vacunaAzul);
                
                vacunaRojo = rs.getInt("NOMBRE.vacunaRojo");
                PanelPrincipal.player.setvacunaR(vacunaRojo);
                
                vacunaMorado = rs.getInt("NOMBRE.vacunaMorado");
                PanelPrincipal.player.setvacunaM(vacunaMorado);
                
                ronda = rs.getInt("PARTIDAA.ronda");
                Nueva_Partida.contador = ronda;
                
                brotes = rs.getInt("PARTIDAA.brotes");
                Nueva_Partida.brotes = brotes;
                
                ciudadesInfIni =rs.getInt("PARAMETRO.num_ciudades_infectadas_inicio");
                Nueva_Partida.parametrosVar[0] = ciudadesInfIni;
                
                ciudadesInfRon =rs.getInt("PARAMETRO.num_ciudades_infectadas_ronda");
                Nueva_Partida.parametrosVar[1] = ciudadesInfRon;
                
                maxEnf =rs.getInt("PARAMETRO.maximo_enfermedades");
                Nueva_Partida.parametrosVar[2] = maxEnf;
                
                maxBro =rs.getInt("PARAMETRO.maximo_brotes");
                Nueva_Partida.parametrosVar[3] = maxBro;
                
 

            }

            st.close();
        } catch (SQLException e) {
            System.out.println("The SELECT had problems!! " + e);

        }
        
        
        
              
            String sqlC = "SELECT e.Nombre, e.Tipo, e.Verde, e.Azul, e.Rojo, e.Morado FROM CARGAR_PARTIDA w, table(w.LUGARES) e where w.NOMBRE.nombre ='"+jugador+"'";
        try {
        
        
            st = con.createStatement();
            ResultSet c = st.executeQuery(sqlC);
            int z = 0;
            
            while (c.next()) {
            ciudades.get(z).setNombre(c.getString("Nombre"));
            ciudades.get(z).setTipo(c.getInt("Tipo"));
            ciudades.get(z).setVerde(c.getInt("Verde"));
            ciudades.get(z).setAzul(c.getInt("Azul"));
            ciudades.get(z).setRojo(c.getInt("Rojo"));
            ciudades.get(z).setMorado(c.getInt("Morado"));
            z++;
            }


            st.close();
        } catch (SQLException e) {
            System.out.println("The SELECT had problems!! " + e);

        }

        
        
       
        
        
        
        return ciudades;
            
}

    public static void InsertRanking(Connection con, String nombre) {

        String sql = "Insert into ranking (id , nombre , puntos ) values (IDGEN.nextval,'" + nombre + "',0)";

        Statement st = null;

        try {
            Statement statement = (Statement) con.createStatement();
            statement.execute(sql);
            statement.close();

        } catch (SQLException e) {
            System.out.println("The Insert had problems!! " + e);

        }
    }

    public static void SelectRanking(Connection con, String nombre) {
        lista.clear();
        int contador = 0;
        int Puntos = 0;
        String Frase = "";
        String sql = "SELECT nombre, puntos FROM RANKING";

        Statement st = null;

        try {
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                contador++;
                Frase = rs.getString("NOMBRE");
                Puntos = rs.getInt("PUNTOS");
                Ranking.jList1.add("En la posicion " + String.valueOf(contador) + " " + Frase + " con " + String.valueOf(Puntos) + " puntos");
                Ranking.jList1.add("");
               
            }

            st.close();
        } catch (SQLException e) {
            System.out.println("The SELECT had problems!! " + e);

        }


    }
    
        public static void SumarRanking(Connection con, String nombre) {
            
        String sql = "UPDATE RANKING SET puntos = puntos + 100 where nombre = '"+nombre+"'";

        Statement st = null;

        try {
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            st.close();
        } catch (SQLException e) {
            System.out.println("The SELECT had problems!! " + e);

        }


    }

}
