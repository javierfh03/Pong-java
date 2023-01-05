package pong.entities;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong.ui.Ventana;

public class Pelota extends Thread {

    private Ventana ventana;
    private int x, y;
    private boolean direccionIzquierda, direccionAbajo;

    public Pelota(Ventana ventana) {
        direccionIzquierda = true;
        direccionAbajo = true;

        this.ventana = ventana;
        this.x = ventana.getWidth() / 2;
        this.y = ventana.getHeight() / 2;
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

            ventana.repaint();
        }
    }

    private void cambiarSentido() {
        if (x == 0) {
            direccionIzquierda = false;
        }
        
        if (x == ventana.getWidth()) {
            direccionIzquierda = true;
        }
        
        if (y == 0) {
            direccionAbajo = true;
        }
        
        if (y == ventana.getHeight()) {
            direccionAbajo = false;
        }
    }

    private void mover() {
        if (direccionIzquierda) {
            x = x - 10;
        } else {
            x = x + 10;
        }
        
        if (direccionAbajo) {
            y = y + 10;
        } else {
            y = y - 10;
        }
    }

    public void dibujar(Graphics g) {
        g.fillRect(x, y, 10, 10);
    }
}
