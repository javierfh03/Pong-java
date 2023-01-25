package pong.entities;

import java.awt.Graphics;
import pong.vistas.Pista;

/**
 * Esta clase representa la pelota del juego, es movida por un hilo.
 * 
 * @author javier
 */
public class Pelota extends Thread {

    private Pista panel;
    private int x, y, tamanio, limiteX, limiteY, velocidad;
    private boolean direccionIzquierda, direccionAbajo, moverse;

    /**
     * Inicializa la pelota.
     * 
     * @param panel La pista a la que pertenece.
     */
    public Pelota(Pista panel) {
        this.panel = panel;
        this.moverse = true;
        this.direccionAbajo = true;
        this.direccionIzquierda = true;
        this.velocidad = 30;
        
        centrar();
        setTamanio(15);
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
        this.limiteY = panel.getHeight() - tamanio;
        this.limiteX = panel.getWidth() - tamanio;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        while (moverse) {
            try {
                sleep(velocidad);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            mover();
            cambiarSentido();

            panel.repaint();
        }
    }
    
    public synchronized void parar() {
        this.moverse = false;
    }

    private void cambiarSentido() {
        if (x == 0) {
            comprobarLado(false);
        }
        
        if (!(x < limiteX)) {
            comprobarLado(true);
        }
        
        if (y == 0) {
            direccionAbajo = true;
        }
        
        if (!(y < limiteY)) {
            direccionAbajo = false;
        }
    }

    private void mover() {
        if (direccionIzquierda) {
            x = x + 5;
        } else {
            x = x - 5;
        }
        
        if (direccionAbajo) {
            y = y + 5;
        } else {
            y = y - 5;
        }
    }

    public void dibujar(Graphics g) {
        g.fillRect(x, y, tamanio, tamanio);
    }
    
    private void centrar() {
        this.x = panel.getWidth() / 2;
        this.y = panel.getHeight() / 2;
    }
    
    private void comprobarLado(boolean izquierda){
        Raqueta jugador1 = panel.getJugador1();
        Raqueta jugador2 = panel.getJugador2();
        int posicionInferior;
        
        if (izquierda) {
            posicionInferior = jugador2.getY() + jugador2.getAltura();
            
            if (!(y > jugador2.getY() && y < posicionInferior)){
                jugador1.getContador().subirNumero();
                centrar();
            }
            
            this.direccionIzquierda = false;
        } else {
            posicionInferior = jugador1.getY() + jugador1.getAltura();
            
            if (!(y > jugador1.getY() && y < posicionInferior)){
                jugador2.getContador().subirNumero();
                centrar();
            }
            
            this.direccionIzquierda = true;
        }
    }
}
