package Culebrita;

/**
 *
 * @author Sam
 */
public class Movimiento implements Runnable{
    
    PanelCulebrita panel;
    boolean estado = true;
    
    public Movimiento(PanelCulebrita panel){
        this.panel = panel;
    }

    @Override
    public void run() {
        while(estado){
            panel.avanzar();
            panel.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    public void parar(){
        this.estado = false;
    }
 }

