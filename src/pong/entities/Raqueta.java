package pong.entities;

import java.awt.Graphics;
import pong.ui.EventoTeclado;
import pong.ui.Ventana;

public class Raqueta{
    private int x, y, anchura, altura, jugador;
    public final static byte JUGADOR1 = 1;
    public final static byte JUGADOR2 = 2;

    public Raqueta(Ventana ventana, int jugador) {
        this.anchura = 10;
        this.altura = 50;
        this.jugador = jugador;
        
        if (jugador == JUGADOR1){
            x = 1;
        } else {
            x = ventana.getWidth() - 11;
        }
        
        y = (ventana.getHeight() / 2) - 10;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }
    
    public void moverY() {
        if (jugador == JUGADOR1){
            if (EventoTeclado.w) {
                this.y = y - 10;
            }
            if (EventoTeclado.s) {
                this.y = y + 10;
            }
        } else {
            if (EventoTeclado.up) {
                this.y = y - 10;
            }
            if (EventoTeclado.down) {
                this.y = y + 10;
            }
        }
    }
    
    public void dibujar(Graphics g){
        g.fillRect(getX(), getY(), getAnchura(), getAltura());
    }
}
