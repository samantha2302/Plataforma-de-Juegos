package Culebrita;

import static VentanaPrincipal.VentanaPrincipal.escritorio;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class Culebrita extends javax.swing.JInternalFrame {
    
    PanelCulebrita panel;
    
    private static Culebrita culebrita;
    
    private Culebrita() {
        initComponents();
        this.setClosable(true);
        
        panel = new PanelCulebrita(400, 30);
        this.add(panel);
        panel.setBounds(10, 10, 400, 400);
        panel.setOpaque(false);
        
        PanelFondo fondo = new PanelFondo(400, 30);
        this.add(fondo);
        fondo.setBounds(10, 10, 400, 400);
        
        this.requestFocus(true);

    }
    public static Culebrita Singleton(){
        if(culebrita == null){
            culebrita = new Culebrita();
        }
        return culebrita;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bntAbajo = new javax.swing.JButton();
        bntIzquierda = new javax.swing.JButton();
        bntArriba = new javax.swing.JButton();
        bntDerecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelPuntaje = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setOpaque(false);

        bntAbajo.setBackground(new java.awt.Color(153, 153, 153));
        bntAbajo.setFont(new java.awt.Font("Comic Sans MS", 3, 8)); // NOI18N
        bntAbajo.setForeground(new java.awt.Color(0, 0, 0));
        bntAbajo.setText("DOWN");
        bntAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAbajoActionPerformed(evt);
            }
        });

        bntIzquierda.setBackground(new java.awt.Color(153, 153, 153));
        bntIzquierda.setFont(new java.awt.Font("Comic Sans MS", 3, 8)); // NOI18N
        bntIzquierda.setForeground(new java.awt.Color(0, 0, 0));
        bntIzquierda.setText("LEFT");
        bntIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIzquierdaActionPerformed(evt);
            }
        });

        bntArriba.setBackground(new java.awt.Color(153, 153, 153));
        bntArriba.setFont(new java.awt.Font("Comic Sans MS", 3, 8)); // NOI18N
        bntArriba.setForeground(new java.awt.Color(0, 0, 0));
        bntArriba.setText("UP");
        bntArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntArribaActionPerformed(evt);
            }
        });

        bntDerecha.setBackground(new java.awt.Color(153, 153, 153));
        bntDerecha.setFont(new java.awt.Font("Comic Sans MS", 3, 8)); // NOI18N
        bntDerecha.setForeground(new java.awt.Color(0, 0, 0));
        bntDerecha.setText("RIGHT");
        bntDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDerechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(bntIzquierda))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bntArriba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntAbajo)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bntDerecha)
                .addGap(30, 30, 30))
        );

        jLabelPuntaje.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabelPuntaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntaje.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setText("Puntaje =");

        jButton1.setText("Terminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(372, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelPuntaje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIzquierdaActionPerformed
        panel.cambiarDireccion("iz");
    }//GEN-LAST:event_bntIzquierdaActionPerformed

    private void bntAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAbajoActionPerformed
        panel.cambiarDireccion("ab");
    }//GEN-LAST:event_bntAbajoActionPerformed

    private void bntArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntArribaActionPerformed
        panel.cambiarDireccion("ar");
    }//GEN-LAST:event_bntArribaActionPerformed

    private void bntDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDerechaActionPerformed
        panel.cambiarDireccion("de");
    }//GEN-LAST:event_bntDerechaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (JOptionPane.showConfirmDialog(rootPane, "¿Quieres terminar la partida?",
                "Terminar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            {
            DatosFinalesCulebrita data=DatosFinalesCulebrita.Singleton();
            escritorio.add(data);
            data.setVisible(true);
            data.setLocation(245,70);
            this.setVisible(false);
            }
        else{
               this.setVisible(true);
            } 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAbajo;
    private javax.swing.JButton bntArriba;
    private javax.swing.JButton bntDerecha;
    private javax.swing.JButton bntIzquierda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabelPuntaje;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
