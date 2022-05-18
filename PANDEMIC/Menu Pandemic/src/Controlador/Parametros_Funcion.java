package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class Parametros_Funcion {
    private int numCiudadesInfectadasInicio =0;
    private int numCuidadesInfectadasRonda=0;
    private int numEnfermedadesActivasDerrota=0;
    private int numBrotesDerrota=0;
    private String ruta_archivo;
    private static ArrayList<Integer> parametros; 
    
    
    public Parametros_Funcion(int dificultad)  {
        if (dificultad==1){
        ruta_archivo="C:\\Users\\honor\\Desktop\\Pandemic-V.C.N\\PANDEMIC\\Menu Pandemic\\src\\XML\\Facil.xml";
        }   
        else if (dificultad==2){
        ruta_archivo="C:\\Users\\honor\\Desktop\\Pandemic-V.C.N\\PANDEMIC\\Menu Pandemic\\src\\XML\\Normal.xml";
        }   
         else if (dificultad==3){
        ruta_archivo="C:\\Users\\honor\\Desktop\\Pandemic-V.C.N\\PANDEMIC\\Menu Pandemic\\src\\XML\\Dificil.xml";
        }   
     
    }
    
    
    public ArrayList<Integer> leer_xml(){
        
        parametros = new ArrayList<>();
        
        
        try {
            Element dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta_archivo).getDocumentElement();

            parametros.add(Integer.parseInt(dom.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getFirstChild().getNodeValue()));
            parametros.add(Integer.parseInt(dom.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getFirstChild().getNodeValue()));
            parametros.add(Integer.parseInt(dom.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getFirstChild().getNodeValue()));
            parametros.add(Integer.parseInt(dom.getElementsByTagName("numBrotesDerrota").item(0).getFirstChild().getNodeValue()));

        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Parametros_Funcion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return parametros;
    }
    
}
