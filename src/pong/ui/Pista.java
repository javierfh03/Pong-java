package pong.ui;

import java.awt.Color;
import java.awt.Font;
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
    private boolean sigueJuego;
    
    public Pista(int Altura, int Anchura) throws HeadlessException {
        setBackground(Color.BLACK);
        setSize(Altura, Anchura);
        
        this.sigueJuego = true;
        this.jugador1 = new Raqueta(this, Raqueta.JUGADOR1);
        this.jugador2 = new Raqueta(this, Raqueta.JUGADOR2);
        this.pelota = new Pelota(this);
        this.pelota.start();
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g);
        g.setColor(Color.WHITE);
        
        if (sigueJuego) {
            // Dibujamos el poste en medio de la ventana.
            g.setColor(Color.WHITE);
            g.fillRect(getWidth() / 2, 0, 5, getHeight());

            // Dibujamos los contadores.
            jugador1.getContador().dibujar(g);
            jugador2.getContador().dibujar(g);

            // Dibujamos los jugadores.
            jugador1.dibujar(g);
            actualizar();
            jugador2.dibujar(g);
            actualizar();

            // Dibujamos la pelota.
            pelota.dibujar(g);
        } else {
            g.drawString("Ganó pepe", getWidth() / 2, getHeight() / 2);
        }
    }
    
    public void actualizar(){
        jugador1.moverY();
        jugador2.moverY();
    }
}
