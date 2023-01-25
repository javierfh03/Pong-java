package pong.ui;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * Esta clase crea la ventana perincipal en la que se verá
 * el juego.
 * 
 * @author javier
 */
public class VentanaJuego extends JFrame {
    
    private final static int ALTURA = 600;
    private final static int ANCHURA = 400;
    
    public VentanaJuego() {
        Pista panel = new Pista(ALTURA, ANCHURA);
        EventoTeclado ev = new EventoTeclado(panel);
        
        add(panel);
        addKeyListener(ev);
        
        setSize(ALTURA, ANCHURA);
        setUndecorated(true);
        setSize(panel.getWidth(), panel.getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
    }
}
