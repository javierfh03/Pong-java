package pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import pong.entities.Pelota;
import pong.entities.Raqueta;

public class Pista extends JPanel{
    
    private Raqueta jugador1, jugador2;
    private Pelota pelota;
    private String ganador = "Ganó el jugador 1";
    
    public Pista(int Altura, int Anchura) throws HeadlessException {
        setBackground(Color.BLACK);
        setSize(Altura, Anchura);
        
        this.jugador1 = new Raqueta(this, Raqueta.JUGADOR1);
        this.jugador2 = new Raqueta(this, Raqueta.JUGADOR2);
        this.pelota = new Pelota(this);
        this.pelota.start();
    }

    public Raqueta getJugador1() {
        return jugador1;
    }

    public Raqueta getJugador2() {
        return jugador2;
    }
    
    @Override
    public void paint(Graphics g) { 
        super.paint(g);
        g.setColor(Color.WHITE);
        
        if (seguirJuego()) {
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
            pelota.parar();
            
            // Dibujamos al ganador
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            finalizarJuego(g);
        }
    }
    
    public void actualizar(){
        jugador1.moverY();
        jugador2.moverY();
    }
    
    private void finalizarJuego(Graphics g){
        FontMetrics f = g.getFontMetrics();
        
        g.drawString(ganador, (getWidth() - f.stringWidth(ganador)) / 2 , getHeight() / 2);
    }
    
    private boolean seguirJuego() {
        if (jugador1.getContador().getNumero() > 1) {
            ganador = "Ganó el jugador 1";
            return false;
        } else if (jugador2.getContador().getNumero() > 1) {
            ganador = "Ganó el jugador 2";
            return false;
        }
        
        return true;
    }
}
