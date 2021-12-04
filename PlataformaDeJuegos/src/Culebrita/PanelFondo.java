package Culebrita;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sam
 */
public class PanelFondo extends JPanel{
    
    Color colorfondo = Color.GRAY;
    int tammaix, tam, can, res;
    
    public PanelFondo(int tammaix, int can){
       
        this.tammaix = tammaix;
        this.can = can;
        this.tam = tammaix/can;
        this.res = tammaix&can;
    }
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorfondo);
        for(int i = 0; i < can; i++){
            for(int j = 0; j < can; j++){
                pintor.drawRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
            }
        }
    }
    
}
