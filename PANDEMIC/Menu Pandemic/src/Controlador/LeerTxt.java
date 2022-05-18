/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ciudad;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM1
 */
public class LeerTxt {

    public static ArrayList<Ciudad> crearCiudades() {
        
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();     

        String NomFit = "C:\\Users\\honor\\Desktop\\Pandemic-V.C.N\\PANDEMIC\\Menu Pandemic\\src\\txt\\ciudades.txt";
        
        String s;



        try {

            FileReader fr = new FileReader(NomFit);
            BufferedReader br = new BufferedReader(fr);

            do {
                s = br.readLine();

                if (s != null) {
                    
                    
                String[] separar;
                String[] tmp;
                int[] coordenadas = new int[2];
                String ciudad = "";
                int tipo = 0;
                
                separar = s.split(";");

                    tmp = separar[2].split(",");
                    coordenadas[0] = Integer.parseInt(tmp[0]);
                    coordenadas[1] = Integer.parseInt(tmp[1]);
                    
                    tipo = Integer.parseInt(separar[1]);
                    ciudad = separar[0];

                    String[] ciudadesC = new String [5];
                    int numColin = 0;
                    ciudadesC[0] = "a";
                    ciudadesC[1] = "a";
                    ciudadesC[2] = "a";
                    ciudadesC[3] = "a";
                    ciudadesC[4] = "a";
                    String[] colindantes = separar[3].split(",");
                    
                    if (colindantes.length == 1) {
                        ciudadesC[0] = colindantes[0];
                        numColin = 1;
                    } else if (colindantes.length == 2) {
                        ciudadesC[0] = colindantes[0];
                        ciudadesC[1] = colindantes[1];
                        numColin = 2;
                    } else if (colindantes.length == 3) {
                        ciudadesC[0] = colindantes[0];
                        ciudadesC[1] = colindantes[1];
                        ciudadesC[2] = colindantes[2];
                        numColin = 3;
                    } else if (colindantes.length == 4) {
                        ciudadesC[0] = colindantes[0];
                        ciudadesC[1] = colindantes[1];
                        ciudadesC[2] = colindantes[2];
                        ciudadesC[3] = colindantes[3];
                        numColin = 4;
                    } else if (colindantes.length == 5) {
                        ciudadesC[0] = colindantes[0];
                        ciudadesC[1] = colindantes[1];
                        ciudadesC[2] = colindantes[2];
                        ciudadesC[3] = colindantes[3];
                        ciudadesC[4] = colindantes[4];
                        numColin = 5;
                    }
                            
                    
                    ciudades.add(new Ciudad(ciudad,tipo,0,0,0,0,ciudadesC,coordenadas,numColin));
                    
                }

            } while (s != null);

            //Cerrar el fichero
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
        
        return ciudades;

    }

}
