package pong.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JPanel;
import pong.entities.Pelota;
import pong.entities.Raqueta;

/**
 *
 * @author javier
 */
public class Pista extends JPanel{
    
    private Raqueta jugador1, jugador2;
    private Pelota pelota;
    
    public Pista() throws HeadlessException {
        setBackground(Color.BLACK);
        setSize(600, 400);
        
        System.out.println(getHeight());
        
        jugador1 = new Raqueta(this, Raqueta.JUGADOR1);
        jugador2 = new Raqueta(this, Raqueta.JUGADOR2);
        pelota = new Pelota(this);
        pelota.start();
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g);
        
        // Dibujamos el poste en medio de la ventana.
        g.setColor(Color.WHITE);
        g.fillRect(getWidth() / 2, 0, 2, getHeight());
        
        // Dibujamos los jugadores.
        jugador1.dibujar(g);
        actualizar();
        jugador2.dibujar(g);
        actualizar();
        
        // Dibujamos la pelota.
        pelota.dibujar(g);
    }
    
    public void actualizar(){
        jugador1.moverY();
        jugador2.moverY();
    }
}
