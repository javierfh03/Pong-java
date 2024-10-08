package pong.ui;

import pong.vistas.Pista;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Esta clase recoge los eventos de teclado y permite mover las raquetas de 
 * manera sincronizada.
 * 
 * @author javier
 */
public class EventoTeclado extends KeyAdapter {

    public static boolean w, s, up, down, esc;
    private Pista panel;
    
    public EventoTeclado(Pista panel) {
        this.panel = panel;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            w = true;
        }
        
        if (id == KeyEvent.VK_S) {
            s = true;
        }
        
        if (id == KeyEvent.VK_UP) {
            up = true;
        }
        
        if (id == KeyEvent.VK_DOWN) {
            down = true;
        }
        
        if (id == KeyEvent.VK_ESCAPE){
            VentanaInicio vm = new VentanaInicio();
            VentanaJuego vj = (VentanaJuego) panel.getParent().getParent()
                    .getParent().getParent();
            
            vj.dispose();
            vm.setVisible(true);
        }
        
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            w = false;
        }
        
        if (id == KeyEvent.VK_S) {
            s = false;
        }
        
        if (id == KeyEvent.VK_UP) {
            up = false;
        }
        
        if (id == KeyEvent.VK_DOWN) {
            down = false;
        }
        
        panel.repaint();
    }
}
