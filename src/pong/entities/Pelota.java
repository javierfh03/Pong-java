package pong.entities;

import java.awt.Graphics;
import pong.ui.Pista;

public class Pelota extends Thread {

    private Pista panel;
    private int x, y, tamanio, limiteX, limiteY;
    private boolean direccionIzquierda, direccionAbajo;

    public Pelota(Pista panel) {
        this.panel = panel;
        
        this.direccionIzquierda = true;
        this.direccionAbajo = true;
        centrar();
        setTamanio(15);
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
        this.limiteY = panel.getHeight() - tamanio;
        this.limiteX = panel.getWidth() - tamanio;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            mover();
            cambiarSentido();

            panel.repaint();
        }
    }

    private void cambiarSentido() {
        if (x == 0) {
            comprobarLado();
            direccionIzquierda = false;
        }
        
        if (!(x < limiteX)) {
            comprobarLado();
            direccionIzquierda = true;
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
            x = x - 5;
        } else {
            x = x + 5;
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
    
    private void comprobarLado(){
        Raqueta jugador1 = panel.getJugador1();
        Raqueta jugador2 = panel.getJugador2();
        
        if (direccionIzquierda) {
            if (y < jugador2.getY() || y > (jugador2.getY() + jugador2.getAltura())){
                jugador1.getContador().subirNumero();
                centrar();
            }
        } else {
            if (y < jugador1.getY() || y > (jugador1.getY() + jugador1.getAltura())){
                jugador2.getContador().subirNumero();
                centrar();
            }
        }
    }
}
