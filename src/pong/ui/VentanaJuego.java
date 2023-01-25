package pong.ui;

import pong.vistas.Pista;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * Esta clase crea la ventana en la que se mostrará el juego.
 * 
 * @author javier
 */
public class VentanaJuego extends JFrame {
    
    private Pista panel;
    
    public VentanaJuego(int altura, int anchura) {
        panel = new Pista(altura, anchura);
        EventoTeclado ev = new EventoTeclado(panel);
        
        add(panel);
        addKeyListener(ev);
        
        setSize(altura, anchura);
        setUndecorated(true);
        setSize(panel.getWidth(), panel.getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
    }
    
    public void establecerVelocidad(int velocidad) {
        panel.iniciarJuego(velocidad);
    }
}
