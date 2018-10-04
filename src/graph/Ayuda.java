/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.InputStream;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class Ayuda extends javax.swing.JFrame {

    private Font font;
    
    public Ayuda() {
        initComponents();
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("files/help.png")));
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        font = defaultFont();
        lbInstrucciones.setFont(font);
    }
    
    private Font defaultFont(){
        String fontName = "files/Pony.ttf";
        Font font;
        try {
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(1, 36);
        } catch (Exception ex) {
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        return font;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbInstrucciones = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(37, 60, 120));

        lbInstrucciones.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbInstrucciones.setForeground(new java.awt.Color(181, 226, 250));
        lbInstrucciones.setText("Instrucciones");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n○ Para poner una ciudad, solo haz clic en la pantalla e ingresa el nombre de esta.\n\n○ Si quieres crear un camino entre dos ciudades, selecciona una con clic izquierdo,\n   arrastra el cursor y suéltalo en la ciudad de destino.\n\n○ Si seleccionas una ciudad con clic izquierdo, otra con clic derecho y presionas\n   \"Calcular camino\", aparecerá el camino entre estas dos ciudades que menos te\n   costará, además de el costo en bits.\n\n○ Para quitar una ciudad, selecciónala con clic izquierdo y presiona la tecla SUPRIMIR.\n\n○ El comando CTRL + F ejecutará el algoritmo Floyd-Warshall sobre el grafo.\n\n○ En el menú \"Grafo\" hay opciones útiles como generar un mapa con ciudades importantes\n   de Equestria, crear uno nuevo, eliminar una ciudad, etc.\n\n");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294)
                        .addComponent(jLabel2))
                    .addComponent(lbInstrucciones)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbInstrucciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbInstrucciones;
    // End of variables declaration//GEN-END:variables
}
