package Culebrita;

import static Culebrita.Culebrita.jLabelPuntaje;
import Culebrita.Movimiento;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sam
 */
public class PanelCulebrita extends JPanel{
    
    Color colorSnake = Color.BLACK;
    Color colorComida = Color.RED;
    
    int tammaix, tam, can, res;
    
    List<int[]> snake = new ArrayList<>();
    int[] comida = new int[2];
    
    String direccion = "de";
    String direccionProxima = "de";
    
    Thread hilo;
    Movimiento mover;
    
    
    // Constructor
    public PanelCulebrita(int tammaix, int can){
        this.tammaix = tammaix;
        this.can = can;
        this.tam = tammaix/can;
        this.res = tammaix&can;
        
        int [] a = {can/2-1, can/2-1}; 
        int [] b = {can/2, can/2-1}; 
        snake.add(a);
        snake.add(b);
        
        crearComida();
        
        mover = new Movimiento(this);
        hilo = new Thread(mover);
        hilo.start();
        
        
    }
    
    
    // Metodo para pintar paneles.
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorSnake);
        
       //Coloreando mi culebrita.
       for(int[] sn1 : snake){
           pintor.fillRect(res/2+sn1[0]*tam, res/2+sn1[1]*tam, tam-1, tam-1);
       }
       
       //Colorendo ñla comida de la culebrita.
       pintor.setColor(colorComida);
       pintor.fillRect(res/2+comida[0]*tam, res/2+comida[1]*tam, tam-1, tam-1);
       
    }
    
    // Metodo para hacer que avance la culebrita
    public void avanzar(){
        igualarDireccion();
        int[] ultimo = snake.get(snake.size()-1);
        int agregarX = 0;
        int agregarY = 0;
        switch(this.direccion){
            case "de" : agregarX = 1;break;
            case "iz" : agregarX = -1;break;
            case "ar" : agregarY = -1;break;
            case "ab" : agregarY = 1;break;
            default : break;
        }
        
        int[] nuevo = {Math.floorMod(ultimo[0]+agregarX, can), Math.floorMod(ultimo[1]+agregarY,can)};
        
        boolean existe = false;
        
        for(int i = 0; i < snake.size(); i++){ 
            if(nuevo[0] == snake.get(i)[0] && nuevo[1] == snake.get(i)[1]){
                existe = true;
                break;
            }
        }
        if(existe){
            JOptionPane.showMessageDialog(this, "Has perdido");
        }else{
            if(nuevo[0] == comida[0] && nuevo[1] == comida[1]){
                snake.add(nuevo);
                crearComida();
                jLabelPuntaje.setText(Integer.toString(Integer.parseInt(jLabelPuntaje.getText())+1));
            }
            else{
                snake.add(nuevo);
                snake.remove(0);
            }
        } 
    }
    
    // Metodo para crear comida en alguna parte del panel.
    public void crearComida(){
        boolean existe = false;
        int a = (int)(Math.random()*can);
        int b = (int)(Math.random()*can);
        for(int[] par: snake){
            if(par[0] == a && par[1] == b){
                existe = true;
                crearComida();
                break;
            }
        }
        if(!existe){
            this.comida[0] = a;
            this.comida[1] = b;
        }
        
    }
    
    // Metodo para cambiar de direccion
    public void cambiarDireccion(String dir){
        if((this.direccion.equals("de")||this.direccion.equals("iz")) && (dir.equals("ar")||dir.equals("ab"))){
             this.direccionProxima = dir;
        }
        if((this.direccion.equals("ar")||this.direccion.equals("ab")) && (dir.equals("iz")||dir.equals("de"))){
             this.direccionProxima = dir;
        }
       
    }
    
    public void igualarDireccion(){
        this.direccion = this.direccionProxima;
    }
}
