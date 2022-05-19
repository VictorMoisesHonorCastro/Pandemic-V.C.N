package Vista;


import Controlador.Parametros_Funcion;
import Vista.Nueva_Partida;
import Vista.PanelPrincipal;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Parametros extends javax.swing.JPanel {
    public static String usuario;
    public Parametros() {
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Nombre de Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, 220, 30));

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jToggleButton1.setText("Normal");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, 170, -1));

        jToggleButton4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jToggleButton4.setText("Dificil");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 650, 170, -1));

        jToggleButton5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jToggleButton5.setText("Facil");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 380, 170, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Confirmar.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Confirmar Pulsado.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Confirmar Pulsado.png"))); // NOI18N
        jButton8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Confirmar Pulsado.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 860, 390, 120));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 72)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nueva Partida");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver 85.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver Pulsado 85.png"))); // NOI18N
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver Pulsado 85.png"))); // NOI18N
        jButton7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Volver Pulsado 85.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 860, 390, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/planeta-Tierra.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ArrayList<Integer> parametros = new ArrayList<>();
        int infecciones_inicio=0;
        int infecciones_ronda=0;
        int enfermedades_muerte=0;
        int brotes_muerte=0;
        int dificultad = 0;

        if (!jToggleButton4.isSelected() && !jToggleButton4.isSelected() && !jToggleButton1.isSelected()) {
            jToggleButton1.setSelected(true);
        }
        if (jToggleButton1.isSelected()) {
            dificultad = 2;
        }
        if (jToggleButton4.isSelected()) {
            dificultad = 3;
        }
        if (jToggleButton5.isSelected()) {
            dificultad = 1;
        }
                
        
        Parametros_Funcion parametrosfuncion = new Parametros_Funcion(dificultad);
        parametros = parametrosfuncion.leer_xml();
         
            infecciones_inicio=parametros.get(0); 
            infecciones_ronda=parametros.get(1);
            enfermedades_muerte=parametros.get(2);
            brotes_muerte=parametros.get(3);
            
    
        Nueva_Partida parametrosPartida = new Nueva_Partida(infecciones_inicio, infecciones_ronda, enfermedades_muerte, brotes_muerte,0);
        usuario = jTextField1.getText();

        
        JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
        marco.remove(this);
        marco.add(new Nueva_Partida(infecciones_inicio, infecciones_ronda, enfermedades_muerte, brotes_muerte,0));
        marco.setVisible(true);    }//GEN-LAST:event_jButton8ActionPerformed


    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        jToggleButton1.setSelected(false);
        jToggleButton5.setSelected(false);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        jToggleButton4.setSelected(false);
        jToggleButton1.setSelected(false);
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    // End of variables declaration//GEN-END:variables
}
