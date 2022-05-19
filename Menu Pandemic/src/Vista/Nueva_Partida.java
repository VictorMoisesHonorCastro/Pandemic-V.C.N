package Vista;

import Controlador.BaseDatos;
import static Controlador.BaseDatos.InsertRanking;
import static Controlador.BaseDatos.SelectRanking;
import static Controlador.BaseDatos.SumarRanking;
import static Controlador.BaseDatos.conector;
import static Controlador.LeerTxt.crearCiudades;
import Modelo.Ciudad;
import Modelo.Jugador;
import static Vista.Nueva_Partida.ciudades;
import static Vista.PanelPrincipal.player;
import static Vista.Parametros.usuario;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DAW
 */
public class Nueva_Partida extends javax.swing.JPanel {
    
    public static int acciones=4;
    
    public static int[] parametrosVar = new int[4];
    public static int contador = 1;
    int totalVerdes = 0;
    int totalAzules = 0;
    int totalRojos = 0;
    int totalMorados = 0;
    public String[] ciudadLog = new String[10];
    static ArrayList<Ciudad> ciudades;
    public static int brotes = 0;
    static public int porcentajeVerde = 0;
    static public int porcentajeRojo = 0;
    static public int porcentajeAzul = 0;
    static public int porcentajeMorado = 0;
    public static int puntos = 0;
    
    
    
    public static List<Integer> aleatorioRonda(int infecciones_ronda) {
        int longitud = infecciones_ronda;
        int numero = 0;
        List<Integer> numerosAleatorios = new ArrayList<>();

        Random random = new Random();
        numero = random.nextInt(48);
        numerosAleatorios.add(numero);
        numero = random.nextInt(48);
        
        for (int i = 0; i < longitud - 1; i++) {
   
            while(numerosAleatorios.contains(numero)) {
                numero = random.nextInt(48);
            }
            
            numerosAleatorios.add(numero);
            numero = random.nextInt(48);

        }
        return numerosAleatorios;
    }

    /**
     * Creates new form PanelPrincipal
     */
    public Nueva_Partida(ArrayList<Ciudad> ciudades1) {
        initComponents();
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciudades1;
        totalVerdes = 0;
        totalAzules = 0;
        totalRojos = 0;
        totalMorados = 0;

        for (int i = 0; i < 48; i++) {

            totalVerdes += ciudades.get(i).getVerde();
            totalAzules += ciudades.get(i).getAzul();
            totalRojos += ciudades.get(i).getRojo();
            totalMorados += ciudades.get(i).getMorado();

        }
        
        jLabel2.setText("Ronda " + contador);
        jLabel11.setText("Brotes " + brotes);
        jLabel3.setText(String.valueOf(totalVerdes));
        jLabel4.setText(String.valueOf(totalAzules));
        jLabel5.setText(String.valueOf(totalRojos));
        jLabel6.setText(String.valueOf(totalMorados));
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        
        jLabel35.setVisible(false);
        jLabel36.setVisible(false);
        jLabel37.setVisible(false);
        jLabel38.setVisible(false);
        jLabel39.setVisible(false);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);
        
    }

    public Nueva_Partida(int infecciones_inicio, int infecciones_ronda, int enfermedades_muerte, int brotes_muerte, int empezada) {
        

        InsertRanking(BaseDatos.conector(), usuario);
        
        String[] ciudadLogInicio = new String[10];

        ciudades = new ArrayList<Ciudad>();
        ciudades = crearCiudades();
        List<Integer> numerosAleatoriosInicio = new ArrayList<>();
        List<Integer> numerosAleatoriosRonda = new ArrayList<>();
        numerosAleatoriosInicio = aleatorioInicio(infecciones_inicio);
        numerosAleatoriosRonda = aleatorioRonda(infecciones_ronda);
        // tipo 0 = verde, tipo 1 = morado, tipo 2 = rojo, tipo 3 = azul

        for (int i = 0; i < numerosAleatoriosInicio.size(); i++) {
            
            if (i < 3) {
                
            if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 0) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setVerde(ciudades.get(numerosAleatoriosInicio.get(i)).getVerde() + 3);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 1) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setMorado(ciudades.get(numerosAleatoriosInicio.get(i)).getMorado() + 3);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 2) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setRojo(ciudades.get(numerosAleatoriosInicio.get(i)).getRojo() + 3);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 3) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setAzul(ciudades.get(numerosAleatoriosInicio.get(i)).getAzul() + 3);
            }
            ciudadLogInicio[i] = ciudades.get(numerosAleatoriosInicio.get(i)).getNombre();
                
            } else if (i < 6) {
                
            if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 0) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setVerde(ciudades.get(numerosAleatoriosInicio.get(i)).getVerde() + 2);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 1) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setMorado(ciudades.get(numerosAleatoriosInicio.get(i)).getMorado() + 2);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 2) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setRojo(ciudades.get(numerosAleatoriosInicio.get(i)).getRojo() + 2);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 3) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setAzul(ciudades.get(numerosAleatoriosInicio.get(i)).getAzul() + 2);
            }
            ciudadLogInicio[i] = ciudades.get(numerosAleatoriosInicio.get(i)).getNombre();
            
            } else {
            if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 0) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setVerde(ciudades.get(numerosAleatoriosInicio.get(i)).getVerde() + 1);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 1) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setMorado(ciudades.get(numerosAleatoriosInicio.get(i)).getMorado() + 1);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 2) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setRojo(ciudades.get(numerosAleatoriosInicio.get(i)).getRojo() + 1);
            } else if (ciudades.get(numerosAleatoriosInicio.get(i)).getTipo() == 3) {
                ciudades.get(numerosAleatoriosInicio.get(i)).setAzul(ciudades.get(numerosAleatoriosInicio.get(i)).getAzul() + 1);
            }
            ciudadLogInicio[i] = ciudades.get(numerosAleatoriosInicio.get(i)).getNombre();                
            }
            

        }

        parametrosVar[0] = infecciones_inicio;
        parametrosVar[1] = infecciones_ronda;
        parametrosVar[2] = enfermedades_muerte;
        parametrosVar[3] = brotes_muerte;

        initComponents();
        jLabel35.setVisible(false);
        jLabel36.setVisible(false);
        jLabel37.setVisible(false);
        jLabel38.setVisible(false);
        jLabel39.setVisible(false);
        
        jLabel22.setText(ciudadLogInicio[0]);
        jLabel23.setText(ciudadLogInicio[1]);
        jLabel24.setText(ciudadLogInicio[2]);
        jLabel25.setText(ciudadLogInicio[3]);
        jLabel26.setText(ciudadLogInicio[4]);
        jLabel27.setText(ciudadLogInicio[5]);
        jLabel28.setText(ciudadLogInicio[6]);
        jLabel29.setText(ciudadLogInicio[7]);
        jLabel30.setText(ciudadLogInicio[8]);
        jLabel31.setText(ciudadLogInicio[9]);

        for (int i = 0; i < 48; i++) {

            totalVerdes += ciudades.get(i).getVerde();
            totalAzules += ciudades.get(i).getAzul();
            totalRojos += ciudades.get(i).getRojo();
            totalMorados += ciudades.get(i).getMorado();

        }

        jLabel3.setText(String.valueOf(totalVerdes));
        jLabel4.setText(String.valueOf(totalAzules));
        jLabel5.setText(String.valueOf(totalRojos));
        jLabel6.setText(String.valueOf(totalMorados));

         jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);
    }

    public static List<Integer> aleatorioInicio(int infecciones_inicio) {
        int longitud = infecciones_inicio;
        int numero = 0;
        List<Integer> numerosAleatorios = new ArrayList<>();

        Random random = new Random();
        
        numero = random.nextInt(48);
        numerosAleatorios.add(numero);
        numero = random.nextInt(48);
        
        for (int i = 0; i < longitud - 1; i++) {
   
            while(numerosAleatorios.contains(numero)) {
                numero = random.nextInt(48);
            }
            
            numerosAleatorios.add(numero);
            numero = random.nextInt(48);

        }
        return numerosAleatorios;

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        SanFrancisco = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        CuraMorado = new javax.swing.JButton();
        CuraRojo = new javax.swing.JButton();
        CuraAzul = new javax.swing.JButton();
        CuraVerde = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/star-struck-whatsapp.png"))); // NOI18N
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 170, 300));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/derrota-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 420, 290));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel37.setText("¡Has perdido! Pulsa el botón VOLVER para ir al menú principal");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 730, 50));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setText("¡Has ganado! Pulsa el botón VOLVER para ir al menú principal");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 730, 50));

        jLabel36.setOpaque(true);
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 750, 460));

        SanFrancisco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        SanFrancisco.setText("jButton2");
        SanFrancisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SanFranciscoActionPerformed(evt);
            }
        });
        jPanel1.add(SanFrancisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 20, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton3.setText("jButton2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 20, 20));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 20, 20));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 20, 20));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 20, 20));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 20, 20));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 20, 20));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 20, 20));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton12.setText("jButton11");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 250, 20, 20));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton13.setText("jButton11");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 190, 20, 20));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton14.setText("jButton11");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 20, 20));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.png"))); // NOI18N
        jButton15.setText("jButton11");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 210, 20, 20));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton16.setText("jButton11");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 355, 20, 20));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton17.setText("jButton11");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 20, 20));

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton18.setText("jButton11");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 385, 20, 20));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton19.setText("jButton11");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 20, 20));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton20.setText("jButton11");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 20, 20));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton21.setText("jButton11");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, 20, 20));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton22.setText("jButton11");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 670, 20, 20));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton23.setText("jButton11");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 20, 20));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton24.setText("jButton11");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 20, 20));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton25.setText("jButton11");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 20, 20));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton26.setText("jButton11");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 450, 20, 20));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorAzul.png"))); // NOI18N
        jButton27.setText("jButton11");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 630, 20, 20));

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton28.setText("jButton11");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 20, 20));

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton29.setText("jButton11");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 20, 20));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton30.setText("jButton11");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 385, 20, 20));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton31.setText("jButton11");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 294, 20, 20));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton32.setText("jButton11");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 20, 20));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton33.setText("jButton11");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 20, 20));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton34.setText("jButton11");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 20, 20));

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton35.setText("jButton11");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 355, 20, 20));

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton36.setText("jButton11");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, 20, 20));

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton37.setText("jButton11");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 330, 20, 20));

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton38.setText("jButton11");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 370, 20, 20));

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorRojo.jpg"))); // NOI18N
        jButton39.setText("jButton11");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 410, 20, 20));

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton40.setText("jButton11");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 525, 20, 20));

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton41.setText("jButton11");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 415, 20, 20));

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton42.setText("jButton11");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 370, 20, 20));

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton43.setText("jButton11");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 355, 20, 20));

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton44.setText("jButton11");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 300, 20, 20));

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton45.setText("jButton11");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1225, 297, 20, 20));

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton46.setText("jButton11");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 300, 20, 20));

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton47.setText("jButton11");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 320, 20, 20));

        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton48.setText("jButton11");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 390, 20, 20));

        jButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton49.setText("jButton11");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1148, 429, 20, 20));

        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton50.setText("jButton11");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 430, 20, 20));

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/colorMorado.png"))); // NOI18N
        jButton51.setText("jButton11");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 660, 20, 20));

        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Curar_Ciudad.png"))); // NOI18N
        jButton54.setBorder(null);
        jButton54.setContentAreaFilled(false);
        jButton54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton54.setFocusPainted(false);
        jButton54.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Curar_Ciudad_Pulsado.png"))); // NOI18N
        jButton54.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Curar_Ciudad_Pulsado.png"))); // NOI18N
        jButton54.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Cargar Partida Pulsado.png"))); // NOI18N
        jButton54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton54MouseClicked(evt);
            }
        });
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 830, -1, -1));

        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Buscar_Cura.png"))); // NOI18N
        jButton55.setBorder(null);
        jButton55.setContentAreaFilled(false);
        jButton55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton55.setFocusPainted(false);
        jButton55.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Buscar_Cura_Pulsado.png"))); // NOI18N
        jButton55.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Buscar_Cura_Pulsado.png"))); // NOI18N
        jButton55.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Buscar_Cura_Pulsado.png"))); // NOI18N
        jButton55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton55MouseClicked(evt);
            }
        });
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 840, -1, -1));

        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Acciones.png"))); // NOI18N
        jButton53.setBorder(null);
        jButton53.setContentAreaFilled(false);
        jButton53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton53.setFocusPainted(false);
        jButton53.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Acciones Pulsado.png"))); // NOI18N
        jButton53.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Acciones Pulsado.png"))); // NOI18N
        jButton53.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Acciones Pulsado.png"))); // NOI18N
        jButton53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton53MouseClicked(evt);
            }
        });
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 900, -1, -1));

        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego.png"))); // NOI18N
        jButton56.setBorder(null);
        jButton56.setContentAreaFilled(false);
        jButton56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton56.setFocusPainted(false);
        jButton56.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton56.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton56.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 810, -1, -1));

        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jButton61.setBorder(null);
        jButton61.setContentAreaFilled(false);
        jButton61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton61.setFocusPainted(false);
        jButton61.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jButton61.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jButton61.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton61MouseClicked(evt);
            }
        });
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 910, -1, -1));

        jButton62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        jButton62.setBorder(null);
        jButton62.setContentAreaFilled(false);
        jButton62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton62.setFocusPainted(false);
        jButton62.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul_1.png"))); // NOI18N
        jButton62.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul_1.png"))); // NOI18N
        jButton62.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        jButton62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton62MouseClicked(evt);
            }
        });
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 910, -1, -1));

        jButton63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata.png"))); // NOI18N
        jButton63.setBorder(null);
        jButton63.setContentAreaFilled(false);
        jButton63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton63.setFocusPainted(false);
        jButton63.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        jButton63.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        jButton63.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        jButton63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton63MouseClicked(evt);
            }
        });
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 910, -1, -1));

        jButton64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jButton64.setBorder(null);
        jButton64.setContentAreaFilled(false);
        jButton64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton64.setFocusPainted(false);
        jButton64.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jButton64.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jButton64.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jButton64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton64MouseClicked(evt);
            }
        });
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 920, -1, -1));

        CuraMorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        CuraMorado.setBorder(null);
        CuraMorado.setContentAreaFilled(false);
        CuraMorado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuraMorado.setFocusPainted(false);
        CuraMorado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        CuraMorado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        CuraMorado.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        CuraMorado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuraMoradoMouseClicked(evt);
            }
        });
        CuraMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuraMoradoActionPerformed(evt);
            }
        });
        jPanel1.add(CuraMorado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 920, -1, -1));

        CuraRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata.png"))); // NOI18N
        CuraRojo.setBorder(null);
        CuraRojo.setContentAreaFilled(false);
        CuraRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuraRojo.setFocusPainted(false);
        CuraRojo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        CuraRojo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        CuraRojo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata_1.png"))); // NOI18N
        CuraRojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuraRojoMouseClicked(evt);
            }
        });
        CuraRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuraRojoActionPerformed(evt);
            }
        });
        jPanel1.add(CuraRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 910, -1, -1));

        CuraAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        CuraAzul.setBorder(null);
        CuraAzul.setContentAreaFilled(false);
        CuraAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuraAzul.setFocusPainted(false);
        CuraAzul.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul_1.png"))); // NOI18N
        CuraAzul.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul_1.png"))); // NOI18N
        CuraAzul.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        CuraAzul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuraAzulMouseClicked(evt);
            }
        });
        CuraAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuraAzulActionPerformed(evt);
            }
        });
        jPanel1.add(CuraAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 910, -1, -1));

        CuraVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        CuraVerde.setBorder(null);
        CuraVerde.setContentAreaFilled(false);
        CuraVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CuraVerde.setFocusPainted(false);
        CuraVerde.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        CuraVerde.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        CuraVerde.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        CuraVerde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuraVerdeMouseClicked(evt);
            }
        });
        CuraVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuraVerdeActionPerformed(evt);
            }
        });
        jPanel1.add(CuraVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 910, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, 400, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("0");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 940, 150, 50));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("0");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 940, 150, 50));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setText("0");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 940, 170, 50));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("0");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 940, 180, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 940, 80, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Brotes 0");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 90, 220, 60));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 930, 70, 70));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 930, 70, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Garrapata.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 340, 70, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus azul.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 260, 70, 70));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus lila.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 420, 80, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 930, 70, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Virus verde.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 180, 70, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("0");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 420, 50, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("0");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 350, 50, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("0");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 270, 50, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 190, 50, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ronda 1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 30, 220, 60));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 480, 280, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 520, 270, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 560, 280, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 600, 270, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 640, 260, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 680, 280, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 720, 280, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 760, 300, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 800, 310, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 840, 310, 20));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Finalizar Ronda.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Finalizar Ronda pulsada.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Finalizar Ronda pulsada.png"))); // NOI18N
        jButton8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Finalizar Ronda pulsada.png"))); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 900, -1, -1));

        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Guardar_Partida.png"))); // NOI18N
        jButton52.setBorder(null);
        jButton52.setContentAreaFilled(false);
        jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton52.setFocusPainted(false);
        jButton52.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton52.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton52.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 880, 240, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver juego pulsado.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 960, 240, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("Haz click en una ciudad");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 880, 280, 30));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 860, 740, 150));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mapa_mundo.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1288, 575));
        jLabel1.setMinimumSize(new java.awt.Dimension(1288, 575));
        jLabel1.setName(""); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 880, 500, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("ACCIONES RESTANTES: 4");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 920, 320, 40));

        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2040, 1030));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2039, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new PanelPrincipal());
        marco.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        
        
        contador++;

        List<Integer> numerosAleatoriosRonda = new ArrayList<>();
        numerosAleatoriosRonda = aleatorioRonda(parametrosVar[1]);
        for (int i = 0; i < numerosAleatoriosRonda.size(); i++) {

            if (ciudades.get(numerosAleatoriosRonda.get(i)).getTipo() == 0) {
                if (ciudades.get(numerosAleatoriosRonda.get(i)).getVerde() < 4) {
                    ciudades.get(numerosAleatoriosRonda.get(i)).setVerde(ciudades.get(numerosAleatoriosRonda.get(i)).getVerde() + 1);
                }
            } else if (ciudades.get(numerosAleatoriosRonda.get(i)).getTipo() == 1) {
                if (ciudades.get(numerosAleatoriosRonda.get(i)).getMorado() < 4) {
                    ciudades.get(numerosAleatoriosRonda.get(i)).setMorado(ciudades.get(numerosAleatoriosRonda.get(i)).getMorado() + 1);
                }
            } else if (ciudades.get(numerosAleatoriosRonda.get(i)).getTipo() == 2) {
                if (ciudades.get(numerosAleatoriosRonda.get(i)).getRojo() < 4) {
                    ciudades.get(numerosAleatoriosRonda.get(i)).setRojo(ciudades.get(numerosAleatoriosRonda.get(i)).getRojo() + 1);
                }
            } else if (ciudades.get(numerosAleatoriosRonda.get(i)).getTipo() == 3) {
                if (ciudades.get(numerosAleatoriosRonda.get(i)).getAzul() < 4) {
                    ciudades.get(numerosAleatoriosRonda.get(i)).setAzul(ciudades.get(numerosAleatoriosRonda.get(i)).getAzul() + 1);
                }
            }
            ciudadLog[i] = ciudades.get(numerosAleatoriosRonda.get(i)).getNombre();

        }
        jLabel2.setText("Ronda " + contador);

        jLabel22.setText(ciudadLog[0]);
        jLabel23.setText(ciudadLog[1]);
        jLabel24.setText(ciudadLog[2]);
        jLabel25.setText(ciudadLog[3]);
        jLabel26.setText(ciudadLog[4]);
        jLabel27.setText(ciudadLog[5]);
        jLabel28.setText(ciudadLog[6]);
        jLabel29.setText(ciudadLog[7]);
        jLabel30.setText(ciudadLog[8]);
        jLabel31.setText(ciudadLog[9]);
acciones=4;
jLabel16.setText("Acciones:"+acciones);
        for (int i = 0; i < 48; i++) {

            if (ciudades.get(i).getVerde() == 4) {

                brotes++;

                if (ciudades.get(i).getNumColin() == 1) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 2) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 3) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 4) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 5) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(4)) && ciudades.get(j).getVerde() < 3) {

                            ciudades.get(j).setVerde(ciudades.get(j).getVerde() + 1);

                        }

                    }

                }

            } else if (ciudades.get(i).getAzul() == 4) {

                brotes++;

                if (ciudades.get(i).getNumColin() == 1) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 2) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 3) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 4) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 5) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(4)) && ciudades.get(j).getAzul() < 3) {

                            ciudades.get(j).setAzul(ciudades.get(j).getAzul() + 1);

                        }

                    }

                }

            } else if (ciudades.get(i).getRojo() == 4) {

                brotes++;

                if (ciudades.get(i).getNumColin() == 1) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 2) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 3) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 4) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 5) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(4)) && ciudades.get(j).getRojo() < 3) {

                            ciudades.get(j).setRojo(ciudades.get(j).getRojo() + 1);

                        }

                    }

                }

            } else if (ciudades.get(i).getMorado() == 4) {

                brotes++;

                if (ciudades.get(i).getNumColin() == 1) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 2) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 3) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 4) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        }

                    }

                } else if (ciudades.get(i).getNumColin() == 5) {

                    for (int j = 0; j < 48; j++) {

                        if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(0)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(1)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(2)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(3)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        } else if (ciudades.get(j).getNombre().equals(ciudades.get(i).getColindantes(4)) && ciudades.get(j).getMorado() < 3) {

                            ciudades.get(j).setMorado(ciudades.get(j).getMorado() + 1);

                        }

                    }

                }

            }

        }

        totalVerdes = 0;
        totalAzules = 0;
        totalRojos = 0;
        totalMorados = 0;

        for (int i = 0; i < 48; i++) {

            totalVerdes += ciudades.get(i).getVerde();
            totalAzules += ciudades.get(i).getAzul();
            totalRojos += ciudades.get(i).getRojo();
            totalMorados += ciudades.get(i).getMorado();

        }

        jLabel11.setText("Brotes " + brotes);
        jLabel3.setText(String.valueOf(totalVerdes));
        jLabel4.setText(String.valueOf(totalAzules));
        jLabel5.setText(String.valueOf(totalRojos));
        jLabel6.setText(String.valueOf(totalMorados));
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        
        if (totalVerdes + totalAzules + totalRojos + totalMorados >= parametrosVar[2] || brotes >= parametrosVar[3]) {
            
            jLabel35.setVisible(true);
            jLabel36.setVisible(true);
            jLabel37.setVisible(true);
            jButton52.setVisible(false);
            jButton53.setVisible(false);
            jButton8.setVisible(false);
            
            
            
        }
        
        if (porcentajeVerde == 100 && porcentajeAzul == 100 && porcentajeRojo == 100 && porcentajeMorado == 100) {
            jLabel35.setVisible(true);
            jLabel38.setVisible(true);
            jLabel39.setVisible(true);
            jButton52.setVisible(false);
            jButton53.setVisible(false);
            jButton8.setVisible(false);
            
            SumarRanking(conector(),player.getNombre());
            
        }
        
        

    }//GEN-LAST:event_jButton8MouseClicked

    private void SanFranciscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SanFranciscoActionPerformed
        jLabel13.setText("San Francisco");
        jLabel18.setText(String.valueOf(ciudades.get(0).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(0).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(0).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(0).getMorado()));
        player.setPosicion("San Francisco");
    }//GEN-LAST:event_SanFranciscoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jLabel13.setText("Chicago");
        jLabel18.setText(String.valueOf(ciudades.get(1).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(1).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(1).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(1).getMorado()));
        player.setPosicion("Chicago");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jLabel13.setText("Atlanta");
        jLabel18.setText(String.valueOf(ciudades.get(2).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(2).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(2).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(2).getMorado()));
        player.setPosicion("Atlanta");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jLabel13.setText("Montreal");
        jLabel18.setText(String.valueOf(ciudades.get(3).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(3).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(3).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(3).getMorado()));
        player.setPosicion("Montreal");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jLabel13.setText("Washington");
        jLabel18.setText(String.valueOf(ciudades.get(5).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(5).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(5).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(5).getMorado()));
        player.setPosicion("Washington");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jLabel13.setText("Londres");
        jLabel18.setText(String.valueOf(ciudades.get(6).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(6).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(6).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(6).getMorado()));
        player.setPosicion("Londres");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jLabel13.setText("Nueva York");
        jLabel18.setText(String.valueOf(ciudades.get(4).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(4).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(4).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(4).getMorado()));
        player.setPosicion("Nueva York");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jLabel13.setText("Madrid");
        jLabel18.setText(String.valueOf(ciudades.get(7).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(7).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(7).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(7).getMorado()));
        player.setPosicion("Madrid");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jLabel13.setText("Paris");
        jLabel18.setText(String.valueOf(ciudades.get(8).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(8).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(8).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(8).getMorado()));
        player.setPosicion("Paris");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jLabel13.setText("Essen");
        jLabel18.setText(String.valueOf(ciudades.get(9).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(9).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(9).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(9).getMorado()));
        player.setPosicion("Essen");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jLabel13.setText("Milan");
        jLabel18.setText(String.valueOf(ciudades.get(10).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(10).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(10).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(10).getMorado()));
        player.setPosicion("Milan");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        jLabel13.setText("San Petersburgo");
        jLabel18.setText(String.valueOf(ciudades.get(11).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(11).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(11).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(11).getMorado()));
        player.setPosicion("San Petersburgo");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jLabel13.setText("Los Angeles");
        jLabel18.setText(String.valueOf(ciudades.get(12).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(12).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(12).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(12).getMorado()));
        player.setPosicion("Los Angeles");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jLabel13.setText("Miami");
        jLabel18.setText(String.valueOf(ciudades.get(13).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(13).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(13).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(13).getMorado()));
        player.setPosicion("Miami");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        jLabel13.setText("Mexico DF");
        jLabel18.setText(String.valueOf(ciudades.get(14).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(14).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(14).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(14).getMorado()));
        player.setPosicion("Mexico DF");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        jLabel13.setText("Bogota");
        jLabel18.setText(String.valueOf(ciudades.get(15).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(15).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(15).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(15).getMorado()));
        player.setPosicion("Bogota");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jLabel13.setText("Lima");
        jLabel18.setText(String.valueOf(ciudades.get(16).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(16).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(16).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(16).getMorado()));
        player.setPosicion("Lima");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        jLabel13.setText("Santiago de Chile");
        jLabel18.setText(String.valueOf(ciudades.get(17).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(17).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(17).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(17).getMorado()));
        player.setPosicion("Santiago de Chile");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jLabel13.setText("Buenos Aires");
        jLabel18.setText(String.valueOf(ciudades.get(18).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(18).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(18).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(18).getMorado()));
        player.setPosicion("Buenos Aires");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jLabel13.setText("Sao Paulo");
        jLabel18.setText(String.valueOf(ciudades.get(19).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(19).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(19).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(19).getMorado()));
        player.setPosicion("Sao Paulo");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        jLabel13.setText("Lagos");
        jLabel18.setText(String.valueOf(ciudades.get(20).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(20).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(20).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(20).getMorado()));
        player.setPosicion("Lagos");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        jLabel13.setText("Kinsasa");
        jLabel18.setText(String.valueOf(ciudades.get(21).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(21).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(21).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(21).getMorado()));
        player.setPosicion("Kinsasa");
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        jLabel13.setText("Jartum");
        jLabel18.setText(String.valueOf(ciudades.get(22).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(22).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(22).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(22).getMorado()));
        player.setPosicion("Jartum");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        jLabel13.setText("Johannesburgo");
        jLabel18.setText(String.valueOf(ciudades.get(23).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(23).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(23).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(23).getMorado()));
        player.setPosicion("Johannesburgo");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jLabel13.setText("Argel");
        jLabel18.setText(String.valueOf(ciudades.get(24).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(24).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(24).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(24).getMorado()));
        player.setPosicion("Argel");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jLabel13.setText("El Cairo");
        jLabel18.setText(String.valueOf(ciudades.get(25).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(25).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(25).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(25).getMorado()));
        player.setPosicion("El Cairo");
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        jLabel13.setText("Riad");
        jLabel18.setText(String.valueOf(ciudades.get(26).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(26).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(26).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(26).getMorado()));
        player.setPosicion("Riad");
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jLabel13.setText("Estambul");
        jLabel18.setText(String.valueOf(ciudades.get(27).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(27).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(27).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(27).getMorado()));
        player.setPosicion("Estambul");
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        jLabel13.setText("Bagdad");
        jLabel18.setText(String.valueOf(ciudades.get(28).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(28).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(28).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(28).getMorado()));
        player.setPosicion("Bagdad");
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        jLabel13.setText("Moscu");
        jLabel18.setText(String.valueOf(ciudades.get(29).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(29).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(29).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(29).getMorado()));
        player.setPosicion("Moscu");
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        jLabel13.setText("Teheran");
        jLabel18.setText(String.valueOf(ciudades.get(30).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(30).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(30).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(30).getMorado()));
        player.setPosicion("Teheran");
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        jLabel13.setText("Karachi");
        jLabel18.setText(String.valueOf(ciudades.get(31).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(31).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(31).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(31).getMorado()));
        player.setPosicion("Karachi");
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        jLabel13.setText("Bombay");
        jLabel18.setText(String.valueOf(ciudades.get(32).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(32).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(32).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(32).getMorado()));
        player.setPosicion("Bombay");
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        jLabel13.setText("Nueva Delhi");
        jLabel18.setText(String.valueOf(ciudades.get(33).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(33).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(33).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(33).getMorado()));
        player.setPosicion("Nueva Delhi");
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        jLabel13.setText("Calcuta");
        jLabel18.setText(String.valueOf(ciudades.get(34).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(34).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(34).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(34).getMorado()));
        player.setPosicion("Calcuta");
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        jLabel13.setText("Madras");
        jLabel18.setText(String.valueOf(ciudades.get(35).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(35).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(35).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(35).getMorado()));
        player.setPosicion("Madras");
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        jLabel13.setText("Yakarta");
        jLabel18.setText(String.valueOf(ciudades.get(36).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(36).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(36).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(36).getMorado()));
        player.setPosicion("Yakarta");
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        jLabel13.setText("Bangkok");
        jLabel18.setText(String.valueOf(ciudades.get(37).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(37).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(37).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(37).getMorado()));
        player.setPosicion("Bangkok");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        jLabel13.setText("Hong Kong");
        jLabel18.setText(String.valueOf(ciudades.get(38).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(38).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(38).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(38).getMorado()));
        player.setPosicion("Hong Kong");
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        jLabel13.setText("Shanghai");
        jLabel18.setText(String.valueOf(ciudades.get(39).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(39).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(39).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(39).getMorado()));
        player.setPosicion("Shanghai");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        jLabel13.setText("Pekin");
        jLabel18.setText(String.valueOf(ciudades.get(40).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(40).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(40).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(40).getMorado()));
        player.setPosicion("Pekin");
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        jLabel13.setText("Seul");
        jLabel18.setText(String.valueOf(ciudades.get(41).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(41).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(41).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(41).getMorado()));
        player.setPosicion("Seul");
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        jLabel13.setText("Tokio");
        jLabel18.setText(String.valueOf(ciudades.get(42).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(42).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(42).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(42).getMorado()));
        player.setPosicion("Tokio");
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        jLabel13.setText("Osaka");
        jLabel18.setText(String.valueOf(ciudades.get(43).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(43).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(43).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(43).getMorado()));
        player.setPosicion("Osaka");
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        jLabel13.setText("Taipei");
        jLabel18.setText(String.valueOf(ciudades.get(44).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(44).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(44).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(44).getMorado()));
        player.setPosicion("Taipei");
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        jLabel13.setText("Ho Chi Minh");
        jLabel18.setText(String.valueOf(ciudades.get(45).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(45).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(45).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(45).getMorado()));
        player.setPosicion("Ho Chi Minh");
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        jLabel13.setText("Manila");
        jLabel18.setText(String.valueOf(ciudades.get(46).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(46).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(46).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(46).getMorado()));
        player.setPosicion("Manila");
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        jLabel13.setText("Sidney");
        jLabel18.setText(String.valueOf(ciudades.get(47).getVerde()));
        jLabel19.setText(String.valueOf(ciudades.get(47).getAzul()));
        jLabel20.setText(String.valueOf(ciudades.get(47).getRojo()));
        jLabel21.setText(String.valueOf(ciudades.get(47).getMorado()));
        player.setPosicion("Sidney");
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton54MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton54MouseClicked

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        jButton61.setVisible(true);
        jButton62.setVisible(true);
        jButton63.setVisible(true);
        jButton64.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        jLabel33.setText("Selecciona la ciudad que quieras curar y luego el virus.");
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton55MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton55MouseClicked

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        CuraRojo.setVisible(true);
        CuraMorado.setVisible(true);
        CuraVerde.setVisible(true);
        CuraAzul.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jLabel18.setText(porcentajeVerde + "%");
        jLabel19.setText(porcentajeAzul + "%");
        jLabel20.setText(porcentajeRojo + "%");
        jLabel21.setText(porcentajeMorado + "%");
                jLabel13.setText("Curas Totales");
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton53MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton53MouseClicked

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        jButton53.setVisible(false);
        jButton8.setVisible(false);
        jButton54.setVisible(true);
        jButton55.setVisible(true);
        jButton55.setVisible(true);
        jButton56.setVisible(true);
        if (acciones < 1) {
            jButton54.setEnabled(false);
        } else {
            jButton54.setEnabled(true);
        }
        if (acciones < 4) {
            jButton55.setEnabled(false);
        } else {
            jButton55.setEnabled(true);
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton61MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61MouseClicked

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        int infeccion = 0;
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
     
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);

        acciones = acciones - 1;
        jLabel33.setText("");
        for (int i = 0; i < 48; i++) {
            
            if (ciudades.get(i).getNombre().equals(player.getPosicion())) {
                
                if (porcentajeVerde == 100) {
                    totalVerdes = totalVerdes - ciudades.get(i).getVerde();
                     ciudades.get(i).setVerde(0);
                     
                } else {
                    ciudades.get(i).setVerde(ciudades.get(i).getVerde() - 1);
                    totalVerdes = totalVerdes - 1;
                }
                
                
                infeccion = ciudades.get(i).getVerde();
            }
            
        }
        

        
        
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        jLabel18.setText(String.valueOf(infeccion));
        jLabel3.setText(String.valueOf(totalVerdes));
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton62MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton62MouseClicked

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        int infeccion = 0;
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
    
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);
        acciones = acciones - 1;
        jLabel33.setText("");
        for (int i = 0; i < 48; i++) {
            
            if (ciudades.get(i).getNombre().equals(player.getPosicion())) {
                
                if (porcentajeAzul == 100) {
                    totalAzules = totalAzules - ciudades.get(i).getAzul();
                    ciudades.get(i).setAzul(0);
                } else {
                    ciudades.get(i).setAzul(ciudades.get(i).getAzul() - 1);
                    totalAzules = totalAzules - 1;
                }
                infeccion = ciudades.get(i).getAzul();
            }
            
        }
        
        
        
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        jLabel19.setText(String.valueOf(infeccion));
        jLabel4.setText(String.valueOf(totalAzules));
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton63MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton63MouseClicked

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        int infeccion = 0;
        
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
     
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);
        acciones = acciones - 1;
        jLabel33.setText("");
        for (int i = 0; i < 48; i++) {
            
            if (ciudades.get(i).getNombre().equals(player.getPosicion())) {
                
                if (porcentajeRojo == 100) {
                    totalRojos = totalRojos - ciudades.get(i).getRojo();
                     ciudades.get(i).setRojo(0);
                } else {
                    ciudades.get(i).setRojo(ciudades.get(i).getRojo() - 1);
                    totalRojos = totalRojos - 1;
                }
                infeccion = ciudades.get(i).getRojo();
            }
            
        }
        
        
        
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        jLabel20.setText(String.valueOf(infeccion));
        jLabel5.setText(String.valueOf(totalRojos));
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton64MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton64MouseClicked

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        int infeccion = 0;
        
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        
        jButton61.setVisible(false);
        jButton62.setVisible(false);
        jButton63.setVisible(false);
        jButton64.setVisible(false);
        acciones = acciones - 1;
        jLabel33.setText("");
        for (int i = 0; i < 48; i++) {
            
            if (ciudades.get(i).getNombre().equals(player.getPosicion())) {
                
                if (porcentajeMorado == 100) {
                    totalMorados = totalMorados - ciudades.get(i).getMorado();
                     ciudades.get(i).setMorado(0);
                } else {
                    ciudades.get(i).setMorado(ciudades.get(i).getMorado() - 1);
                    totalMorados = totalMorados - 1;
                }
                infeccion = ciudades.get(i).getMorado();
            }
            
        }
        
        
        
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
        jLabel21.setText(String.valueOf(infeccion));
        jLabel6.setText(String.valueOf(totalMorados));
    }//GEN-LAST:event_jButton64ActionPerformed

    private void CuraMoradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuraMoradoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CuraMoradoMouseClicked

    private void CuraMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuraMoradoActionPerformed
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        if(porcentajeMorado<100){
            porcentajeMorado = porcentajeMorado + 25;}
        jLabel21.setText(String.valueOf(porcentajeMorado) + " %");
        
        acciones=0;
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
    }//GEN-LAST:event_CuraMoradoActionPerformed

    private void CuraRojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuraRojoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CuraRojoMouseClicked

    private void CuraRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuraRojoActionPerformed
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        if (porcentajeRojo < 100) {
            porcentajeRojo = porcentajeRojo + 25;
        }

        jLabel14.setVisible(false);
        acciones=0;
        jLabel20.setText(String.valueOf(porcentajeRojo) + " %");
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
    }//GEN-LAST:event_CuraRojoActionPerformed

    private void CuraAzulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuraAzulMouseClicked
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
    }//GEN-LAST:event_CuraAzulMouseClicked

    private void CuraAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuraAzulActionPerformed
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        if (porcentajeAzul<100){
            porcentajeAzul = porcentajeAzul + 25;}
        acciones=0;
                jLabel19.setText(String.valueOf(porcentajeAzul) + " %");
                jLabel34.setText("ACCIONES RESTANTES: " + acciones);
    }//GEN-LAST:event_CuraAzulActionPerformed

    private void CuraVerdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuraVerdeMouseClicked
        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
    }//GEN-LAST:event_CuraVerdeMouseClicked

    private void CuraVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuraVerdeActionPerformed

        jButton53.setVisible(true);
        jButton8.setVisible(true);
        jButton54.setVisible(false);
        jButton55.setVisible(false);
        jButton55.setVisible(false);
        jButton56.setVisible(false);
        CuraRojo.setVisible(false);
        CuraMorado.setVisible(false);
        CuraVerde.setVisible(false);
        CuraAzul.setVisible(false);
        if(porcentajeVerde<100){
            porcentajeVerde = porcentajeVerde + 25;
        }
        jLabel18.setText(String.valueOf(porcentajeVerde) + " %");
        acciones=0;
        jLabel34.setText("ACCIONES RESTANTES: " + acciones);
    }//GEN-LAST:event_CuraVerdeActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        
        BaseDatos.insertWithStatement(BaseDatos.conector(), parametrosVar[0], parametrosVar[1], parametrosVar[2], parametrosVar[3], ciudades);
        
    }//GEN-LAST:event_jButton52ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CuraAzul;
    public javax.swing.JButton CuraMorado;
    public javax.swing.JButton CuraRojo;
    public javax.swing.JButton CuraVerde;
    private javax.swing.JButton SanFrancisco;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    public javax.swing.JButton jButton53;
    public javax.swing.JButton jButton54;
    public javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton6;
    public javax.swing.JButton jButton61;
    public javax.swing.JButton jButton62;
    public javax.swing.JButton jButton63;
    public javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
