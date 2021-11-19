package Impiccato;

import static VentanaPrincipal.VentanaPrincipal.escritorio;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Katherine
 */
public class InicioImpiccato extends javax.swing.JInternalFrame {
    JLabel etiqueta,etique,nombreJugador,cronometro,lblfecha,agregarHora;
    int hora,minutos,segundos;
    Timer tiempo;
    int consegund,seg,min;
    public ImageIcon imgs[];
    public JButton btns[];
    public String msgs[];
    public int ran;
    public int err;
    public int err2;
    public String res[];

    public InicioImpiccato() {
        initComponents();
        datosPanel();
        lblfecha.setText(crearFecha());
        creaHora();
        crearTiempo();  
        this.setClosable(true); // Sirve para cerrar la ventana.

        imgs = new ImageIcon[12];
        btns = new JButton[28];
        msgs = new String[20];
        
         // Imagen del joven que se va a ahorcar por que ella no lo ama xd xd
        imgs[0] = new ImageIcon(getClass().getResource("/imagenes/im1.jpg"));
        imgs[1] = new ImageIcon(getClass().getResource("/imagenes/im2.jpg"));
        imgs[2] = new ImageIcon(getClass().getResource("/imagenes/im3.jpg"));
        imgs[3] = new ImageIcon(getClass().getResource("/imagenes/im4.jpg"));
        imgs[4] = new ImageIcon(getClass().getResource("/imagenes/im5.jpg"));
        imgs[5] = new ImageIcon(getClass().getResource("/imagenes/im6.jpg"));

        
        imgs[6] = new ImageIcon(getClass().getResource("/imagenes/fallo0.png"));
        imgs[7] = new ImageIcon(getClass().getResource("/imagenes/fallo1.png"));
        imgs[8] = new ImageIcon(getClass().getResource("/imagenes/fallo2.png"));
        imgs[9] = new ImageIcon(getClass().getResource("/imagenes/fallo3.png"));
        imgs[10] = new ImageIcon(getClass().getResource("/imagenes/fallo4.png"));
        imgs[11] = new ImageIcon(getClass().getResource("/imagenes/fallo5.png"));
        
        // Botones para las letras
        btns[1]=btnA;
        btns[2]=btnB;
        btns[3]=btnC;
        btns[4]=btnD;
        btns[5]=btnE;
        btns[6]=btnF;
        btns[7]=btnG;
        btns[8]=btnH;
        btns[9]=btnI;
        btns[10]=btnJ;
        btns[11]=btnK;
        btns[12]=btnL;
        btns[13]=btnM;
        btns[14]=btnN;
        btns[27]=btnÑ;
        btns[15]=btnO;
        btns[16]=btnP;
        btns[17]=btnQ;
        btns[18]=btnR;
        btns[19]=btnS;
        btns[20]=btnT;
        btns[21]=btnU;
        btns[22]=btnV;
        btns[23]=btnW;
        btns[24]=btnX;
        btns[25]=btnY;
        btns[26]=btnZ;

        // Palabras por advinar, para agregar una nueva palabra sera necesario declararla al inicio
        msgs[0] = "Viejo".toUpperCase();
        msgs[1] = "Costa Rica".toUpperCase();
        msgs[2] = "Tecnologico".toUpperCase();
        msgs[3] = "Java".toUpperCase();
        msgs[4] = "San Carlos".toUpperCase();
        msgs[5] = "Programacion".toUpperCase();
        msgs[6] = "Informatica".toUpperCase();
        msgs[7] = "Samantha".toUpperCase();
        msgs[8] = "Fibonacci".toUpperCase();
        msgs[9] = "Otorrinolaringologo".toUpperCase();
        msgs[10] = "Otorrinolaringologo".toUpperCase();
        msgs[11] = "Estudiante".toUpperCase();
        msgs[12] = "Ovoviviparo".toUpperCase();
        msgs[13] = "Futbol".toUpperCase();
        msgs[14] = "oso".toUpperCase();
        msgs[15] = "transformacion".toUpperCase();
        msgs[16] = "Software".toUpperCase();
        msgs[17] = "Desarrollo".toUpperCase();
        msgs[18] = "Computacion".toUpperCase();
        msgs[19] = "Audifonos".toUpperCase();
        
        // Se asigna un evento a cada letra para comprobar que exista en la palabra a adivinar
        for (int i = 1; i < 28; i++) {
            btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    checarLetra(e);
                }
            });
        }
        iniciar();
    }
    
    
        // Funcion para comenzar los parametros del juego o iniciar una nueva partida
    public void iniciar() {
        // ERRORES EN 0
        contadorJugadas.setText(Integer.toString(Integer.parseInt(contadorJugadas.getText())-1));
        jugadas();
        err = 0;
        err2=6;
        labelImagen.setIcon(imgs[0]);
        labelPalabra.setText("");
        labelError.setIcon(imgs[6]);//:___________________________________----
        // Para activar las letras del tablero
        for (int i = 1; i < 28; i++) {
            btns[i].setEnabled(true);
        }
        // Para generar una palabra aleatoriamente xD
        ran = (int) 0 + (int) (Math.random() * ((msgs.length - 1) + 1));
        // SEPARA EL MENSAJE POR PALABRAS
        String pal[] = msgs[ran].split(" ");
        res = new String[msgs[ran].length() + 1];
        int j = 0;
        // Seran los guiones que van debajo de las letras como una separacion_
        for (String pal1 : pal) {
            for (int i = 0; i < pal1.length(); i++) {
                labelPalabra.setText(labelPalabra.getText() + "_ ");
                res[j++] = "_";
            }
            labelPalabra.setText(labelPalabra.getText() + "\n");
            res[j++] = " ";
        }
        
    }
    
    // Al presionar una letra, esta se buscara si pertenece a la palabra, de lo contrario la marcara como error 
    public void checarLetra(ActionEvent e) {
        Icon cp=new ImageIcon(getClass().getResource("/imagenes/copa.png"));// Icono de la copa
        Icon cara=new ImageIcon(getClass().getResource("/imagenes/cara.png"));// Icono de la copa
        JButton bt = (JButton) e.getSource();
        char c[];
        // Busca la letra en la palabra despues de haber sido presionada
        for (int i = 1; i < 28; i++) {
            if (bt == btns[i]) {
                // La tecla es inicializada
                c = Character.toChars(64 + i);
                // Busca si la letra esta en la frase
                boolean esta = false;
                for (int j = 0; j < msgs[ran].length(); j++) {
                    if (c[0] == msgs[ran].charAt(j)) {
                        res[j] = c[0] + "";
                        esta = true;
                    }
                }
                // SI LA LETRA ESTA EN EL MENSAJE SE MUESTRA EN EL TEXTPANEL
                if (esta) {
                    labelPalabra.setText("");
                    for (String re : res) {
                        if (" ".equals(re)) {
                            labelPalabra.setText(labelPalabra.getText() + "\n");
                        } else {
                            labelPalabra.setText(labelPalabra.getText() + re + " ");
                        }
                    }
                    // Hace una comprobacion de las letras restantes y faltantes, en caso de que ya no haya letras sera ganador :D
                    boolean gano = true;
                    for (String re : res) {
                        if (re.equals("_")) {
                            gano = false;
                            break;
                        }
                    }
                    // Al ser correcta se muestra un mensaje y se reinicia el juego
                    
                    if (gano) {
                        JOptionPane.showMessageDialog(this, "¡FELICIDADES!\n Ganaste 10 puntos", "Impiccato",JOptionPane.INFORMATION_MESSAGE, cp);
                        labelPuntaje.setText(Integer.toString(Integer.parseInt(labelPuntaje.getText())+10));
                        iniciar();
                        return;
                    }
                    // SI LA LETRA NO ESTA EN EL MENSAGE, SE INCREMENTA EL ERROR Y SE CAMBIA LA IMAGEN
                } else {
                    labelImagen.setIcon(imgs[++err]);
                    labelError.setIcon(imgs[++err2]);//////////////////////////////////////_----
                    // SI SE LLEGA A LOS 5 ERRORES ENTONCES SE PIERDE EL JUEGO Y SE MANDA EL MENSAGE DE:
                    if (err == 5) {
                        JOptionPane.showMessageDialog(this, "¡PALABRA INCORRECTA!\nPerdiste 5 puntos\nLa respuesta es: " + msgs[ran], "Impiccato",JOptionPane.INFORMATION_MESSAGE, cara);
                        iniciar();
                        return;
                    }
                }
                // Esta es la linea que desactiva las letras despues de ser usadas :3
                bt.setEnabled(false);
                break;
            }
        }

    }
    
    private void jugadas(){
        if("0".equals(contadorJugadas.getText())){
            if (JOptionPane.showConfirmDialog(rootPane, "Sin vidas.¿Quieres ver tu puntaje final?",
                "Partidas Finalizadas", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            
            {
             this.setVisible(false);
             tiempo.stop();
             DatosFinalesImpiccato data=new DatosFinalesImpiccato();
             data.nomJugador.setText(nombreJugador.getText());
             data.fecha.setText(lblfecha.getText());
             data.horaInicio.setText(agregarHora.getText());
             data.tiempoFinal.setText(cronometro.getText());
             data.puntajeFinal.setText(labelPuntaje.getText());
             escritorio.add(data);
             data.setVisible(true);
             data.setLocation(260,100);
            }
            else{
               this.setVisible(false);
            }
        
        }
    }

//COMPONENTES DE LA VENTANA  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        datos = new javax.swing.JPanel();
        PanelTeclado = new javax.swing.JPanel();
        btnW = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnÑ = new javax.swing.JButton();
        btnZ = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        panelOpciones = new javax.swing.JPanel();
        btnCambiarPalabra = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        panelPalabra = new javax.swing.JPanel();
        panelPalabraOculta = new javax.swing.JPanel();
        labelPalabra = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelError = new javax.swing.JLabel();
        panelPuntaje = new javax.swing.JPanel();
        labelPuntaje = new javax.swing.JLabel();
        panelImagen = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        panelJugadas = new javax.swing.JPanel();
        contadorJugadas = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setPreferredSize(new java.awt.Dimension(627, 650));

        datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Jugador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout datosLayout = new javax.swing.GroupLayout(datos);
        datos.setLayout(datosLayout);
        datosLayout.setHorizontalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        datosLayout.setVerticalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        PanelTeclado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teclado ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btnW.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnW.setText("W");

        btnQ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnQ.setText("Q");

        btnE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnE.setText("E");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnR.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnR.setText("R");
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnT.setText("T");

        btnY.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnY.setText("Y");

        btnU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnU.setText("U");

        btnI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnI.setText("I");

        btnO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnO.setText("O");

        btnP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnP.setText("P");

        btnA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnA.setText("A");

        btnS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnS.setText("S");

        btnD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnD.setText("D");

        btnF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnF.setText("F");

        btnG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnG.setText("G");

        btnH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnH.setText("H");

        btnJ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnJ.setText("J");

        btnK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnK.setText("K");

        btnL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnL.setText("L");

        btnÑ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnÑ.setText("Ñ");

        btnZ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnZ.setText("Z");

        btnX.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnX.setText("X");

        btnC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnC.setText("C");

        btnV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnV.setText("V");

        btnB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnB.setText("B");

        btnN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnN.setText("N");

        btnM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnM.setText("M");
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTecladoLayout = new javax.swing.GroupLayout(PanelTeclado);
        PanelTeclado.setLayout(PanelTecladoLayout);
        PanelTecladoLayout.setHorizontalGroup(
            PanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTecladoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnW)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnP))
            .addGroup(PanelTecladoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnL))
            .addGroup(PanelTecladoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnÑ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnM))
        );
        PanelTecladoLayout.setVerticalGroup(
            PanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTecladoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnW)
                    .addComponent(btnQ)
                    .addComponent(btnE)
                    .addComponent(btnR)
                    .addComponent(btnT)
                    .addComponent(btnY)
                    .addComponent(btnU)
                    .addComponent(btnI)
                    .addComponent(btnO)
                    .addComponent(btnP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA)
                    .addComponent(btnS)
                    .addComponent(btnD)
                    .addComponent(btnF)
                    .addComponent(btnG)
                    .addComponent(btnH)
                    .addComponent(btnJ)
                    .addComponent(btnK)
                    .addComponent(btnL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZ)
                    .addComponent(btnX)
                    .addComponent(btnC)
                    .addComponent(btnV)
                    .addComponent(btnB)
                    .addComponent(btnN)
                    .addComponent(btnM)
                    .addComponent(btnÑ)))
        );

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btnCambiarPalabra.setText("Cambiar");
        btnCambiarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPalabraActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnPause.setText("Pausar");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambiarPalabra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContinuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPalabraOculta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Palabra a encontrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        labelPalabra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelPalabraOcultaLayout = new javax.swing.GroupLayout(panelPalabraOculta);
        panelPalabraOculta.setLayout(panelPalabraOcultaLayout);
        panelPalabraOcultaLayout.setHorizontalGroup(
            panelPalabraOcultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabraOcultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPalabraOcultaLayout.setVerticalGroup(
            panelPalabraOcultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabraOcultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        labelError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        panelPuntaje.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Puntaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        labelPuntaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPuntaje.setText("0");

        javax.swing.GroupLayout panelPuntajeLayout = new javax.swing.GroupLayout(panelPuntaje);
        panelPuntaje.setLayout(panelPuntajeLayout);
        panelPuntajeLayout.setHorizontalGroup(
            panelPuntajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPuntajeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPuntajeLayout.setVerticalGroup(
            panelPuntajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPuntajeLayout.createSequentialGroup()
                .addComponent(labelPuntaje, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPalabraLayout = new javax.swing.GroupLayout(panelPalabra);
        panelPalabra.setLayout(panelPalabraLayout);
        panelPalabraLayout.setHorizontalGroup(
            panelPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPuntaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPalabraLayout.createSequentialGroup()
                        .addComponent(panelPalabraOculta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPalabraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPalabraLayout.setVerticalGroup(
            panelPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPalabraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPalabraOculta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dibujo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelJugadas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugadas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        contadorJugadas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        contadorJugadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contadorJugadas.setText("6");

        javax.swing.GroupLayout panelJugadasLayout = new javax.swing.GroupLayout(panelJugadas);
        panelJugadas.setLayout(panelJugadasLayout);
        panelJugadasLayout.setHorizontalGroup(
            panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJugadasLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(contadorJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelJugadasLayout.setVerticalGroup(
            panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contadorJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed

    }//GEN-LAST:event_btnEActionPerformed

    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRActionPerformed

    }//GEN-LAST:event_btnRActionPerformed

    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMActionPerformed

    }//GEN-LAST:event_btnMActionPerformed

    private void btnCambiarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPalabraActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Quieres cambiar de palabra?\nSe quitara un punto, si cambias",
                "Impiccato", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            
        {
            contadorJugadas.setText(Integer.toString(Integer.parseInt(contadorJugadas.getText())+1));
            iniciar();
        }
        else{
            setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_btnCambiarPalabraActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        PanelTeclado.setVisible(false);
        tiempo.stop();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        PanelTeclado.setVisible(true);
        tiempo.start();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Quieres terminar la partida?",
                "Terminar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
            {
             this.setVisible(false);
             tiempo.stop();
             DatosFinalesImpiccato data=new DatosFinalesImpiccato();
             data.nomJugador.setText(nombreJugador.getText());
             data.fecha.setText(lblfecha.getText());
             data.horaInicio.setText(agregarHora.getText());
             data.tiempoFinal.setText(cronometro.getText());
             data.puntajeFinal.setText(labelPuntaje.getText());
             escritorio.add(data);
             data.setVisible(true);
             data.setLocation(260,100);
            }
        else{
               this.setVisible(true);
            }   
    }//GEN-LAST:event_btnTerminarActionPerformed

    //METODOS PARA OBTENER LA HORA,FECHA Y EL TIEMPO       
    private void creaHora(){ 
      Calendar calendario = new GregorianCalendar();
      hora= calendario.get(Calendar.HOUR_OF_DAY);
      minutos = calendario.get(Calendar.MINUTE);
      segundos = calendario.get(Calendar.SECOND);
      agregarHora.setText(hora + ":" + minutos + ":" + segundos);   
    } 
    private String crearFecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
        
    }
    private void crearTiempo(){
        seg = 0;
        min = 0; 
        tiempo = new Timer (1000, new ActionListener()
        {
          
            public void actionPerformed(ActionEvent e) 
            {
                
                seg++;
                if(seg == 60){
                    min++;
                    seg=0;
                }
                
            // Declaramos en una variable cronometro el tiempo que transcurre
            cronometro.setText(min+":"+seg); 
            }});
    }
    //AGREGAR DATOS EN EL PANEL       
    private void datosPanel(){
        
        // NOMBRE
        etiqueta = new JLabel("Nombre del jugador: ");
        etiqueta.setBounds(10,20,150,20);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(etiqueta);
        
        nombreJugador = new JLabel();
        nombreJugador.setBounds(155,20,150,20);
        nombreJugador.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(nombreJugador);
        
        // FECHA
        etiqueta = new JLabel("Fecha: ");
        etiqueta.setBounds(10,35,150,35);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(etiqueta);
        
        lblfecha = new JLabel();
        lblfecha.setBounds(58,35,150,35);
        lblfecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(lblfecha);
        
        // HORA INICIO
        etiqueta = new JLabel("Hora inicio: ");
        etiqueta.setBounds(280,20,200,20);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(etiqueta);
        
        agregarHora = new JLabel();
        agregarHora.setBounds(365,20,200,20);
        agregarHora.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(agregarHora);
        
        // CRONOMETRO
        etiqueta = new JLabel("Tiempo: ");
        etiqueta.setBounds(280,35,200,35);
        etiqueta.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(etiqueta);
        
        cronometro = new JLabel();
        cronometro.setBounds(335,35,200,35);
        cronometro.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        datos.add(cronometro);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTeclado;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCambiarPalabra;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnH;
    private javax.swing.JButton btnI;
    private javax.swing.JButton btnJ;
    private javax.swing.JButton btnK;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnO;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnU;
    private javax.swing.JButton btnV;
    private javax.swing.JButton btnW;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnY;
    private javax.swing.JButton btnZ;
    private javax.swing.JButton btnÑ;
    private javax.swing.JLabel contadorJugadas;
    private javax.swing.JPanel datos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelPalabra;
    private javax.swing.JLabel labelPuntaje;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelJugadas;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPalabra;
    private javax.swing.JPanel panelPalabraOculta;
    private javax.swing.JPanel panelPuntaje;
    // End of variables declaration//GEN-END:variables

}
