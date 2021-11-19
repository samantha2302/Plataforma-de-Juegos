package Impiccato;

import Archivos.DataImpicccato;
import static VentanaPrincipal.VentanaPrincipal.escritorio;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author Katherine
 */
public class DatosFinalesImpiccato extends javax.swing.JInternalFrame {
    JLabel etiqueta,nomJugador,fecha,horaInicio,tiempoFinal,puntajeFinal,horafinal;
    int hora,minutos,segundos;

    public DatosFinalesImpiccato() {
        initComponents();
        datosPanel();
        creaHora();
        this.setClosable(true); //Sirve para cerrar la ventana.  
    }
    
    private void guardarDatos(){
        String nombre1 = nomJugador.getText();
        int puntaje1 = Integer.parseInt(puntajeFinal.getText());

        DataImpicccato datosImpicccato = new DataImpicccato();
        datosImpicccato.comprobarArchivo();
        datosImpicccato.usuario(nombre1, puntaje1);
 
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDatos = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        bntVolverJugar = new javax.swing.JButton();

        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Jugador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Comic Sans MS", 0, 18))); // NOI18N

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        btnAceptar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        bntVolverJugar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bntVolverJugar.setText("Jugar de nuevo");
        bntVolverJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVolverJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnAceptar)
                        .addGap(40, 40, 40)
                        .addComponent(bntVolverJugar)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(PanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(bntVolverJugar))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //PARA AGREGAR EN ARCHIVOS
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.setVisible(false);
        guardarDatos();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void bntVolverJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVolverJugarActionPerformed
        this.setVisible(false);
        PrincipalImpiccato ahorcado=new PrincipalImpiccato();
        escritorio.add(ahorcado);
        ahorcado.setVisible(true);
        ahorcado.setLocation(210,35);
    }//GEN-LAST:event_bntVolverJugarActionPerformed

    private void creaHora(){ 
      Calendar calendario = new GregorianCalendar();
      hora= calendario.get(Calendar.HOUR_OF_DAY);
      minutos = calendario.get(Calendar.MINUTE);
      segundos = calendario.get(Calendar.SECOND);
      horafinal.setText(hora + ":" + minutos + ":" + segundos);   
    } 
    
    private void datosPanel(){
        
        //NOMBRE
        etiqueta = new JLabel("Nombre: ");
        etiqueta.setBounds(10,30,150,30);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        nomJugador = new JLabel();
        nomJugador.setBounds(95,30,150,30);
        nomJugador.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(nomJugador);
        
        //FECHA
        etiqueta = new JLabel("Fecha: ");
        etiqueta.setBounds(10,50,150,50);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        fecha = new JLabel();
        fecha.setBounds(80,50,150,50);
        fecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(fecha);
        
        //HORA INICIO
        etiqueta = new JLabel("Hora Inicio: ");
        etiqueta.setBounds(10,70,150,70);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        horaInicio = new JLabel();
        horaInicio.setBounds(125,70,200,70);
        horaInicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(horaInicio);
        
        //HORA FINAL
        etiqueta = new JLabel("Hora Final: ");
        etiqueta.setBounds(10,90,150,90);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        horafinal = new JLabel();
        horafinal.setBounds(115,90,200,90);
        horafinal.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(horafinal);
        
        //CRONOMETRO
        etiqueta = new JLabel("Tiempo: ");
        etiqueta.setBounds(10,110,150,110);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        tiempoFinal = new JLabel();
        tiempoFinal.setBounds(90,110,200,110);
        tiempoFinal.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(tiempoFinal);
        
        //PUNTAJE FINAL
        etiqueta = new JLabel("Puntaje Final: ");
        etiqueta.setBounds(10,130,150,130);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(etiqueta);
        
        puntajeFinal = new JLabel();
        puntajeFinal.setBounds(135,130,200,130);
        puntajeFinal.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        PanelDatos.add(puntajeFinal);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JButton bntVolverJugar;
    private javax.swing.JButton btnAceptar;
    // End of variables declaration//GEN-END:variables
}
