package pong.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import pong.entities.Pelota;
import pong.entities.Raqueta;

/**
 * Esta clase crea la pista de juego, en ella se dibujarán las raquetas, la bola 
 * y los marcadores.
 * 
 * @author javier
 */
public class Pista extends JPanel{
    
    private Raqueta jugador1, jugador2;
    private Pelota pelota;
    private String ganador;
    private final static String salir = "Pulse esc para salir";
    private final static int puntos = 10;
    
    /**
     * Inicializa la pista.
     * 
     * @param Altura Altura de la pista.
     * @param Anchura Anchura de la pista.
     */
    public Pista(int Altura, int Anchura) {
        setBackground(Color.BLACK);
        setSize(Altura, Anchura);
        
        this.jugador1 = new Raqueta(this, Raqueta.JUGADOR1);
        this.jugador2 = new Raqueta(this, Raqueta.JUGADOR2);
        this.pelota = new Pelota(this);
    }

    public Raqueta getJugador1() {
        return jugador1;
    }

    public Raqueta getJugador2() {
        return jugador2;
    }
    
    public void iniciarJuego(int velocidadPelota) {
        this.pelota.setVelocidad(velocidadPelota);
        this.pelota.start();
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
            finalizarJuego(g);
        }
    }
    
    public void actualizar(){
        jugador1.moverY();
        jugador2.moverY();
    }
    
    private void finalizarJuego(Graphics g){
        FontMetrics f;
        
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        f = g.getFontMetrics();
        g.drawString(ganador, (getWidth() - f.stringWidth(ganador)) / 2, 
                (getHeight() / 2) - 20);
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        f = g.getFontMetrics();
        g.drawString(salir, (getWidth() - 
                f.stringWidth(salir)) / 2 , (getHeight() / 2) + 40);
    }
    
    private boolean seguirJuego() {
        if (jugador1.getContador().getNumero() > puntos) {
            ganador = "Ganó el jugador 1";
            return false;
        } else if (jugador2.getContador().getNumero() > puntos) {
            ganador = "Ganó el jugador 2";
            return false;
        }
        
        return true;
    }
}
